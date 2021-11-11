package me.TurtlesAreHot.BendingOnly;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Reload implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("boreload")) {
            if(!sender.hasPermission("bo.reload")) {
                sender.sendMessage("You do not have permission to perform this command.");
                return true;
            }
            JavaPlugin.getPlugin(Main.class).reloadConfig();
            Config.reloadConfig();
            sender.sendMessage("Reloaded the BendingOnly config!");
        }
        return true;
    }
}
