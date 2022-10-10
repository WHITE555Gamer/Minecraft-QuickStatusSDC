package com.github.white555gamer.quickstatussdc.assets.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

import static org.bukkit.Bukkit.getServer;
import static org.bukkit.ChatColor.*;

public class ShareLocation implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Location PlayerLoc = ((Player) sender).getLocation();
            String PlayerLocData = "World: " + PlayerLoc.getWorld().getName() + "\n" +
                    "X(Block X): " + PlayerLoc.getX() + "(" + PlayerLoc.getBlockX() + ")\n" +
                    "Y(Block Y): " + PlayerLoc.getY() + "(" + PlayerLoc.getBlockY() + ")\n" +
                    "Z(Block Z): " + PlayerLoc.getZ() + "(" + PlayerLoc.getBlockZ() + ")";
            ((Player) sender).chat(PlayerLocData);
            return true;

        } else {

            sender.sendMessage(RED + "Server can't do this command." + RESET);
            return true;

        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
