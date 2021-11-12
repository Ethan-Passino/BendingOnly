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

    public static boolean canThrowPotions() { return config.getBoolean("can-throw-potions"); }

    public static boolean isBowAllowed() { return config.getBoolean("allow-bows"); }

    public static boolean isProjectilesAllowed() { return config.getBoolean("allow-projectiles"); }

    public static boolean isConsumingAllowed() { return config.getBoolean("allow-consume"); }

    public static boolean isRodAllowed() { return config.getBoolean("allow-rod"); }

    public static List<String> getDeniedRightClick() { return config.getStringList("no-rightclick"); }

    public static boolean mobSpawning() { return config.getBoolean("mob-spawning"); }

    public static boolean isArmorAllowed() { return config.getBoolean("allow-armor"); }
}
