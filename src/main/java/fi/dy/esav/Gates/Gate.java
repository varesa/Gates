package fi.dy.esav.Gates;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class Gate {

	List<Block> blocks = new ArrayList<Block>();
	Location p1, p2;
	String name;
	Material material;
	boolean state = true;



	static List<Gate> gates = new ArrayList<Gate>();

	public static void createGate(String name, Location p1, Location p2, Material m) {
		Gate g = new Gate(name, p1, p2, m);
		gates.add(g);
		for (Block b : g.getBlocks()) {
			b.setType(g.getMaterial());
		}
	}
	
	public static Gate getGateByName(String name) {
		for (Gate g : gates) {
			if (g.getName().equalsIgnoreCase(name)) return g;
			
		}
		return null;
	}


	static double x, y, z;

	public Gate(String name, Location p1, Location p2, Material m) {

		this.name = name;
		this.material = m;
		Location tmp1 = p1.clone();
		Location tmp2 = p2.clone();

		tmp1 = Tools.getHighPos(p1, p2);
		tmp2 = Tools.getLowPos(p1, p2);

		p1=tmp1;
		p2=tmp2;

		this.p1=p1;
		this.p2=p2;	


		x = p2.getX();
		while (x <= p1.getX()) {
			y = p2.getY();
			while (y <= p1.getY()) {
				z = p2.getZ();
				while (z <= p1.getZ()) {
					addBlock(p1.getWorld().getBlockAt(new Location(p1.getWorld(), x, y, z)));
					z++;
				}
				y++;
			}
			x++;
		}

		for (Block block : getBlocks()) {
			block.setType(getMaterial());
		}
	}

	public boolean addBlock(Block b) {
		if (!blocks.contains(b)) {
			blocks.add(b);
			return true;
		} else {
			return false;
		}
	}

	public boolean delBlock(Block b) {
		if (blocks.contains(b)) {

			blocks.remove(b);
			return true;
		} else {
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material m) {
		this.material = m;
	}

	public List<Block> getBlocks() {
		return blocks;
	}

	public boolean getState() {
		return state;
	}

	void setState(boolean state) {
		this.state = state;
	}

	public void toggleState() {
		if (getState()) {
			setState(false);
			for (Block b : getBlocks()) {
				b.setType(Material.AIR);
			} 
		} else {
			setState(true);
			for (Block b : getBlocks()) {
				b.setType(getMaterial());
			}
		}

	}
}

