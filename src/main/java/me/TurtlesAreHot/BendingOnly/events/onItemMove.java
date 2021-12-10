package me.TurtlesAreHot.BendingOnly.events;

import me.TurtlesAreHot.BendingOnly.Config;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class onItemMove implements Listener {
    @EventHandler
    public void onInventoryMove(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(p.getWorld().getName().equalsIgnoreCase(Config.getWorld())) {
            if(e.getCursor() != null && !(Config.isArmorAllowed())) {
                if(e.getClick().isShiftClick()) {
                    if(e.getCurrentItem() != null) {
                        if (isArmor(e.getCurrentItem().getType())) {
                            p.sendMessage(ChatColor.RED + "You cannot equip/move armor in this world. Go to /spawn to do this.");
                            e.setCancelled(true);
                        }
                    }
                }
                if(isArmor(e.getCursor().getType())) {
                    p.sendMessage(ChatColor.RED + "You cannot equip/move armor in this world. Go to /spawn to do this.");
                    e.setCancelled(true);
                }
                if(e.getSlotType() == InventoryType.SlotType.QUICKBAR && e.getCursor() != null) {
                    if(e.getCursor().getType() == Material.TOTEM_OF_UNDYING ||
                            e.getCursor().getType() == Material.SHIELD) {
                        p.sendMessage(ChatColor.RED + "You cannot put totems or shields in your quickbar!");
                        e.setCancelled(true);
                    }
                }
            }
        }
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