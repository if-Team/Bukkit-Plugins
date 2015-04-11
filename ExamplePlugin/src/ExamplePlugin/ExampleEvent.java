package ExamplePlugin;

import org.bukkit.craftbukkit.Main;
import org.bukkit.event.Listener;

class ExampleEvent implements Listener {
    public final Main plugin;

    public ExampleEvent(Main instance) {
        plugin = instance;
    }
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage("hi!");
    }
}