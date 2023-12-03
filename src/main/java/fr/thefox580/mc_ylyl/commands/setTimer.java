package fr.thefox580.mc_ylyl.commands;

import fr.thefox580.mc_ylyl.MC_YLYL;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class setTimer implements CommandExecutor {

    private final MC_YLYL plugin;

    public setTimer(MC_YLYL plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        FileConfiguration config = this.plugin.getConfig();

        config.set("timer_hour", Integer.parseInt(strings[0]));
        config.set("timer_minute", Integer.parseInt(strings[1]));
        config.set("timer_second", Integer.parseInt(strings[2]));
        this.plugin.saveConfig();

        return false;
    }
}
