package fi.dy.esav.Gates;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Gates<creating> extends JavaPlugin {

	Logger log = Logger.getLogger("Minecraft");

	public static List<Gate> gates = new ArrayList<Gate>();

	Server server = getServer();
	

	GatesBlockListener BlockListener = new GatesBlockListener(this);

	public void onEnable() {

		log.info(this.getDescription().getName() + " version "
				+ this.getDescription().getVersion() + " started.");

		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_PLACE, BlockListener,
				Event.Priority.Normal, this);
		// pm.registerEvent(Event.Type.BLOCK_BREAK, BlockListener,
		// Event.Priority.Normal, this);

		getCommand("gate").setExecutor(new GatesCommandExecutor());

	}

	public void onDisable() {

		log.info(this.getDescription().getName() + " version "
				+ this.getDescription().getVersion() + " stopped.");

	}


}
