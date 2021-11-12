package me.TurtlesAreHot.BendingOnly.events;

import me.TurtlesAreHot.BendingOnly.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class onEntitySpawn implements Listener {
    @EventHandler
    public void onSpawn(EntitySpawnEvent e) {
        if(e.getEntity().getWorld().getName().equalsIgnoreCase(Config.getWorld())) {
            if(!(Config.mobSpawning())) {
                e.setCancelled(true);
            }
        }
    }
}
