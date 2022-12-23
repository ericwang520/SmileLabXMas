package me.yiyi1234.smilelabxmas.events;

import me.yiyi1234.smilelabxmas.core.XMasPlayer;
import me.yiyi1234.smilelabxmas.manager.XMasPlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ShotSnowBall implements Listener {
    @EventHandler
    public void onShot(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            if (event.getDamager() instanceof Snowball) {

                Player player = (Player) event.getEntity();
                if (XMasPlayerManager.getXMasPlayer(player.getUniqueId()).getCurrState() == XMasPlayer.State.Activity2) {
                    event.setDamage(10);
                }
            }

        }
    }
}
