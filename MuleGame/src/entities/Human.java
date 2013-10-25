package entities;

import gfx.Map;

import java.awt.Color;

import javax.swing.ImageIcon;


/**
 * The Human class represents Human, one type of 5 Players. 
 * @author  Aim4C++
 * @version Oct 25, 2013
 */
public class Human extends Player {

	/**
	 * Default constructor.
	 * @param name Name of the player
	 * @param color Color of the player
	 * @param race Race of the player
	 * */
	public Human(String name, Color color, String race) {
		super(name, color, race);
		
		money = 600;
		energy = 4;	// beginner default
		food = 8;	// beginner default
		ore = 0;	// beginner default
		hasMuleInMap = false;
		hasEmptyLand = true;
		
		icon = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/CharacterIcon_Human.png"));
	}

	
	
}
