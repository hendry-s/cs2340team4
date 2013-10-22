package entities;

import java.awt.Color;
import java.awt.Graphics;

import gfx.Auction;
import gfx.Map;
import gfx.Town;

public class Player extends Character {

	private String name;
	private Color color;
	private String race;
	private int money;
	private int energy;
	private int food;
	private int ore;
	private boolean hasMuleInMap;
	private boolean hasEmptyLand;	
	
	private Auction auction;
	
	public Player(String name, Color color, String race) {
		
		this.name = name;
		this.color = color;
		this.race = race;
	}
	
	@Override
	public void render(Graphics g) {
		
		
	}
	
	public void setCoord(int x, int y) {
		
		super.x = x;
		super.y = y;
	}
	
	public void setMap(Map map) {
		
		super.map = map;
	}
	
	public void setTown(Town town) {
		
		super.town = town;
	}
	
	public String getName(){
		return name;
	}
	
	public Color getColor(){
		return color;
	}
	
	public String getRace(){
		return race;
	}
}
