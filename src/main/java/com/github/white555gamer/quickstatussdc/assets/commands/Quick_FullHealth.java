package com.github.white555gamer.quickstatussdc.assets.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

import static com.github.white555gamer.quickstatussdc.assets.messages.Quick_FFR_Msg.*;
import static com.github.white555gamer.quickstatussdc.assets.messages.TemplateMsg.MissingArg;
import static com.github.white555gamer.quickstatussdc.assets.messages.TemplateMsg.NonExistentPlayer;

public class Quick_FullHealth implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {

            if (sender instanceof Player){
                ((Player) sender).setHealth(((Player) sender).getHealthScale());
                sender.sendMessage(Quick_FullHealth_BaseMsg);
            } else {
                sender.sendMessage(MissingArg);
            }
            return true;

        } else if (args.length == 1) {

            Player player = Bukkit.getPlayer(args[0]);
            if (player != null) {
                player.setHealth(player.getHealthScale());
                if (sender.getName() == player.getName()) {
                    player.sendMessage(Quick_FullHealth_BaseMsg);
                } else {
                    sender.sendMessage(Quick_FullHealth_BaseMsgFor(player.getName()));
                    player.sendMessage(Quick_FullHealth_BaseMsgBy(sender.getName()));
                }
            } else {
                sender.sendMessage(NonExistentPlayer);
            }
            return true;

        } else {
            sender.sendMessage(MissingArg);
            return true;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
