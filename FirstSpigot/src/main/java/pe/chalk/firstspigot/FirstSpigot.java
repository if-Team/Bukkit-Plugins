package pe.chalk.firstspigot;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.function.Consumer;

/**
 * @author ChalkPE <amato0617@gmail.com>
 * @since 2015-04-12
 */
public class FirstSpigot extends JavaPlugin implements Listener, CommandExecutor {

    private HashMap<Player, Long> cooltime = new HashMap<>();

    @Override
    public void onEnable(){
        super.onEnable();

        this.getCommand("test").setExecutor(this);
        this.getCommand("test2").setExecutor(this);
        this.getCommand("cls").setExecutor(this);
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
            this.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Please run this command in-game!");
            return false;
        }

        Player player = (Player) sender;

        switch(command.getName().toLowerCase()){
            case "test":
                player.sendMessage(ChatColor.AQUA + "[FirstSpigot] Hello, commander!");
                break;
            case "test2":
                this.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "[FirstSpigot] Hello, world!");
                this.getServer().getOnlinePlayers().forEach(onlinePlayer -> onlinePlayer.setFireTicks(200));
                break;
            case "cls":
                Consumer<? super Player> cls = onlinePlayer -> {
                    for(int i = 0; i < 30; i++){
                        onlinePlayer.sendMessage("");
                    }
                };

                if(player.isOp()){
                    getServer().getOnlinePlayers().forEach(cls);
                }else{
                    cls.accept(player);
                }
                break;

            default:
        }
        return true;
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event){
        if(event.isCancelled()){
            return;
        }

        final Player player = event.getPlayer();
        final Entity entity = event.getRightClicked();

        if(cooltime.containsKey(player) && (System.currentTimeMillis() - cooltime.get(player)) <= 30000){
            player.sendMessage(ChatColor.RED + "[FirstSpigot] You need to wait a second!");
            return;
        }

        new BukkitRunnable(){
            private int time = 10;

            @Override
            public void run(){
                if(time > 0){
                    String message = "[FirstSpigot] The bomb will blow up " + time + " second(s) after!";

                    player.sendMessage(ChatColor.AQUA + message);
                    if(time <= 3 && entity instanceof Player){
                        entity.sendMessage(ChatColor.DARK_RED + message);
                    }

                    time--;
                }else{
                    if(!entity.isDead()){
                        player.getWorld().createExplosion(entity.getLocation(), 2.5F);
                    }
                    this.cancel();
                }

            }
        }.runTaskTimer(this, 0L, 20L);

        event.getPlayer().sendMessage(ChatColor.RED + "[FirstSpigot] The bomb has been installed!");
        cooltime.put(player, System.currentTimeMillis());
    }
}