package tiles;

import java.awt.Graphics;

public class RiverTile extends Tile {

	public RiverTile() {
		
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
