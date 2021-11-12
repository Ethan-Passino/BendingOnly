package me.TurtlesAreHot.BendingOnly.events;

import me.TurtlesAreHot.BendingOnly.Config;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class onBowShoot implements Listener {
    @EventHandler
    public void onBow(EntityShootBowEvent e) {
        if(e.getEntity().getWorld().getName().equalsIgnoreCase(Config.getWorld())) {
            if (!(Config.isBowAllowed())) {
                if (e.getEntity() instanceof Player) {
                    e.getEntity().sendMessage(ChatColor.RED + "You cannot shoot that here!");
                    e.setCancelled(true);
                }
            }
        }
    }
}
