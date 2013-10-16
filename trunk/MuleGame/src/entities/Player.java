package entities;

import gfx.Auction;
import gfx.Map;
import gfx.Town;

import java.awt.event.KeyEvent;

public class Player extends Character {

	private String name;
//	private Color color;
	
	private int money;
	private int energy;
	private int food;
	private int ore;
	private boolean hasMuleInMap;
	private boolean hasEmptyLand;	
	
	private Auction auction;
	
	public Player(int x, int y, Map map, Town town, Auction auction) {
		super.x = x;
		super.y = y;
		super.map = map;
		super.town = town;
		this.auction = auction;
	}
	
}
