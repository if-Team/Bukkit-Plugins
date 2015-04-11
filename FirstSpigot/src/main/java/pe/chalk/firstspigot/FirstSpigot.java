package pe.chalk.firstspigot;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author ChalkPE <amato0617@gmail.com>
 * @since 2015-04-12
 */
public class FirstSpigot extends JavaPlugin {
    @Override
    public void onEnable(){
        super.onEnable();
        this.getLogger().info("Hello, Spigot!");
    }
}
