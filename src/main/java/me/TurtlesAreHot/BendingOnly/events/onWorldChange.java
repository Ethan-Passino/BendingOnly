package me.TurtlesAreHot.BendingOnly.events;

import me.TurtlesAreHot.BendingOnly.Config;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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
            ItemStack[] contents = e.getPlayer().getInventory().getContents();
            // Helmet Slot: 39
            // Chestplate Slot: 38
            // Leggings Slot: 37
            // Boots Slot: 36
            // Slots 0-8 Are the hotbar
            // Slot 40 is offhand
            if(!(Config.isArmorAllowed())) {

                if(contents[39] != null ||
                contents[38] != null ||
                contents[37] != null ||
                contents[36] != null) {
                    // Basically checks if any of the armor pieces are filled with something
                    e.getPlayer().setHealth(0.0);
                    e.getPlayer().sendMessage(ChatColor.RED + "You cannot enter the arena while wearing armor. Please remove it.");
                }
            }
            ItemStack[] holdable = {contents[0], contents[1], contents[2], contents[3], contents[4], contents[5],
            contents[6], contents[7], contents[8], contents[40]};
            for(ItemStack invSlot : holdable) {
                if(invSlot == null) continue;
                if(invSlot.getType() == Material.TOTEM_OF_UNDYING ||
                invSlot.getType() == Material.SHIELD) {
                    e.getPlayer().setHealth(0.0);
                    e.getPlayer().sendMessage(ChatColor.RED + "You cannot enter the arena with a totem of undying or shield in your hotbar or offhand.");
                }
            }

        }
    }

}
