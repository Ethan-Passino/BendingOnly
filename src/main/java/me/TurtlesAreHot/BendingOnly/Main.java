package me.TurtlesAreHot.BendingOnly;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Main extends JavaPlugin {

    private File customConfigFile;
    private static FileConfiguration customConfig;
    private static File dataFolder;

    @Override
    public void onEnable() {
        createCustomConfig();
        dataFolder = getDataFolder();
    }

    @Override
    public void onDisable() {

    }

    public static FileConfiguration getCustomConfig() { return customConfig; }

    public void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), "config.yml");
        if(!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }

        try {
            PrintWriter pw = new PrintWriter(customConfigFile);
            pw.println("world: \"bending\"");
            pw.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        customConfig = new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch(IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

}
