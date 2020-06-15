package org.edgegamers.picklez.Main;

import me.clip.placeholderapi.PlaceholderAPI;
import net.luckperms.api.LuckPerms;
import net.milkbowl.vault.VaultEco;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;
import org.edgegamers.picklez.Commands.BalanceCommand;
import org.edgegamers.picklez.Commands.TokenCommand;
import org.edgegamers.picklez.Events.onAuth;
import org.edgegamers.picklez.Events.onQuit;
import org.edgegamers.picklez.Hooks.TokenPlaceholder;
import org.edgegamers.picklez.Hooks.VaultEconomy;
import org.edgegamers.picklez.Storage.PlayerCache;
import org.edgegamers.picklez.Storage.TokenConfig;
import org.edgegamers.picklez.Storage.TokenDatabase;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.model.HookManager;
import org.mineacademy.fo.plugin.SimplePlugin;

import java.util.UUID;

public class EdgeTokens extends SimplePlugin {

    private Economy econ;
    private static LuckPerms api;

    @Override
    public void onPluginStart() {
        getLogger().info("Attempting to load EdgeTokens");
        getLogger().info("Author: PickleZ / Garrett Foy");
        getLogger().info("Version: 1.0.0-BETA");
        getLogger().info("Attempting to load Configuration files...");
        //Load Configuration Files
        TokenConfig config = new TokenConfig();

        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            api = provider.getProvider();
        }

        getLogger().info("Attempting to load Listeners...");
        //Load Listeners
        registerEvents(new onAuth());
        registerEvents(new onQuit());

        getLogger().info("Attempting to load Commands...");
        //Load Commands
        registerCommand(new TokenCommand());

        getLogger().info("Connecting to mySQL Databyellow_wool,ase");
        //Initialize mySQL Connection
        TokenDatabase.getInstance().connect(config.getHost(), config.getPort(), config.getDatabase(), config.getUsername(), config.getPassword(), config.getTable());

        getLogger().info("Attempting to load vault...");
        //Load menus if needed
        if (!setupEconomy()) {
            getLogger().info("Disabled due to no Vault Dependency found!");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        new BalanceCommand().register(true);


        getLogger().info("Hooking into PlaceholderAPI");
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new TokenPlaceholder(this).register();
        }
        getLogger().info("Done!");

    }

    @Override
    public void onPluginStop() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            UUID uuid = player.getUniqueId();
            PlayerCache cache = PlayerCache.getCache(uuid);

            Common.runLaterAsync(() -> TokenDatabase.getInstance().save(player.getName(), uuid, cache));
        }
    }

    private boolean setupEconomy() {
        if(Bukkit.getPluginManager().getPlugin("Vault") == null) {
            return false;
        }

        getServer().getServicesManager().register(Economy.class, new VaultEconomy(), Bukkit.getPluginManager().getPlugin("Vault"), ServicePriority.Highest);
        return true;
    }

    public static LuckPerms getPerms() {
        return api;
    }

}
