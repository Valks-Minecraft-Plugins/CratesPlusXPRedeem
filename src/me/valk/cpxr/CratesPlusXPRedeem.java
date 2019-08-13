package me.valk.cpxr;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.valk.cpxr.commands.CmdRedeem;
import me.valk.cpxr.configs.ConfigManager;

public class CratesPlusXPRedeem extends JavaPlugin {
	public static File pluginFolder;
	
	public static ConfigManager mainCM;
	public static YamlConfiguration mainConfig;
	
	@Override
	public void onEnable() {
		pluginFolder = getDataFolder();
		registerCommands();
		registerConfig();
	}
	
	private void registerCommands() {
		getCommand("cratesplusredeem").setExecutor(new CmdRedeem());
	}
	
	private void registerConfig() {
		mainCM = new ConfigManager("config");
		mainConfig = mainCM.getConfig();
		mainCM.setDefault("keys.crate_type", "mysterybox");
		mainCM.setDefault("keys.required_xp_levels", 65);
		mainCM.setDefault("keys.show_crate_key_message", true);
		mainCM.saveConfig();
	}
}
