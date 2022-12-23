package me.yiyi1234.smilelabxmas.commands;

import me.yiyi1234.smilelabxmas.SmileLabXMas;
import me.yiyi1234.smilelabxmas.core.XMasPlayer;
import me.yiyi1234.smilelabxmas.manager.XMasPlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SmileLabXMasCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("SmileLabXMas.op")) {
            if (args.length < 1) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7SmileLabXMas 指令介面"));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7# /SmileLabXMas start Activity1 開始冬季雪球大戰"));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7# /SmileLabXMas start Activity2 開始科技槍戰"));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7# /SmileLabXMas start Activity3 開始喪屍圍城"));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7# /SmileLabXMas end 強制結束所有活動"));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6製作者: 依依#1350 &7| &bVersion &e1.0"));
            }
            if (args[0].equalsIgnoreCase("start")) {
                if (args[1].equalsIgnoreCase("Activity1")) {
                    SmileLabXMas.getInstance().activity.StartActivity1();
                }
                if (args[1].equalsIgnoreCase("Activity2")) {
                    SmileLabXMas.getInstance().activity.StartActivity2();
                }
                if (args[1].equalsIgnoreCase("Activity3")) {
                    SmileLabXMas.getInstance().activity.StartActivity3();
                }
            }

            if (args[0].equalsIgnoreCase("end")) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    XMasPlayerManager.getXMasPlayer(p.getUniqueId()).setCurrState(XMasPlayer.State.IDLE);
                    SmileLabXMas.getInstance().activity.startTime = 0;
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c遊戲結束！"));

                }
            }
            return false;
        }
        return false;
    }


    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            List<String> arguments = new ArrayList<>();
            arguments.add("start");
            arguments.add("end");
            return arguments;
        }
        if (args[0].equalsIgnoreCase("start")) {
            List<String> arguments = new ArrayList<>();
            arguments.add("Activity1");
            arguments.add("Activity2");
            arguments.add("Activity3");
            return arguments;

        }
        return null;
    }
}
