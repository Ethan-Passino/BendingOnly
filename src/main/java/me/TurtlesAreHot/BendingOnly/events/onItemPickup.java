package me.TurtlesAreHot.BendingOnly.events;

import me.TurtlesAreHot.BendingOnly.Config;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class onItemPickup implements Listener {
    @EventHandler
    public void onPickup(EntityPickupItemEvent e) {
        if(e.getEntity().getWorld().getName().equalsIgnoreCase(Config.getWorld())) {
            if (e.getEntity() instanceof Player) {
                if(e.getItem().getItemStack().getType() == Material.SHIELD ||
                        e.getItem().getItemStack().getType() == Material.TOTEM_OF_UNDYING) {
                    e.getItem().remove();
                    e.getEntity().sendMessage(ChatColor.RED + "You cannot pickup a totem of undying or a shield.");
                    e.setCancelled(true);
                }
            }
        }
    }
}
