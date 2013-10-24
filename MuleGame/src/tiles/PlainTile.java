package tiles;

import java.awt.Graphics;

public class PlainTile extends Tile {
	public PlainTile(){}
	public PlainTile(int x, int y) {

		
	}

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
	public void setCoord(int x, int y) {
		
		super.x = x;
		super.y = y;
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
