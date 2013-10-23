package tiles;

import java.awt.Graphics;

public class M2Tile extends Tile {

	public M2Tile() {
		key = 2;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
/*
	@Override
	public void render(Graphics g) {
		g.drawImage(im.getM2TileImage(), x, y, null);
	}
*/	
	public void setCoord(int x, int y) {
		
		super.x = x;
		super.y = y;
	}

}
