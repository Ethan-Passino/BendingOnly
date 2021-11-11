package me.TurtlesAreHot.BendingOnly.events;

import me.TurtlesAreHot.BendingOnly.Config;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class bucketEvent implements Listener {
    @EventHandler
    public void onBucket(PlayerBucketEmptyEvent e) {
        if(e.getPlayer().getWorld().getName().equalsIgnoreCase(Config.getWorld())) {
            for(String mat : Config.getDeniedBlocks()) {
                Material ma = Material.getMaterial(mat);
                if(ma != null && e.getBucket().equals(ma)) {
                    // Checks if the block placed was one of the blocks that is denied.
                    // If it is, the event is canceled and the block isn't placed.
                    e.getPlayer().sendMessage(ChatColor.RED + "You cannot place this here!");
                    e.setCancelled(true);
                }
            }
        }
    }
}
