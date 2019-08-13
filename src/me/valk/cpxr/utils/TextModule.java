package me.valk.cpxr.utils;

import net.md_5.bungee.api.ChatColor;

public class TextModule {

	public static String color(String message) {
		String primaryColor = "&f";
		message = message.replaceAll("&q", primaryColor);
		String secondaryColor = "&7";
		message = message.replaceAll("&w", secondaryColor);
		return ChatColor.translateAlternateColorCodes('&', secondaryColor + message);
	}
}
