package ExamplePlugin;


import java.lang.Override;
import org.bukkit.craftbukkit.Main;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;

class ExamplePlugin extends JavaPlugin implements Listener{
    public final Logger logger = Logger.getLogger("Minecraft");
    public static ExampleCommand cmd;
    public static Main plugin;

    @Override
    public void onEnable() {
        initEvent();
        PluginDescriptionFile pdFile = this.getDescription();
        this.logger.info("enabled");
    }
    @Override
    public void onDisable() {
        PluginDescriptionFile pdFile = this.getDescription();
        this.logger.info("disabled");
    }
    public void initCommand() {
        cmd = new ExampleCommand(this);
        getCommand("test").setExcuter(cmd);
        getCommand("test2").setExcuter(cmd);
    }
    public void initEvent() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ExampleEvent(this), this);
    }
}