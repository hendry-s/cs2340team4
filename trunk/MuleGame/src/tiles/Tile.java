package tiles;

import java.awt.Graphics;
import gfx.ImageManager;

public abstract class Tile {

	protected ImageManager im;
	protected int x, y;
	
	public Tile(ImageManager im) {
		this.im = im;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
}
