package com.github.white555gamer.quickstatussdc;

import com.github.white555gamer.quickstatussdc.assets.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class QuickStatusSDC extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("QuickStatusSDC Enabled...");
        getServer().broadcastMessage("QuickStatusSDC Enabled...");

        getCommand("quick_fullfood").setExecutor(new Quick_FullFood());
        getCommand("quick_fullhealth").setExecutor(new Quick_FullHealth());
        getCommand("quick_recovery").setExecutor(new Quick_Recovery());
        getCommand("sharelocation").setExecutor(new ShareLocation());
    }

    @Override
    public void onDisable() {
        getLogger().info("QuickStatusSDC Disabled...");
        getServer().broadcastMessage("QuickStatusSDC Disabled...");
    }

    @Override
    public void onLoad() {
        getLogger().info("QuickStatusSDC Loaded...");
        getServer().broadcastMessage("QuickStatusSDC Loaded...");
    }
}
