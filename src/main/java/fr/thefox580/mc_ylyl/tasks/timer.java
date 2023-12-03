package fr.thefox580.mc_ylyl.tasks;

import fr.thefox580.mc_ylyl.MC_YLYL;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class timer extends BukkitRunnable {

    private final MC_YLYL plugin;

    public timer(MC_YLYL plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {

        FileConfiguration config = this.plugin.getConfig();

        if (config.getBoolean("timer_mode")){
            if (config.getInt("timer_hour") == 0 && config.getInt("timer_minute") == 0 && config.getInt("timer_second") == 0){
                config.set("timer_mode", false);
                this.plugin.adventure().all().sendMessage(Component.text("Sadly, you did not kill the ender dragon... Better luck next time !"));
                for (Player loopedPlayer : Bukkit.getOnlinePlayers()){
                    loopedPlayer.setGameMode(GameMode.SPECTATOR);
                    this.plugin.getConfig().set("team_" + loopedPlayer.getName(), "dead");
                }
            } else {
                if (config.getInt("timer_minute") == 0 && config.getInt("timer_seconds") == 0){
                    config.set("timer_hour", config.getInt("timer_hour")-1);
                    config.set("timer_minute", 59);
                    config.set("timer_second", 60);
                } else {
                    if (config.getInt("timer_second") == 0){
                        config.set("timer_minute", config.getInt("timer_minute")-1);
                        config.set("timer_second", 60);
                    }
                }
            }
            config.set("timer_second", config.getInt("timer_second")-1);
            this.plugin.saveConfig();
        }
    }
}
