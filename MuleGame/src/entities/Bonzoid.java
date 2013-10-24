package entities;

import gfx.Map;

import java.awt.Color;

import javax.swing.ImageIcon;

public class Bonzoid extends Player {

	public Bonzoid(String name, Color color, String race) {
		super(name, color, race);	
		money = 1000;
		energy = 4;	// beginner default
		food = 8;	// beginner default
		ore = 0;	// beginner default
		hasMuleInMap = false;
		hasEmptyLand = true;
		
		icon = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/CharacterIcon_Bonzoid.png"));
	}

}
