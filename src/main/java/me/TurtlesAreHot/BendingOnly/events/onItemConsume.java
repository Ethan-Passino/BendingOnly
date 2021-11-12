package me.TurtlesAreHot.BendingOnly.events;

import me.TurtlesAreHot.BendingOnly.Config;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class onItemConsume implements Listener {
    @EventHandler
    public void onConsume(PlayerItemConsumeEvent e) {
        if(e.getPlayer().getWorld().getName().equalsIgnoreCase(Config.getWorld())) {
            if(!(Config.isConsumingAllowed())) {
                // This should not allow you to consume anything in this world
                // Potions, Food, etc.
                e.getPlayer().sendMessage(ChatColor.RED + "You are not allowed to consume this here.");
                e.setCancelled(true);
            }
        }
    }
}
