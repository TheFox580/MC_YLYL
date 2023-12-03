package fr.thefox580.mc_ylyl.listeners;

import fr.thefox580.mc_ylyl.MC_YLYL;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onPlayerJoin implements Listener {

    private final MC_YLYL plugin;

    public onPlayerJoin(MC_YLYL plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void playerJoinsEvent(PlayerJoinEvent event){
        Player eventPlayer = event.getPlayer();

        event.joinMessage(Component.text("[", TextColor.color(170, 170, 170))
                .append(Component.text("+", TextColor.color(85, 255, 85)))
                .append(Component.text("] " + eventPlayer.getName() + " joined the game", TextColor.color(170, 170, 170))));

        if (eventPlayer.getMaxHealth() != 10.0 || eventPlayer.getMaxHealth() != 20.0) {
            eventPlayer.setMaxHealth(20.0);
        }

        if (!eventPlayer.hasPermission("group.dead")){
            this.plugin.getConfig().set("online_players", this.plugin.getConfig().getInt("online_players") + 1);
            this.plugin.saveConfig();
        }

    }
}
