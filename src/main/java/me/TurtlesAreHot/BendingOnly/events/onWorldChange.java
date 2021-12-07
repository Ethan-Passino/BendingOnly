package me.TurtlesAreHot.BendingOnly.events;

import me.TurtlesAreHot.BendingOnly.Config;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
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

                if(hasArmorOn(e.getPlayer())) {
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

    public boolean hasArmorOn(Player p) {
        ItemStack[] contents = p.getInventory().getContents();
        ItemStack helm = contents[39];
        ItemStack chest = contents[38];
        ItemStack leg = contents[37];
        ItemStack boot = contents[36];
        if(helm != null) {
            if(isArmor(helm.getType())) {
                return true;
            }
        }
        if(chest != null) {
            if(isArmor(chest.getType())) {
                return true;
            }
        }
        if(leg != null) {
            if (isArmor(leg.getType())) {
                return true;
            }
        }
        if(boot != null) {
            if(isArmor(boot.getType())) {
                return true;
            }
        }
        return false;
    }

    public boolean isArmor(Material m) {
        switch(m) {
            case NETHERITE_HELMET:
                return true;
            case NETHERITE_CHESTPLATE:
                return true;
            case NETHERITE_LEGGINGS:
                return true;
            case NETHERITE_BOOTS:
                return true;
            case DIAMOND_HELMET:
                return true;
            case DIAMOND_CHESTPLATE:
                return true;
            case DIAMOND_LEGGINGS:
                return true;
            case DIAMOND_BOOTS:
                return true;
            case GOLDEN_HELMET:
                return true;
            case GOLDEN_CHESTPLATE:
                return true;
            case GOLDEN_LEGGINGS:
                return true;
            case GOLDEN_BOOTS:
                return true;
            case CHAINMAIL_HELMET:
                return true;
            case CHAINMAIL_CHESTPLATE:
                return true;
            case CHAINMAIL_LEGGINGS:
                return true;
            case CHAINMAIL_BOOTS:
                return true;
            case IRON_HELMET:
                return true;
            case IRON_CHESTPLATE:
                return true;
            case IRON_LEGGINGS:
                return true;
            case IRON_BOOTS:
                return true;
            case LEATHER_HELMET:
                return true;
            case LEATHER_CHESTPLATE:
                return true;
            case LEATHER_LEGGINGS:
                return true;
            case LEATHER_BOOTS:
                return true;
            case ELYTRA:
                return true;
            default:
                return false;
        }
    }

}
