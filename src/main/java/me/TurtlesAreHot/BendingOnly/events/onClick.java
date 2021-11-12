package me.TurtlesAreHot.BendingOnly.events;

import me.TurtlesAreHot.BendingOnly.Config;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class onClick implements Listener {

    @EventHandler
    public void onPlayerClick(PlayerInteractEvent e) {
        if(e.getPlayer().getWorld().getName().equalsIgnoreCase(Config.getWorld())) {
            Action act = e.getAction();
            if(act == Action.RIGHT_CLICK_AIR || act == Action.RIGHT_CLICK_BLOCK) {
                // If right clicking with certain items
                for(String mat : Config.getDeniedRightClick()) {
                    Material ma = Material.getMaterial(mat);
                    if(e.getItem() != null && e.getItem().getType() == ma) {
                        e.getPlayer().sendMessage(ChatColor.RED + "You cannot right click with this item here.");
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}
