package me.TurtlesAreHot.BendingOnly.events;

import me.TurtlesAreHot.BendingOnly.Config;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class onFish implements Listener {
    @EventHandler
    public void onFishEvent(PlayerFishEvent e) {
        if(e.getPlayer().getWorld().getName().equalsIgnoreCase(Config.getWorld())) {
            if(!(Config.isRodAllowed())) {
                e.getPlayer().sendMessage(ChatColor.RED + "You cannot use a fishing rod here.");
                e.setCancelled(true);
            }
        }
     }
}
