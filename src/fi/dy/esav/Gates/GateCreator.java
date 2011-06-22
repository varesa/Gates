package fi.dy.esav.Gates;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Block;

public class GateCreator {

	@SuppressWarnings("rawtypes")
	public static Gates gates = new Gates();
	
	public static List<GateCreator> gcreators = new ArrayList<GateCreator>();
	
	public static void createGateCreator(String name, String creator) {
		
		GateCreator g = new GateCreator(name, creator);
		gcreators.add(g);

	}
	
	public static void removeGateCreator(GateCreator gc) {
		gcreators.remove(gc);
	}
	
	public static GateCreator getGateCreatorByPlayer(String player) {
		for (GateCreator g : gcreators) {
			if (g.getCreator() == player) {
				return g;
			}
		}
		return null;
	}
	
	public static boolean isGCByPlayer(String player) {
		for (GateCreator g : gcreators) {
			if (g.getCreator() == player) {
				return true;
			}
		}
		return false;
	}

	
	
	
	public GateCreator(String name, String creator) {
		this.name = name;
		this.creator = creator;
	}
	
	

	public  boolean isB1set() {
		return b1set;
	}
	public  void setB1IsSet(boolean b1set) {
		this.b1set = b1set;
	}
	public  boolean isB2set() {
		return b2set;
	}
	public  void setB2IsSet(boolean b2set) {
		this.b2set = b2set;
	}
	public  Block getB1() {
		return b1;
	}
	public  void setB1(Block b1) {
		this.b1 = b1;
	}
	public Block getB2() {
		return b2;
	}
	public void setB2(Block b2) {
		this.b2 = b2;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	

	public  boolean b1set = false, b2set = false;;
	public  Block b1, b2;
	public  String name;
	public  String creator;
	

	
}
