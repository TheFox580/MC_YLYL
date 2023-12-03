package fr.thefox580.mc_ylyl;

import fr.thefox580.mc_ylyl.commands.*;
import fr.thefox580.mc_ylyl.listeners.*;
import fr.thefox580.mc_ylyl.tasks.*;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class MC_YLYL extends JavaPlugin {

    private BukkitAudiences adventure;

    public @NonNull BukkitAudiences adventure() {
        if (this.adventure == null){
            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled"); //Tell the plugin Adventure is already used
        }
        return this.adventure;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("Starting Plugin");

        saveDefaultConfig(); //Saves the config in the plugin folder

        this.adventure = BukkitAudiences.create(this); //Implements Adventure to the plugin

        getCommand("laughed").setExecutor(new laughed(this));
        getCommand("start").setExecutor(new start(this));
        getCommand("setTimer").setExecutor(new setTimer(this));
        getCommand("pause").setExecutor(new pause(this));

        getServer().getPluginManager().registerEvents(new onPlayerJoin(this), this);
        getServer().getPluginManager().registerEvents(new onPlayerLeave(this), this);
        getServer().getPluginManager().registerEvents(new onGameEnd(this), this);

        BukkitTask timerTask = new timer(this).runTaskTimer(this, 0L, 20L);
        BukkitTask reloadScoreboardTask = new reloadScoreboard(this).runTaskTimer(this, 0L, 1L);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Stopping Plugin");
    }
}
