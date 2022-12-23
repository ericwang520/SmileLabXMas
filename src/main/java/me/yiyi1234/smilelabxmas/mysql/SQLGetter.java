package me.yiyi1234.smilelabxmas.mysql;

import me.yiyi1234.smilelabxmas.SmileLabXMas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class SQLGetter {
    public SmileLabXMas plugin;

    public SQLGetter(SmileLabXMas plugin) {
        this.plugin = plugin;
    }


    public void createTable() {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS SmileLabXMas (name VARCHAR(50),uuid VARCHAR(50), point INTEGER);");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getPlayerPoints(UUID playerUUID) {

        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM SmileLabXMas where uuid=?;");
            ps.setString(1, playerUUID.toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("point");
            }
        }catch (SQLException e) {
            e.printStackTrace();

        }
        return 0;
    }
    public String getTheHighestPoints() {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT MAX(point) FROM SmileLabXMas;");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();

        }
        return "目前沒有最高分";
    }

    public String HighestPlayerUUID(int points) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM SmileLabXMas where point=?;");
            ps.setInt(1, points);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("uuid");
            }
        }catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

}
