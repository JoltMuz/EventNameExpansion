package io.github.JoltMuz.EventNameExpansion;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class EventName extends PlaceholderExpansion {
	
	@Override
    @NotNull
    public String getAuthor() {
        return "JoltTheBolt"; // 
    }

    @Override
    @NotNull
    public String getIdentifier() {
        return "EventName"; // 
    }

    @Override
    @NotNull
    public String getVersion() {
        return "1.0"; // 
    }
    
    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
    	return Main.getPlugin(Main.class).getConfig().getString("event-name");
    }

}
