package fi.dy.esav.Gates;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class GatesBlockListener implements Listener {
	
	@SuppressWarnings("rawtypes")
	public Gates plugin;
	@SuppressWarnings("rawtypes")
	public GatesBlockListener(Gates Instance) {
		plugin = Instance;
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onBlockPlace(BlockPlaceEvent e) {
		System.out.println("Placed Block");
		if (GateCreator.isGCByPlayer(e.getPlayer().getName()) == true) {
			System.out.println("Player has GC");
			GateCreator GC = GateCreator.getGateCreatorByPlayer(e.getPlayer().getName());
			
			if (!GC.isB1set()) {
				System.out.println("Placed Block 1");
				GC.setB1(e.getBlock());
				GC.setB1IsSet(true);
			} else if (!GC.isB2set()) {
				System.out.println("Placed Block 2");
				GC.setB2(e.getBlock());
				GC.setB2IsSet(true);
				Gate.createGate(GC.getName(), GC.getB1().getLocation(), GC.getB2().getLocation(), GC.getB1().getType());
				e.getPlayer().sendMessage("Gates: Gate " + GC.getName() + " created.");
				GateCreator.removeGateCreator(GC);
			}
		}
	
	}
	

}
