package tiles;

import java.awt.Graphics;

import gfx.ImageManager;

public class M1Tile extends Tile implements Passable {

	public M1Tile(ImageManager im) {
		super(im);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(im.getM1TileImage(), x, y, null);
		
	}

}
