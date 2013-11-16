package model;

import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;

import model.Controller;
import model.MuleType;


import gfx.Tile;

/**
 * This class represents the player and is going to be instantiated for each new player
 * Methods for query player's configurations and positions
 * 
 *
 */

public class Player {
	private String name;
	private String race;
	private int money;
	private int food;
	private int energy;
	private int smithore;
	private int crystite;
	private Color color;
	private Mule currentMule;
	int xPos, yPos, prevX, prevY, initial_x, initial_y;
	private Controller direction;
	private int size = 10;
	private ArrayList<Tile> land = new ArrayList<Tile>();
	private ArrayList<Mule> mulesNum = new ArrayList<Mule>();

	
	
	public Player(String name, int race, int color, int x, int y)
	{
		this.xPos = x;
		this.initial_x = x;
		this.yPos = y - 10;
		this.initial_y = y - 10;
		this.name = name;
		
		if (race == 0) {	//Bonzoid
			this.race = "Bonzoid";
			money = 1000;
		} else if (race == 1) {	// Buzzite
			this.race = "Buzzite";
			money = 1000;
		} else if (race == 2) {	// Flapper
			this.race = "Flapper";
			money = 1600;
		} else if (race == 3) { // Human
			this.race = "Human";
			money = 600;
		} else if (race == 4) {	// Ugaite
			this.race = "Ugaite";
			money = 1000;
		}
		
		// here we only allowing 4 color
		//0 == red, 1 == blue, 2 == yellow, 3 == green
		switch(color)
		{
		case 0:
			this.color = Color.red;
			break;
		case 1:
			this.color = Color.blue;
			break;
		case 2:
			this.color = Color.yellow;
			break;
		case 3:
			this.color = Color.green;
			break;
		}
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getSmithore() {
		return smithore;
	}

	public void setSmithore(int smithore) {
		this.smithore = smithore;
	}

	public int getCrystite() {
		return crystite;
	}

	public void setCrystite(int crystite) {
		this.crystite = crystite;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	public String getName(){
		return this.name;
	}

	public String getRace(){
		return this.race;
	}

	
	public int getNumMules()
	{
		return mulesNum.size();
	}


	public void loseMule(){
		currentMule = null;
		mulesNum.remove(mulesNum.size() - 1);
	}

	public void addMule(Mule mule){
		this.currentMule = mule;
		mulesNum.add(mule);
	}

	public boolean hasMule(){
		return (currentMule != null);
	}

	public void setPosition(int xPos, int yPos)
	{
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public int[] getPosition()
	{
		int[] pos = new int[2];
		pos[0] = this.xPos;
		pos[1] = this.yPos;
		return pos;
	}

	public int getX()
	{
		return this.xPos;
	}

	public int getY()
	{
		return this.yPos;
	}

	public void setPrevX(int prevX)
	{
		this.prevX = prevX;
	}

	public void setPrevY(int prevY)
	{
		this.prevY = prevY;
	}

	public int getPrevX()
	{
		return this.prevX;
	}

	public int getPrevY()
	{
		return this.prevY;
	}

	public Color getColor()
	{
		return this.color;
	}


	public void spend(int amt){
		this.money -= amt;
	}

	public int getMoney(){
		return this.money;
	}

	public void addMoney(int money)
	{
		this.money += money;
	}


	public void setDirection(Controller d){
		this.direction = d;
	}

	public Controller getDirection(){
		return this.direction;
	}

	public int getSize(){
		return this.size;
	}

	public void addLand(Tile t){
		land.add(t);
	}



	public ArrayList<Tile> getLand(){
		return this.land;
	}

	public void clearLand(){
		this.land.clear();
	}

	public void setLand(ArrayList<Tile> tile){
		this.land = tile;
	}



	public void resetLocation(){
		this.xPos = initial_x;
		this.yPos = initial_y;
	}


	public void clearMules(){
		this.mulesNum.clear();
	}


}