package tiles;

import java.awt.Graphics;

import gfx.ImageManager;

public class M2Tile extends Tile {

	public M2Tile(ImageManager im) {
		super(im);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(im.getM2TileImage(), x, y, null);
	}

}
