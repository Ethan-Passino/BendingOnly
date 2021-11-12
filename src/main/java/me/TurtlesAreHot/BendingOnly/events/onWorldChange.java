package me.TurtlesAreHot.BendingOnly.events;

import me.TurtlesAreHot.BendingOnly.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class onWorldChange implements Listener {
    @EventHandler
    public void onChangeWorld(PlayerChangedWorldEvent e) {
        if(e.getPlayer().getWorld().getName().equalsIgnoreCase(Config.getWorld())) {
            // This basically will check if a player has anything equipped as armor, if they do they die.
            if(!(Config.isArmorAllowed())) {
                // Helmet Slot: 39
                // Chestplate Slot: 38
                // Leggings Slot: 37
                // Boots Slot: 36
                ItemStack[] contents = e.getPlayer().getInventory().getContents();
                if(contents[39] != null ||
                contents[38] != null ||
                contents[37] != null ||
                contents[36] != null) {
                    // Basically checks if any of the armor pieces are filled with something
                    e.getPlayer().setHealth(0.0);
                }
            }
        }
    }

}
