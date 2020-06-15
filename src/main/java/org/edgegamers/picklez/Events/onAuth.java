package org.edgegamers.picklez.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.edgegamers.picklez.Storage.PlayerCache;
import org.edgegamers.picklez.Storage.TokenDatabase;

import java.util.UUID;

public class onAuth implements Listener {

    @EventHandler
    public void onPlayerAuth(AsyncPlayerPreLoginEvent event) {
        final UUID uuid = event.getUniqueId();

        if(event.getLoginResult() == AsyncPlayerPreLoginEvent.Result.ALLOWED) {
            final PlayerCache cache = PlayerCache.getCache(uuid);

            TokenDatabase.getInstance().load(uuid, cache);
        }
    }
}
