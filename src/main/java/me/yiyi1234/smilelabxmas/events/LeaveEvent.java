package me.yiyi1234.smilelabxmas.events;

import me.yiyi1234.smilelabxmas.manager.XMasPlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {
    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        XMasPlayerManager.saveXMasPlayer(event.getPlayer());
    }
}
