package com.ichikaku.anything;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.material.Tree;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.*;
import org.bukkit.util.Vector;

public class Anything extends JavaPlugin implements Listener, CommandExecutor {
    @Override
    public void onEnable(){
        super.onEnable();

        this.getCommand("test").setExecutor(this);
        this.getCommand("test2").setExecutor(this);
        this.getServer().getPluginManager().registerEvents(this, this);

        this.getLogger().info("Hello");
    }

    @Override
    public void onDisable() {
        super.onDisable();

        this.getLogger().info("Goodbye");
    }

    @EventHandler
    public void onBreakEvent(PlayerInteractEvent e) {
        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Player player = e.getPlayer();
            Location v = player.getLocation();
            World w = player.getWorld();
            w.strikeLightning(v);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            this.getServer().getLogger().warning("Please run this command in-game!");
            return false;
        }

        if(command.getName().equalsIgnoreCase("test")) {
            sender.sendMessage(ChatColor.AQUA + "Hello, commander!");
        } else if(command.getName().equalsIgnoreCase("test2")) {
            this.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "Hello, world!");
        }
        return true;
    }
}
