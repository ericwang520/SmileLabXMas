package me.yiyi1234.smilelabxmas.placeholder;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.yiyi1234.smilelabxmas.SmileLabXMas;
import me.yiyi1234.smilelabxmas.core.XMasPlayer;
import me.yiyi1234.smilelabxmas.manager.XMasPlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class Point extends PlaceholderExpansion {
    private final SmileLabXMas plugin;
    public Point(SmileLabXMas plugin) {this.plugin = plugin;}

    @Override
    public @NotNull String getIdentifier() {
        return "SmileLabXMas";
    }

    @Override
    public @NotNull String getAuthor() {
        return "yiyi1234";
    }

    @Override
    public @NotNull String getVersion() {
        return null;
    }
    @Override
    public boolean persist() {
        return true;
    }
    @Override
    public String onRequest(OfflinePlayer player, String params) {
        String[] args = params.split("_");
        if (args.length < 1) {
            return null;
        }
        if (args[0].equalsIgnoreCase("points")) {
            return String.valueOf(XMasPlayerManager.getXMasPlayer(player.getUniqueId()).getPoints());
        }
        if (args[0].equalsIgnoreCase("time")) {
            if (SmileLabXMas.getInstance().activity.startTime == 0) {
                return "活動尚未開始";
            }
            long startSec = (System.currentTimeMillis() - SmileLabXMas.getInstance().activity.startTime)/1000;
            return startSec/60 +":" + startSec%60;

        }
        if (args[0].equalsIgnoreCase("state")) {
            if (XMasPlayerManager.getXMasPlayer(player.getUniqueId()).getCurrState() == XMasPlayer.State.IDLE) {
                return "你沒有參加任何活動";
            }
            if (XMasPlayerManager.getXMasPlayer(player.getUniqueId()).getCurrState() == XMasPlayer.State.Activity1) {
                return "正在參加 冬季雪球大戰";
            }
            if (XMasPlayerManager.getXMasPlayer(player.getUniqueId()).getCurrState() == XMasPlayer.State.Activity2) {
                return "正在參加 科技槍戰";
            }
            if (XMasPlayerManager.getXMasPlayer(player.getUniqueId()).getCurrState() == XMasPlayer.State.Activity3) {
                return "正在參加 喪屍圍城";
            }
        }
        if (args[0].equalsIgnoreCase("highestplayer")) {
            if (SmileLabXMas.getInstance().sqlGetter.HighestPlayerUUID(Integer.valueOf(SmileLabXMas.getInstance().sqlGetter.getTheHighestPoints())) != null) {
                UUID uuid = UUID.fromString(SmileLabXMas.getInstance().sqlGetter.HighestPlayerUUID(Integer.valueOf(SmileLabXMas.getInstance().sqlGetter.getTheHighestPoints())));
                return Bukkit.getOfflinePlayer(uuid).getName();
            }
            return "目前沒有最高分的玩家";
        }
        if (args[0].equalsIgnoreCase("highestpoints")) {
            return String.valueOf(SmileLabXMas.getInstance().sqlGetter.getTheHighestPoints());
        }


        return null;
    }
}
