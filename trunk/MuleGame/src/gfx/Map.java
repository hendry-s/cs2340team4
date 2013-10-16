package gfx;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;



public class Map
{
	ImageManager im = new ImageManager();
	
	private enum Tile {
		P, R, M1, M2, M3, T
		/*	P = Plain
		 	R = River
		 	M1 = Mountain 1
		 	M2 = Mountain 2
		 	M3 = Mountain 3
		 	T = Town
		 */
	}

    private Tile[][] tileMap;
    private final int COL = 9;
    private final int ROW = 5;
    private final int MAPULX = 24; /* X-coordinate of upper left corner of MAP*/
    private final int MAPULY = 60; /* Y-coordinate of upper left corner of MAP*/
    private final int TILESIZE = 80;

    
    public Map() {
    	tileMap = new Tile[][] {
    		{Tile.M1, Tile.P,  Tile.P,  Tile.P,  Tile.R,  Tile.P,  Tile.P,  Tile.M3, Tile.P},
    		{Tile.P,  Tile.M1, Tile.P,  Tile.P,  Tile.R,  Tile.M3, Tile.P,  Tile.P,  Tile.P},
    		{Tile.P,  Tile.M1, Tile.P,  Tile.M1, Tile.T,  Tile.P,  Tile.M3, Tile.P,  Tile.P},
    		{Tile.M3, Tile.P,  Tile.P,  Tile.P,  Tile.R,  Tile.M1, Tile.P,  Tile.P,  Tile.P},
    		{Tile.P,  Tile.P,  Tile.P,  Tile.M1, Tile.R,  Tile.P,  Tile.P,  Tile.P,  Tile.M3}
    	};
    }

	public void render(Graphics g) throws IOException {
		
		int r, c;
		BufferedImage currTile = null;
		
		for (r=0; r<ROW; r++) {
			for (c=0; c<COL; c++) {
				switch (tileMap[r][c]) {
					case M1: currTile = im.getM1TileImage(); break;
					case M2: currTile = im.getM2TileImage(); break;
					case M3: currTile = im.getM3TileImage(); break;
					case P:  currTile = im.getPlainTileImage(); break;
					case R:  currTile = im.getRiverTileImage(); break;
					case T:  currTile = im.getTownTileImage(); break;
				}
				g.drawImage(currTile, MAPULX+c*TILESIZE, MAPULY+r*TILESIZE, TILESIZE, TILESIZE, null);
			}
		}
	}
}