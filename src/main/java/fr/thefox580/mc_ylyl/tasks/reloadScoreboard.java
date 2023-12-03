package fr.thefox580.mc_ylyl.tasks;

import fr.thefox580.mc_ylyl.MC_YLYL;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

public class reloadScoreboard extends BukkitRunnable {

    private final MC_YLYL plugin;

    public reloadScoreboard(MC_YLYL plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {

        FileConfiguration config = this.plugin.getConfig();

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("title", Criteria.DUMMY, Component.text(ChatColor.BOLD + "Kill the Ender Dragon"));
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score timer = objective.getScore("Time Left : " + config.getInt("timer_hour") + "h, " + config.getInt("timer_minute") + "min, " + config.getInt("timer_second") + 's');
        timer.setScore(config.getInt("timer_hour")*3600+config.getInt("timer_minute")*60+config.getInt("timer_second")+100);

        Score blank = objective.getScore("");
        blank.setScore(99);

        Score onlinePlayer = objective.getScore("Online players : " + config.getInt("online_players"));
        onlinePlayer.setScore(config.getInt("online_players"));

        for (Player loopedPlayer : Bukkit.getOnlinePlayers()){
            loopedPlayer.setScoreboard(scoreboard);
        }

    }
}
