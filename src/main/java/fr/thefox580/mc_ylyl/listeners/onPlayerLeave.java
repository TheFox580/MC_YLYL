package fr.thefox580.mc_ylyl.listeners;

import fr.thefox580.mc_ylyl.MC_YLYL;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onPlayerLeave implements Listener {

    private final MC_YLYL plugin;

    public onPlayerLeave(MC_YLYL plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void playerJoinsEvent(PlayerQuitEvent event){
        Player eventPlayer = event.getPlayer();

        event.quitMessage(Component.text("[", TextColor.color(170, 170, 170))
                .append(Component.text("-", TextColor.color(170, 0, 0)))
                .append(Component.text("] " + eventPlayer.getName() + " left the game", TextColor.color(170, 170, 170))));


        if (!eventPlayer.hasPermission("checkIfPlayerIsNotOP")){
            this.plugin.getConfig().set("online_players", this.plugin.getConfig().getInt("online_players") - 1);
            this.plugin.saveConfig();
        }

    }
}
