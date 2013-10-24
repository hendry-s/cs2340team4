package entities;
import javax.swing.ImageIcon;

import gfx.Map;
import gfx.Town;

public class Mule extends Character {

	public Mule(int x, int y, Map map, Town town) {
		
		super.x = x;
		super.y = y;
		super.map = map;
		super.town = town;
		
		icon = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/CharacterIcon_Mule.png"));
	}
}
