package fr.thefox580.mc_ylyl.commands;

import fr.thefox580.mc_ylyl.MC_YLYL;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class start implements CommandExecutor {

    private final MC_YLYL plugin;

    public start(MC_YLYL plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        this.plugin.getConfig().set("timer_mode", true);
        this.plugin.saveConfig();

        return false;
    }
}
