package tiles;

import java.awt.Graphics;

public class M1Tile extends Tile implements Purchasable {

	public M1Tile() {
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(im.getM1TileImage(), x, y, null);
		
	}
	
	public void setCoord(int x, int y) {
		
		super.x = x;
		super.y = y;
	}

}
