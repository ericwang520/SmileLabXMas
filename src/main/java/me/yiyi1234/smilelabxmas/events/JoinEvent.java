package me.yiyi1234.smilelabxmas.events;

import me.yiyi1234.smilelabxmas.manager.XMasPlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class JoinEvent implements Listener {
    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        XMasPlayerManager.createXMasPlayer(event.getPlayer());
    }
}
