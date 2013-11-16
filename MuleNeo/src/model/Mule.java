package model;
import java.io.IOException;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import model.MuleType;
import model.Controller;





public class Mule {
	private Player owner;
	private int x_pos;
	private int y_pos;
	private MuleType muleType;
	private int numOfMule;
	
	public Mule(Player p, MuleType muleType){
		this.owner = p;
		this.muleType = muleType;
	}
	
	public void setMuleType(MuleType muleType){
		this.muleType = muleType;
	}
	
	public MuleType getMuleType(){
		return this.muleType;
	}
	
	public void setX(int x){
		this.x_pos = x;
	}
	
	public void setY(int y){
		this.y_pos = y;
	}
}
