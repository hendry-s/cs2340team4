package tiles;

import java.awt.Graphics;

public abstract class Tile {

	protected int x, y;
	public Tile() {}
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
}
