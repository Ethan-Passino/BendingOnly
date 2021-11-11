package me.TurtlesAreHot.BendingOnly;

import me.TurtlesAreHot.BendingOnly.events.bucketEvent;
import me.TurtlesAreHot.BendingOnly.events.onBlock;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig(); // Creates config.yml
        FileConfiguration config = this.getConfig();
        List<String> deniedBlocks = new ArrayList<>();
        deniedBlocks.add("SOUL_SAND");
        deniedBlocks.add("TNT");
        List<String> deniedWeapons = new ArrayList<>();
        deniedWeapons.add("DIAMOND_SWORD");
        deniedWeapons.add("GOLD_SWORD");
        config.addDefault("world", "bending");
        config.addDefault("denied-blocks", deniedBlocks);
        config.addDefault("denied-weapons", deniedWeapons);
        config.options().copyDefaults(true);
        this.saveConfig();
        Config.reloadConfig();
        getCommand("boreload").setExecutor(new Reload());
        this.getServer().getPluginManager().registerEvents(new onBlock(), this);
        this.getServer().getPluginManager().registerEvents(new bucketEvent(), this);
    }

    @Override
    public void onDisable() {

    }

}
