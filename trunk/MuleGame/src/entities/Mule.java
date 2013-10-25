package entities;
import javax.swing.ImageIcon;

import gfx.Map;
import gfx.Town;



/**
 * The Mule class represents Mule, one of the characters and property of a player. 
 * @author  Aim4C++
 * @version Oct 25, 2013
 * 
 * NOTE: 	This class does not function as it's supposed to.
 * 			It will go through major updates in future.
 */
public class Mule extends Character {

	/**
	 * Default constructor.
	 * @param x Starting x-coordinate
	 * @param y Starting y-coordinate
	 * @param map Map where mule object will be presented on
	 * @param town Town where mule object will be presented on
	 * 
	 **/
	public Mule(int x, int y, Map map, Town town) {
		
		super.x = x;
		super.y = y;
		super.map = map;
		super.town = town;
		
		icon = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/CharacterIcon_Mule.png"));
	}
}
