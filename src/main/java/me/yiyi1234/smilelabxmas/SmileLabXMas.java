package me.yiyi1234.smilelabxmas;

import me.yiyi1234.smilelabxmas.activity.Activity;
import me.yiyi1234.smilelabxmas.commands.SmileLabXMasCommand;
import me.yiyi1234.smilelabxmas.events.EntityDamageEntity;
import me.yiyi1234.smilelabxmas.events.JoinEvent;
import me.yiyi1234.smilelabxmas.events.LeaveEvent;
import me.yiyi1234.smilelabxmas.events.ShotSnowBall;
import me.yiyi1234.smilelabxmas.manager.XMasPlayerManager;
import me.yiyi1234.smilelabxmas.mysql.MySQL;
import me.yiyi1234.smilelabxmas.mysql.SQLGetter;
import me.yiyi1234.smilelabxmas.mysql.SQLPutter;
import me.yiyi1234.smilelabxmas.placeholder.Point;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.sql.SQLException;

public final class SmileLabXMas extends JavaPlugin {
    private static SmileLabXMas instance;
    public MySQL SQL;
    public SQLGetter sqlGetter;
    public SQLPutter sqlPutter;
    public Activity activity;
    private FileConfiguration config;
    @Override
    public void onEnable() {
        // Plugin startup logic
        setInstance(this);
        config();
        this.SQL = new MySQL();
        this.sqlGetter = new SQLGetter(this);
        this.sqlPutter = new SQLPutter(this);
        this.activity = new Activity();

        try {
            SQL.connect();
        } catch (SQLException throwables) {
            Bukkit.getLogger().info(ChatColor.translateAlternateColorCodes('&', "&7<&6SmileLabXMas&7> &c資料庫連線失敗"));
            this.getServer().getPluginManager().disablePlugin(this);
        }

        if (SQL.isConnected()) {
            sqlGetter.createTable();
            Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
            Bukkit.getPluginManager().registerEvents(new EntityDamageEntity(), this);
            Bukkit.getPluginManager().registerEvents(new LeaveEvent(), this);
            Bukkit.getPluginManager().registerEvents(new ShotSnowBall(), this);
            getCommand("SmileLabXMas").setExecutor(new SmileLabXMasCommand());
            getCommand("SmileLabXMas").setTabCompleter(new SmileLabXMasCommand());
            if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
                new Point(this).register();
            }
            runTask();
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7<&6SmileLabXMas&7> &aSmileLabXMas Version 1.0 啟動成功"));
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7<&6SmileLabXMas&7> &6製作者 依依#1350"));
        }
    }
    public void config() {
        File file = new File(this.getDataFolder().getAbsolutePath() + "/config.yml");
        if (!file.exists()) {
            Bukkit.getConsoleSender().sendMessage("§7<§6EasyConsumable§7> §f正在生成config！");
            this.getDataFolder().mkdir();
            this.saveResource("config.yml", false);

        }

        config = YamlConfiguration.loadConfiguration(file);

        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runTask() {
        this.getServer().getScheduler().scheduleSyncRepeatingTask(this,()->{
            for (Player p : Bukkit.getOnlinePlayers()) {
                SmileLabXMas.getInstance().sqlPutter.saveXMasPlayer(p);
            }

        }, 1000,12000);
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SmileLabXMas getInstance() {
        return instance;
    }

    public static void setInstance(SmileLabXMas instance) {
        SmileLabXMas.instance = instance;
    }

}
