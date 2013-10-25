package tiles;

import java.awt.Graphics;

/**
 * PlainTile class, food specialized
 * @author  Aim4C++
 * @version Oct 25, 2013
 */
public class PlainTile extends Tile {
	
	/**
	 * Default constructor.
	 * @param x X-coordinate of the upper-left corner of the tile
	 * @param y Y-coordinate of the upper-left corner of the tile
	 **/
	public PlainTile(int x, int y) {
		super(x,y);
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
		
		g.drawImage(im.getPlainTileImage(), x, y, null);
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
