package entities;

import java.awt.Color;

import gfx.Auction;
import gfx.Map;
import gfx.Town;

public class Player extends Character {

	private String name;
	private Color color;
	
	private int money;
	private int energy;
	private int food;
	private int ore;
	private boolean hasMuleInMap;
	private boolean hasEmptyLand;	
	
	private Auction auction;
	
	public Player(String name, Color color, int x, int y, Map map, Town town, Auction auction) {
		
		super.x = x;
		super.y = y;
		super.map = map;
		super.town = town;
		this.auction = auction;
		this.name = name;
		this.color = color;
	}
	
}
