package me.valk.cpxr.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.valk.cpxr.CratesPlusXPRedeem;
import me.valk.cpxr.utils.TextModule;
import plus.crates.CratesPlus;
import plus.crates.Handlers.CrateHandler;

public class CmdRedeem implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("cratesplusredeem")) {
			if (sender instanceof ConsoleCommandSender) {
				sender.sendMessage("Only in-game players can execute this kind of command!");
				return true;
			}
			
			if (args.length < 1) {
				sender.sendMessage(TextModule.color("&cUsage: /cpr <amount>"));
				return true;
			}
			
			int amount = Integer.parseInt(args[0]);
			
			if (Double.isNaN(amount)) {
				sender.sendMessage(TextModule.color("&cPlease specify a valid number!"));
				return true;
			}
			
			if (amount <= 0) {
				sender.sendMessage(TextModule.color("&cYou must enter a number greater than 0!"));
				return true;
			}
			
			if (amount >= 100000) {
				sender.sendMessage(TextModule.color("&cYou must enter a number less than 100000!"));
				return true;
			}
			
			YamlConfiguration mainConfig = CratesPlusXPRedeem.mainConfig;
			
			Player p = (Player) sender;
			
			final int REQUIRED_XP_LEVELS = mainConfig.getInt("keys.required_xp_levels") * amount;
			
			if (p.getLevel() < REQUIRED_XP_LEVELS) {
				sender.sendMessage(TextModule.color("&cYou need at least " + REQUIRED_XP_LEVELS + " levels of xp to do that!"));
				return true;
			}
			
			// Take the player levels.
			p.setLevel(p.getLevel() - REQUIRED_XP_LEVELS);
			
			// Give keys to player.
			CrateHandler crateHandler = new CrateHandler(JavaPlugin.getPlugin(CratesPlus.class));
			crateHandler.giveCrateKey(p, mainConfig.getString("keys.crate_type"), amount, mainConfig.getBoolean("keys.show_crate_key_message"));
			
			return true;
		}
		return true;
	}
}
