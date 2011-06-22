package fi.dy.esav.Gates;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GatesCommandExecutor implements CommandExecutor {

	Logger log = Logger.getLogger("Minecraft");



	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {

		if (!(sender instanceof Player)) return true;
		
		Player p = (Player) sender;
		String pname = p.getName();
		
		if (arg3[0].equalsIgnoreCase("create")) {
			if (arg3.length == 2) {

				if (GateCreator.isGCByPlayer(pname)) {
					sender.sendMessage("You are already creating a gate. Please abort it first");
				return true;
				}
				System.out.println("Start");
				GateCreator.createGateCreator(arg3[1], pname);
				return true;

			} else sender.sendMessage("You must provide gate name as argument");
				
			
		}	


		return false;
	}
}
