package fr.thefox580.mc_ylyl.commands;

import fr.thefox580.mc_ylyl.MC_YLYL;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class laughed implements CommandExecutor {

    private final MC_YLYL plugin;

    public laughed(MC_YLYL plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@org.jetbrains.annotations.NotNull CommandSender commandSender, @org.jetbrains.annotations.NotNull Command command, @org.jetbrains.annotations.NotNull String s, @org.jetbrains.annotations.NotNull String[] strings) {

        Player targetPlayer = Bukkit.getPlayerExact(strings[0]);

        if (targetPlayer.getMaxHealth() > 10.0){
            targetPlayer.setMaxHealth(10.0);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + targetPlayer.getName() + " parent set 1laugh");
            this.plugin.adventure().player(targetPlayer).sendMessage(Component.text("You laughed ")
                    .append(Component.text(1, TextColor.color(170, 0, 0))
                    .append(Component.text(" time, this is your last chance, you better not laugh anymore."))));

        } else if (targetPlayer.getMaxHealth() == 10.0) {
            targetPlayer.setMaxHealth(20.0);
            targetPlayer.setGameMode(GameMode.SPECTATOR);
            this.plugin.adventure().player(targetPlayer).sendMessage(Component.text("You laughed ")
                    .append(Component.text(2, TextColor.color(170, 0, 0))
                    .append(Component.text(" times, you're now out and may help the other team to make them laugh.", TextColor.color(255, 255, 255)))));
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + targetPlayer.getName() + " parent set dead");
        }

        return false;
    }
}
