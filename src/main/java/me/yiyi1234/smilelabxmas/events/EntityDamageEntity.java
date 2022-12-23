package me.yiyi1234.smilelabxmas.events;

import me.yiyi1234.smilelabxmas.SmileLabXMas;
import me.yiyi1234.smilelabxmas.core.XMasPlayer;
import me.yiyi1234.smilelabxmas.manager.XMasPlayerManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDamageEntity implements Listener {
    @EventHandler
    public void onEntityDamage(EntityDeathEvent event) {

        if (event.getEntity().getKiller() != null) {
            Player killer = event.getEntity().getKiller();
            // 擊殺玩家
            if (XMasPlayerManager.getXMasPlayer(killer.getUniqueId()).getCurrState() == XMasPlayer.State.Activity1) {
                // 擊殺玩家
                if (event.getEntityType() == EntityType.PLAYER) {
                    XMasPlayer xMasPlayer = XMasPlayerManager.getXMasPlayer(killer.getUniqueId());
                    xMasPlayer.setPoints(xMasPlayer.getPoints() + 20);
                    killer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &6由於您擊殺一名玩家，您將獲得 20 點積分。 &7(目前擁有 " + xMasPlayer.getPoints() + " 點積分)"));
                }
                if (event.getEntity().getType() == EntityType.ZOMBIE) {
                    XMasPlayer xMasPlayer = XMasPlayerManager.getXMasPlayer(killer.getUniqueId());
                    xMasPlayer.setPoints(xMasPlayer.getPoints() + 10);
                    killer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &6由於您擊殺一隻 喪狂病屍，您將獲得 10 點積分。 &7(目前擁有 " + xMasPlayer.getPoints() + " 點積分)"));
                }
            }

            if (XMasPlayerManager.getXMasPlayer(killer.getUniqueId()).getCurrState() == XMasPlayer.State.Activity2) {
                if (event.getEntityType() == EntityType.PLAYER) {
                    XMasPlayer xMasPlayer = XMasPlayerManager.getXMasPlayer(killer.getUniqueId());
                    xMasPlayer.setPoints(xMasPlayer.getPoints() + 20);
                    killer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &6由於您擊殺一名玩家，您將獲得 20 點積分。 &7(目前擁有 " + xMasPlayer.getPoints() + " 點積分)"));
                }
                if (event.getEntity().getType() == EntityType.SKELETON) {
                    XMasPlayer xMasPlayer = XMasPlayerManager.getXMasPlayer(killer.getUniqueId());
                    xMasPlayer.setPoints(xMasPlayer.getPoints() + 10);
                    killer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &6由於您擊殺一隻 惡靈骨骷，您將獲得 10 點積分。 &7(目前擁有 " + xMasPlayer.getPoints() + " 點積分)"));
                }
            }
            if (XMasPlayerManager.getXMasPlayer(killer.getUniqueId()).getCurrState() == XMasPlayer.State.Activity3) {
                if (event.getEntityType() == EntityType.SKELETON) {
                    XMasPlayer xMasPlayer = XMasPlayerManager.getXMasPlayer(killer.getUniqueId());
                    xMasPlayer.setPoints(xMasPlayer.getPoints() + 30);
                    killer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &6由於您擊殺一隻 惡靈骨骷，您將獲得 30 點積分。 &7(目前擁有 " + xMasPlayer.getPoints() + " 點積分)"));
                }
                if (event.getEntityType() == EntityType.WITHER_SKELETON) {
                    XMasPlayer xMasPlayer = XMasPlayerManager.getXMasPlayer(killer.getUniqueId());
                    xMasPlayer.setPoints(xMasPlayer.getPoints() + 100);
                    killer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &6由於您擊殺一隻 骸骨屍王，您將獲得 100 點積分。 &7(目前擁有 " + xMasPlayer.getPoints() + " 點積分)"));
                }
                if (event.getEntityType() == EntityType.ZOMBIE) {
                    if (event.getEntity().getName().contains("§7『§6§l§n活動§7』§c屍王")) {
                        XMasPlayer xMasPlayer = XMasPlayerManager.getXMasPlayer(killer.getUniqueId());
                        xMasPlayer.setPoints(xMasPlayer.getPoints() + 100);
                        killer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &6由於您擊殺一隻 屍王，您將獲得 100 點積分。 &7(目前擁有 " + xMasPlayer.getPoints() + " 點積分)"));
                    }
                    if (event.getEntity().getName().contains("§7『§6§l§n活動§7』§c喪狂病屍")) {
                        XMasPlayer xMasPlayer = XMasPlayerManager.getXMasPlayer(killer.getUniqueId());
                        xMasPlayer.setPoints(xMasPlayer.getPoints() + 10);
                        killer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &6由於您擊殺一隻 喪狂病屍，您將獲得 10 點積分。 &7(目前擁有 " + xMasPlayer.getPoints() + " 點積分)"));
                    }
                }
            }
        }
    }
}
