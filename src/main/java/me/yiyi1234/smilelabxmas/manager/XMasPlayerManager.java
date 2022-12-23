package me.yiyi1234.smilelabxmas.manager;

import me.yiyi1234.smilelabxmas.SmileLabXMas;
import me.yiyi1234.smilelabxmas.core.XMasPlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class XMasPlayerManager {
    public static HashMap<UUID, XMasPlayer> xMasPlayerHashMap = new HashMap<>();

    public static void createXMasPlayer(Player player) {
        int points = SmileLabXMas.getInstance().sqlGetter.getPlayerPoints(player.getUniqueId());
        XMasPlayer xMasPlayer = new XMasPlayer(points, XMasPlayer.State.IDLE);
        xMasPlayerHashMap.put(player.getUniqueId(),xMasPlayer);
    }
    public static void saveXMasPlayer(Player player) {
        SmileLabXMas.getInstance().sqlPutter.saveXMasPlayer(player);
        xMasPlayerHashMap.remove(player.getUniqueId());
    }


    public static XMasPlayer getXMasPlayer(UUID playerUUID) {
        return xMasPlayerHashMap.get(playerUUID);
    }
}
