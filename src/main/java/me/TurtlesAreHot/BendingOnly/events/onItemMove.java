package me.TurtlesAreHot.BendingOnly.events;

import me.TurtlesAreHot.BendingOnly.Config;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class onItemMove implements Listener {
    @EventHandler
    public void onInventoryMove(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(p.getWorld().getName().equalsIgnoreCase(Config.getWorld())) {
            if(!(Config.isArmorAllowed())) {
                if(e.getSlotType() == InventoryType.SlotType.ARMOR) {
                    p.sendMessage(ChatColor.RED + "You cannot equip armor in this world!");
                    e.setCancelled(true);
                }
            }
        }
    }
}
