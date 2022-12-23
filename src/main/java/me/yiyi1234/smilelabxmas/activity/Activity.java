package me.yiyi1234.smilelabxmas.activity;

import me.yiyi1234.smilelabxmas.SmileLabXMas;
import me.yiyi1234.smilelabxmas.core.XMasPlayer;
import me.yiyi1234.smilelabxmas.manager.XMasPlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class Activity {
    public long startTime = 0;
    public void StartActivity1() {
        startTime = System.currentTimeMillis();
        for (Player p : Bukkit.getOnlinePlayers()) {

            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6雪球大戰 開始了！"));
            XMasPlayerManager.getXMasPlayer(p.getUniqueId()).setCurrState(XMasPlayer.State.Activity1);
        }

        Bukkit.getScheduler().scheduleSyncDelayedTask(SmileLabXMas.getInstance(), new Runnable() {
            @Override
            public void run() {
                startTime = 0;
                for (Player p : Bukkit.getOnlinePlayers()) {
                    XMasPlayerManager.getXMasPlayer(p.getUniqueId()).setCurrState(XMasPlayer.State.IDLE);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6雪球大戰 結束了！"));

                }
            }
        }, 36000);

    }

    public void StartActivity2() {
        startTime = System.currentTimeMillis();
        for (Player p : Bukkit.getOnlinePlayers()) {
            XMasPlayerManager.getXMasPlayer(p.getUniqueId()).setCurrState(XMasPlayer.State.Activity2);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6科技槍戰 開始了！"));

        }

        Bukkit.getScheduler().scheduleSyncDelayedTask(SmileLabXMas.getInstance(), new Runnable() {
            @Override
            public void run() {
                startTime = 0;
                for (Player p : Bukkit.getOnlinePlayers()) {
                    XMasPlayerManager.getXMasPlayer(p.getUniqueId()).setCurrState(XMasPlayer.State.IDLE);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6科技槍戰 結束了！"));

                }
            }
        }, 36000);

    }
    public void StartActivity3() {
        startTime = System.currentTimeMillis();
        for (Player p : Bukkit.getOnlinePlayers()) {
            XMasPlayerManager.getXMasPlayer(p.getUniqueId()).setCurrState(XMasPlayer.State.Activity3);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6冬季雪球大戰 開始了！"));

        }

        Bukkit.getScheduler().scheduleSyncDelayedTask(SmileLabXMas.getInstance(), new Runnable() {
            @Override
            public void run() {
                startTime = 0;
                for (Player p : Bukkit.getOnlinePlayers()) {
                    XMasPlayerManager.getXMasPlayer(p.getUniqueId()).setCurrState(XMasPlayer.State.IDLE);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6冬季雪球大戰 結束了！"));
                }
            }
        }, 36000);
    }
}
