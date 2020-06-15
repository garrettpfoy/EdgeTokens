package org.edgegamers.picklez.Hooks;

import me.clip.placeholderapi.PlaceholderHook;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.edgegamers.picklez.Main.EdgeTokens;
import org.edgegamers.picklez.Storage.PlayerCache;

public class TokenPlaceholder extends PlaceholderExpansion {

    private EdgeTokens plugin;

    public TokenPlaceholder(EdgeTokens plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public String getAuthor() {
        return "PickleZ";
    }

    @Override
    public String getIdentifier() {
        return "tokens";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if(player == null) {
            return "";
        }

        if(identifier.equalsIgnoreCase("balance")) {
            PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
            return String.valueOf(cache.getTokens());
        }

        return null;

    }

}
