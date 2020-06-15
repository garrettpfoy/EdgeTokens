package org.edgegamers.picklez.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.edgegamers.picklez.Storage.PlayerCache;
import org.edgegamers.picklez.Storage.TokenDatabase;
import org.mineacademy.fo.Common;

import java.util.UUID;

public class onQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        final UUID uuid = event.getPlayer().getUniqueId();
        final PlayerCache cache = PlayerCache.getCache(uuid);

        Common.runLaterAsync(() -> TokenDatabase.getInstance().save(event.getPlayer().getName(), uuid, cache));

    }
}
