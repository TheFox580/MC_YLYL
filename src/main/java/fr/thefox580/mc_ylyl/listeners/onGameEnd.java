package fr.thefox580.mc_ylyl.listeners;

import fr.thefox580.mc_ylyl.MC_YLYL;
import net.kyori.adventure.text.Component;
import org.bukkit.advancement.Advancement;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

public class onGameEnd implements Listener {

    private final MC_YLYL plugin;

    public onGameEnd(MC_YLYL plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onAdvComplete(PlayerAdvancementDoneEvent event){
        Player player = event.getPlayer();
        Advancement adv = event.getAdvancement();


        FileConfiguration config = this.plugin.getConfig();

        if (adv.getKey().toString().equals("minecraft:end/kill_dragon")){
            this.plugin.getConfig().set("timer_mode", false);
            this.plugin.adventure().all().sendMessage(Component.text("Player ")
                    .append(Component.text(' ' + player.getName() + " has killed the Ender Dragon in "))
                    .append(Component.text(config.getInt("timer_hour") + " hour(s), " +
                            config.getInt("timer_minute")+ " minute(s) and " + config.getInt("timer_second")
                            + " second(s)")));
        }
    }

}
