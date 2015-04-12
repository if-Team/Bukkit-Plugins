package pe.chalk.firstspigot;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author ChalkPE <amato0617@gmail.com>
 * @since 2015-04-12
 */
public class FirstSpigot extends JavaPlugin {
    private static FirstSpigotCommand fsc;

    @Override
    public void onEnable(){
        super.onEnable();
        initCommand();
        initEvent();
        this.getLogger().info("Hello, Spigot!");
    }
    @Override
    public void onDisable() {
        super.onDisable();
        this.getLogger().info("Bye, Spigot!");
    }
    public void initCommand() {
        fsc = new FirstSpigotCommand(this);
        getCommand("test").setExecutor(fsc);
        getCommand("test2").setExecutor(fsc);
    }
    public void initEvent() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new FirstSpigotEvent(this), this);
    }
}
