package pe.chalk.firstspigot;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author IchiKaku <woni8708@naver.com>
 * @since 2015-04-12
 */
public class FirstSpigotEvent implements Listener{
    public final FirstSpigot plugin;

    public FirstSpigotEvent(FirstSpigot instance) {
        plugin = instance;
    }
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage("hi!");
    }
}
