package me.TurtlesAreHot.BendingOnly.events;

import me.TurtlesAreHot.BendingOnly.Config;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class onEntityDamage implements Listener {
    @EventHandler
    public void onEntityDmg(EntityDamageByEntityEvent e) {
        if(e.getDamager().getWorld().getName().equalsIgnoreCase(Config.getWorld())) {
            Entity damager = e.getDamager();
            if(damager instanceof Player) {
                Player hitter = (Player) damager;
                ItemStack hand = hitter.getItemInHand();
                // Hand is the item used to attack the player
                if(hand.getType() != Material.AIR) {
                    for (String mat : Config.getDeniedWeapons()) {
                        Material ma = Material.getMaterial(mat);
                        if (ma != null && hand.getType() == ma) {
                            hitter.sendMessage(ChatColor.RED + "You cannot attack an entity with this weapon here!");
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }
}
