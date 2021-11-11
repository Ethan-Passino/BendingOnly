package me.TurtlesAreHot.BendingOnly;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class Config {
    private static FileConfiguration config;

    public static void reloadConfig() {
        config = JavaPlugin.getPlugin(Main.class).getConfig();
    }

    public static String getWorld() { return config.getString("world"); }

    public static List<String> getDeniedBlocks() { return config.getStringList("denied-blocks"); }

    public static List<String> getDeniedWeapons() { return config.getStringList("denied-weapons"); }
}
