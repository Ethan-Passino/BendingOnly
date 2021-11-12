package me.TurtlesAreHot.BendingOnly.events;

import me.TurtlesAreHot.BendingOnly.Config;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;

public class onPotionSplash implements Listener {
    @EventHandler
    public void onSplash(PotionSplashEvent e) {
        if(e.getEntity().getWorld().getName().equalsIgnoreCase(Config.getWorld())) {
            if (!(Config.canThrowPotions())) {
                if(e.getEntity().getShooter() instanceof Player) {
                    if (e.getEntity().getWorld().getName().equals(Config.getWorld())) {
                        Player p = (Player) e.getEntity().getShooter();
                        p.sendMessage(ChatColor.RED + "You cannot use potions here!");
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}
