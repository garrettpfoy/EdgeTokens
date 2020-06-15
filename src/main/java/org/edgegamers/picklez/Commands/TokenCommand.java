package org.edgegamers.picklez.Commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.edgegamers.picklez.Menus.BaseMenu;
import org.edgegamers.picklez.Menus.VillageKitMenu;
import org.edgegamers.picklez.Storage.PlayerCache;
import org.edgegamers.picklez.Storage.TokenConfig;
import org.edgegamers.picklez.Storage.TokenDatabase;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.Collections;
import java.util.UUID;

public class TokenCommand extends SimpleCommand {

    public TokenCommand() {
        super("tokens", Collections.singletonList("token"));
        setDescription("Used to give, take, or get tokens.");
        setPermission("tokens.use");
        setUsage("/tokens <give/take/get/bal> [Player] {amount}");
        setAutoHandleHelp(false);
    }

    @Override
    public void onCommand() {
        //Let's make sure we have enough arguments!
        if(args.length == 0) {
            Common.tell(getPlayer(), "&8&l&m---------------[&r &9&lEdge&1&f&lTokens&r &8&l&m]---------------");
            Common.tell(getPlayer(), "&7");
            Common.tell(getPlayer(), "&9/tokens bal &1- &fGet your current tokens balance");
            Common.tell(getPlayer(), "&9/tokens get [Player] &1- &fGet another player's balance");
            Common.tell(getPlayer(), "&9/tokens give [Player] [Amount] &1- &fGive tokens to a player");
            Common.tell(getPlayer(), "&9/tokens take [Player] [Amount] &1- &fTake tokens from a player");
            Common.tell(getPlayer(), "&7");
            Common.tell(getPlayer(), "&8&l---------------------------------------------");
            return;
        }
        if(args[0].equalsIgnoreCase("bal")) {
            if(!(getPlayer().hasPermission("tokens.bal"))) {
                Common.tell(getPlayer(), "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have permission for that command!");
                return;
            }
            //Self balance command
            PlayerCache cache = PlayerCache.getCache(getPlayer().getUniqueId());
            Common.tell(getPlayer(), "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYour token count is: &f" + cache.getTokens());
            return;
        }
        else if(args[0].equalsIgnoreCase("get") && args.length == 2) {
            if(!(getPlayer().hasPermission("tokens.get"))) {
                Common.tell(getPlayer(), "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have permission for that command!");
                return;
            }
            //Get command!
            Player player = Bukkit.getPlayer(args[1]);
            PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
            Common.tell(getPlayer(), "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &f" + player.getName() + "'s &btoken balance is: &f" + cache.getTokens());
            return;
        }
        else if(args[0].equalsIgnoreCase("take") && args.length == 3) {
            if(getSender() instanceof Player) {
                if (!(getPlayer().hasPermission("tokens.take"))){
                    Common.tell(getPlayer(), "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have permission for that command!");
                    return;
                }
            }
            Player player = Bukkit.getPlayer(args[1]);
            PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
            cache.setTokens(cache.getTokens() - Integer.parseInt(args[2]));
            Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &f" + args[2] + " &btokens have been taken from your account. Tokens leftover: &f" + cache.getTokens());
            return;
        }
        else if(args[0].equalsIgnoreCase("give") && args.length == 3) {
            if(getSender() instanceof Player) {
                if (!(getPlayer().hasPermission("tokens.give"))){
                    Common.tell(getPlayer(), "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have permission for that command!");
                    return;
                }
            }
            Player player = Bukkit.getPlayer(args[1]);
            PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
            cache.setTokens(cache.getTokens() + Integer.parseInt(args[2]));
            Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &f" + args[2] + " &btokens have been added to your account. Tokens balance: &f" + cache.getTokens());
            return;
        }
        else if(args[0].equalsIgnoreCase("shop")) {
            if(!(getPlayer().hasPermission("tokens.shop"))) {
                Common.tell(getPlayer(), "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have permission for that command!");
                return;
            }

            new BaseMenu().displayTo(getPlayer());
            Common.tell(getPlayer(), "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have opened the token shop menu!");
        }
        else if(args[0].equalsIgnoreCase("giveall") && args.length == 2) {
            if(getSender() instanceof Player) {
                if (!(getPlayer().hasPermission("tokens.give.all"))){
                    Common.tell(getPlayer(), "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have permission for that command!");
                    return;
                }
            }

            for(Player player : Bukkit.getOnlinePlayers()) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                cache.setTokens(cache.getTokens() + Integer.parseInt(args[1]));
            }
            Common.broadcast("&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bEveryone on the server has been given &f" + args[1] + " &btokens thanks to &f" + getPlayer().getDisplayName());
        }

        else if(args[0].equalsIgnoreCase("buykits")) {
            new VillageKitMenu().displayTo(getPlayer());
        }

        else if(args[0].equalsIgnoreCase("reload")) {

            if(!getPlayer().hasPermission("tokens.reload")) {
                Common.tell(getPlayer(), "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bNo permission!");
                return;
            }

            for(Player player : Bukkit.getOnlinePlayers()) {
                UUID uuid = player.getUniqueId();
                PlayerCache cache = PlayerCache.getCache(uuid);

                Common.runLaterAsync(() -> TokenDatabase.getInstance().save(player.getName(), uuid, cache));
            }

            TokenConfig config = new TokenConfig();

            Common.tell(getPlayer(), "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bPlayer's tokens have been saved, and config has been reloaded!");
        }

        else {
            Common.tell(getPlayer(), "&8&l&m---------------[&r &9&lEdge&1-&f&lTokens&r &8&l&m]---------------");
            Common.tell(getPlayer(), "&7");
            Common.tell(getPlayer(), "&9/tokens bal &1- &fGet your current tokens balance");
            Common.tell(getPlayer(), "&9/tokens get [Player] &1- &fGet another player's balance");
            Common.tell(getPlayer(), "&9/tokens give [Player] [Amount] &1- &fGive tokens to a player");
            Common.tell(getPlayer(), "&9/tokens take [Player] [Amount] &1- &fTake tokens from a player");
            Common.tell(getPlayer(), "&7");
            Common.tell(getPlayer(), "&8&l---------------------------------------------");
        }
    }
}
