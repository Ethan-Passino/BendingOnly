package me.TurtlesAreHot.BendingOnly.events;

import me.TurtlesAreHot.BendingOnly.Config;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.projectiles.ProjectileSource;

public class onProjectile implements Listener {
    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent e) {
        if(e.getEntity().getWorld().getName().equalsIgnoreCase(Config.getWorld())) {
            if (!(Config.isProjectilesAllowed())) {
                ProjectileSource ps = e.getEntity().getShooter();
                if (ps instanceof Player) {
                    Player p = (Player) ps;
                    switch (e.getEntityType()) {
                        case TRIDENT:
                            p.sendMessage(ChatColor.RED + "You cannot throw that here!");
                            e.setCancelled(true);
                            break;
                        case ENDER_PEARL:
                            p.sendMessage(ChatColor.RED + "You cannot throw that here!");
                            e.setCancelled(true);
                            break;
                        case THROWN_EXP_BOTTLE:
                            p.sendMessage(ChatColor.RED + "You cannot throw that here!");
                            e.setCancelled(true);
                            break;
                        case EGG:
                            p.sendMessage(ChatColor.RED + "You cannot throw that here!");
                            e.setCancelled(true);
                            break;
                        case SNOWBALL:
                            p.sendMessage(ChatColor.RED + "You cannot throw that here!");
                            e.setCancelled(true);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }
}
