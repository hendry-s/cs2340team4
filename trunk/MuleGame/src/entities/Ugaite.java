package entities;

import java.awt.Color;

public class Ugaite extends Player {

	public Ugaite(String name, Color color, String race) {
		super(name, color, race);

		money = 1000;
		energy = 4;	// beginner default
		food = 8;	// beginner default
		ore = 0;	// beginner default
		hasMuleInMap = false;
		hasEmptyLand = true;
	}

}
