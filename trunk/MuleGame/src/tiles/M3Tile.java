package tiles;

import java.awt.Graphics;

import gfx.ImageManager;

public class M3Tile extends Tile {

	public M3Tile(ImageManager im) {
		super(im);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(im.getM3TileImage(), x, y, null);
	}

}
