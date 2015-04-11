package ExamplePlugin;

import org.bukkit.command.*;
import org.bukkit.craftbukkit.Main;
import org.bukkit.entity.Player;


class ExampleCommand {
    public final Main plugin

    public ExampleCommand(Main instance) {
        plugin = instance;
    }
    @Override
    public boolean onCommand(CommandSender sp, Command cmd, CommandLabel cl, String[] args) {
        if(!(sp instanceof Player)) return false;

        Player player = (player)sp;
        if(cl.equalsIgnoreCase("test")) {
            player.sendMessage("TEST!!!");
            return true;
        } else if(cl.equalsIgnoreCase("test2")) {
            Bukkit.broadcastMessage("HELLO!!!");
            return true;
        }
        return true
    }
}