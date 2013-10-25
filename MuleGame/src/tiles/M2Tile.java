package tiles;

import java.awt.Graphics;

/**
 * M1Tile class represents the tile with 2 mountains (ore specialized)
 * @author  Aim4C++
 * @version Oct 25, 2013
 */
public class M2Tile extends Tile {

	/**
	 * Default constructor.
	 **/
	public M2Tile() {
		
	}

	/**
	 * The operation done during one "tick".
	 * 
	 * @deprecated We're not implementing game
	 * 				in animation anymore.
	 **/
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
/*
	@Override
	public void render(Graphics g) {
		g.drawImage(im.getM2TileImage(), x, y, null);
	}
*/	
	
	/**
	 * Setter for x and y coordinates
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 **/
	public void setCoord(int x, int y) {
		
		super.x = x;
		super.y = y;
	}

	/**
	 * Render method (overriding of its parent, Character class)
	 * @param g Graphics object
	 * 
	 * NOTE: Unimplemented yet
	 **/
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
