package tiles;

import java.awt.Graphics;

import gfx.ImageManager;

public class RiverTile extends Tile {

	public RiverTile(ImageManager im) {
		super(im);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(im.getRiverTileImage(), x, y, null);
	}

}
