package pe.chalk.firstspigot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author ChalkPE <amato0617@gmail.com>
 * @since 2015-04-12
 */
public class FirstSpigot extends JavaPlugin implements Listener, CommandExecutor {
    @Override
    public void onEnable(){
        super.onEnable();

        this.getCommand("test").setExecutor(this);
        this.getCommand("test2").setExecutor(this);
        this.getServer().getPluginManager().registerEvents(this, this);

        this.getLogger().info("Hello, Spigot!");
    }

    @Override
    public void onDisable() {
        super.onDisable();

        this.getLogger().info("Goodbye, Spigot!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            this.getServer().getLogger().warning("Please run this command in-game!");
            return false;
        }

        if(command.getName().equalsIgnoreCase("test")) {
            sender.sendMessage("Hello, commander!");
        } else if(command.getName().equalsIgnoreCase("test2")) {
            this.getServer().broadcastMessage("Hello, world!");
        }
        return true;
    }
}
