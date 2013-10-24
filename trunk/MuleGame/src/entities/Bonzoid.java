package entities;

import java.awt.Color;

public class Bonzoid extends Player {

	public Bonzoid(String name, Color color, String race) {
		super(name, color, race);	
		money = 1000;
		energy = 4;	// beginner default
		food = 8;	// beginner default
		ore = 0;	// beginner default
		hasMuleInMap = false;
		hasEmptyLand = true;
	}

}
