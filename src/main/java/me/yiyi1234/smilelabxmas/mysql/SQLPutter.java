package me.yiyi1234.smilelabxmas.mysql;

import me.yiyi1234.smilelabxmas.SmileLabXMas;
import me.yiyi1234.smilelabxmas.manager.XMasPlayerManager;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SQLPutter {
    public SmileLabXMas plugin;
    public SQLPutter(SmileLabXMas plugin) {
        this.plugin = plugin;
    }

    public void saveXMasPlayer(Player player) {
        if (!exists(player.getUniqueId())) {
            try {
                PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("INSERT INTO SmileLabXMas VALUES (?,?,?);");
                ps.setString(1, player.getName());
                ps.setString(2, player.getUniqueId().toString());
                ps.setInt(3, XMasPlayerManager.getXMasPlayer(player.getUniqueId()).getPoints());
                ps.executeUpdate();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            try {
                PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE SmileLabXMas SET point=? WHERE uuid=?;");
                ps.setInt(1, XMasPlayerManager.getXMasPlayer(player.getUniqueId()).getPoints());
                ps.setString(2, player.getUniqueId().toString());
                ps.executeUpdate();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean exists(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM SmileLabXMas WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet results = ps.executeQuery();
            if (results.next()) {
                return true;
            }
            return false;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
