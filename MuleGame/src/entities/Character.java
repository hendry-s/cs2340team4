package entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

import gfx.Map;
import gfx.Town;

/**
 * The Character class represents a physical character entity (shown on screen). 
 * @author  Aim4C++
 * @version Oct 25, 2013
 */
public class Character implements KeyListener {

	/* Default profile of player */
	protected int x;
	protected int y;
	protected Map map;		// a map where the player is placed in 
	protected Town town;	// a town where the player is placed in
	protected ImageIcon icon;
	
	
	/* Keyboard-control related */
	private boolean up=false, dn=false, lt=false, rt=false;
	private final int SPEED = 3;
	
	
	/**
	 * Default constructor.
	 **/
	public Character() {}
	
	
	/**
	 * The operation done during one "tick".
	 * 
	 * @deprecated We're not using keyboard operation
	 * 				for character movement anymore.
	 **/
	public void tick() {
		if(up) {y -= SPEED;}
		if(dn) {y += SPEED;}
		if(lt) {x -= SPEED;}
		if(rt) {x += SPEED;}
	}

	/**
	 * Render method renders the character image on screen
	 * @param g Graphics object
	 * 
	 * NOTE: Unimplemented yet
	 **/
	public void render(Graphics g) {
		
	}
	
	
	/**
	 * keyTyped method defines what happens when key is pressed and released
	 * @param e KeyEvent object
	 * 
	 * @deprecated We're not using keyboard operation
	 * 				for character movement anymore.
	 **/	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	/**
	 * keyPressed method defines what happens when key is pressed
	 * @param e KeyEvent object
	 * 
	 * @deprecated We're not using keyboard operation
	 * 				for character movement anymore.
	 **/
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {up=true;}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {dn=true;}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {lt=true;}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {rt=true;}
		
	}
	/**
	 * keyReleased method defines what happens when key is released
	 * @param e KeyEvent object
	 * 
	 * @deprecated We're not using keyboard operation
	 * 				for character movement anymore.
	 **/
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {up=false;}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {dn=false;}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {lt=false;}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {rt=false;}
		
	}
	
	/**
	 * getCharacterIcon method is a getter for character icon
	 * @return the image icon of the player
	 **/
	public ImageIcon getCharacterIcon() {
		return icon;
	}
	
}
