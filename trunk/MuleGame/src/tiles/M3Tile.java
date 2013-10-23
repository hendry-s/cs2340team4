package tiles;

import java.awt.Graphics;

public class M3Tile extends Tile {

	public M3Tile() {
		key = 3;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
/*
	@Override
	public void render(Graphics g) {
		g.drawImage(im.getM3TileImage(), x, y, null);
	}
*/
	public void setCoord(int x, int y) {
		
		super.x = x;
		super.y = y;
	}
}
