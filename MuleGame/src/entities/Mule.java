package entities;
import gfx.Map;
import gfx.Town;

public class Mule extends Character {

	public Mule(int x, int y, Map map, Town town) {
		
		super.x = x;
		super.y = y;
		super.map = map;
		super.town = town;
	}
}
