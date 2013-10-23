package tiles;

import java.awt.Graphics;

public class RiverTile extends Tile {
	
	public RiverTile() {
		key = 5;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(, x, y, null);
	}
	
	public void setCoord(int x, int y) {
		
		super.x = x;
		super.y = y;
	}

}
