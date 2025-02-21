package io.github.JoltMuz.EventNameExpansion;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;


public final class Main extends JavaPlugin implements CommandExecutor {
	

	public String getEventName() {
		return getConfig().getString("event-name");
	}

	public void setEventName(String eventName) {
		getConfig().set("event-name", eventName);
	}

	@Override
    public void onEnable() {
		
		this.getCommand("eventname").setExecutor(this);
		
		getConfig().options().copyDefaults(true);
        saveDefaultConfig();
		
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) { // 
            new EventName().register(); // 
        }
    }
	
	@Override
    public void onDisable() 
	{
		saveConfig();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		setEventName(String.join(" ", args));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&',getConfig().getString("command-response").replace("<eventName>", getEventName())));
		return true;
	}
	

}
