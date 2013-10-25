package tiles;
import java.awt.Graphics;

/**
 * TownTile class
 * @author  Aim4C++
 * @version Oct 25, 2013
 */
public class TownTile extends Tile {

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
	 * The operation done during one "tick".
	 * 
	 * @deprecated We're not implementing game
	 * 				in animation anymore.
	 **/
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
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