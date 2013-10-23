package tiles;

import java.awt.Graphics;

public abstract class Tile {

	protected int x, y;
	
	public Tile() {
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
}
