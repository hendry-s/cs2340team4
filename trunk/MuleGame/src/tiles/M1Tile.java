package tiles;

import java.awt.Graphics;
import java.awt.Image;

public class M1Tile extends Tile implements Purchasable {

	public M1Tile() {
		key = 1;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	/*
	@Override
	public void render(Graphics g) {
		
		g.drawImage(, x, y, null);
	}
	*/
	
	public void setCoord(int x, int y) {
		
		super.x = x;
		super.y = y;
	}

}
