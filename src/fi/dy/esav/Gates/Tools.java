package fi.dy.esav.Gates;

import org.bukkit.Location;

public class Tools {
    public static Location getLowPos(Location p1, Location p2){
        return new Location(
        		p1.getWorld(),
                Math.min(p1.getX(), p2.getX()),
                Math.min(p1.getY(), p2.getY()),
                Math.min(p1.getZ() , p2.getZ())
        );
    }
    public static Location getHighPos(Location p1, Location p2){
        return new Location(
        		p1.getWorld(),
                Math.max(p1.getX(), p2.getX()),
                Math.max(p1.getY(), p2.getY()),
                Math.max(p1.getZ(), p2.getZ())
        );
    }
}
