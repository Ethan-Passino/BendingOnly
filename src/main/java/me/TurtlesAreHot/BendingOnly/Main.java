package me.TurtlesAreHot.BendingOnly;

import me.TurtlesAreHot.BendingOnly.events.*;
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
        List<String> deniedWeapons = new ArrayList<>();
        List<String> noRightClicks = new ArrayList<>();
        deniedBlocks.add("SOUL_SAND");
        deniedBlocks.add("TNT");
        deniedWeapons.add("DIAMOND_SWORD");
        deniedWeapons.add("GOLD_SWORD");
        noRightClicks.add("OAK_BOAT");
        noRightClicks.add("STRING");
        config.addDefault("world", "bending");
        config.addDefault("denied-blocks", deniedBlocks);
        config.addDefault("denied-weapons", deniedWeapons);
        config.addDefault("can-throw-potions", false);
        config.addDefault("allow-bows", false);
        config.addDefault("allow-projectiles", false);
        config.addDefault("allow-consume", false);
        config.addDefault("allow-rod", false);
        config.addDefault("no-rightclick", noRightClicks);
        config.addDefault("mob-spawning", false);
        config.addDefault("allow-armor", false);
        config.options().copyDefaults(true);
        this.saveConfig();
        Config.reloadConfig();
        getCommand("boreload").setExecutor(new Reload());
        this.getServer().getPluginManager().registerEvents(new onBlock(), this);
        this.getServer().getPluginManager().registerEvents(new bucketEvent(), this);
        this.getServer().getPluginManager().registerEvents(new onPotionSplash(), this);
        this.getServer().getPluginManager().registerEvents(new onBowShoot(), this);
        this.getServer().getPluginManager().registerEvents(new onProjectile(), this);
        this.getServer().getPluginManager().registerEvents(new onItemConsume(), this);
        this.getServer().getPluginManager().registerEvents(new onFish(), this);
        this.getServer().getPluginManager().registerEvents(new onClick(), this);
        this.getServer().getPluginManager().registerEvents(new onEntityDamage(), this);
        this.getServer().getPluginManager().registerEvents(new onEntitySpawn(), this);
        this.getServer().getPluginManager().registerEvents(new onWorldChange(), this);
        this.getServer().getPluginManager().registerEvents(new onItemMove(), this);
    }

    @Override
    public void onDisable() {

    }

}
