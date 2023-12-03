package fr.thefox580.mc_ylyl.commands;

import fr.thefox580.mc_ylyl.MC_YLYL;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class pause implements CommandExecutor {

    private final MC_YLYL plugin;

    public pause(MC_YLYL plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        this.plugin.getConfig().set("timer_mode", false);

        this.plugin.saveConfig();
        return false;
    }
}
