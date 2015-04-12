package pe.chalk.firstspigot;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.*;

/**
 * @author IchiKaku <woni8708@naver.com>
 * @since 2015-04-12
 */
public class FirstSpigotCommand implements CommandExecutor {
    private final FirstSpigot plugin;

    public FirstSpigotCommand(FirstSpigot instance) {plugin = instance;}
    @Override
    public boolean onCommand(CommandSender sp, Command cmd, String cl, String[] args) {
        if(!(sp instanceof Player)) return false;

        Player player = (Player)sp;
        if(cl.equalsIgnoreCase("test")) {
            player.sendMessage("TEST!!!");
            return true;
        } else if(cl.equalsIgnoreCase("test2")) {
            Bukkit.broadcastMessage("HELLO!!!");
            return true;
        }
        return true;
    }
}
