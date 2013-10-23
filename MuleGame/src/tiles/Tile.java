package tiles;

import java.awt.Graphics;

public abstract class Tile {

	protected int x, y;
	protected int key;
	
	public Tile() {
		
	}
	
	public int getKey()
	{
		return key;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
}
