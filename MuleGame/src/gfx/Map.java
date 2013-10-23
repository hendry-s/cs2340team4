package gfx;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;

import tiles.M1Tile;
import tiles.M2Tile;
import tiles.M3Tile;
import tiles.PlainTile;
import tiles.RiverTile;
import tiles.Tile;



public class Map
{
	
	private Tile P, R, M1, M2, M3, T;

    private Tile[][] tileMap;
    private final int COL = 9;
    private final int ROW = 5;
    private final int MAPULX = 24; /* X-coordinate of upper left corner of MAP*/
    private final int MAPULY = 60; /* Y-coordinate of upper left corner of MAP*/
    private final int TILESIZE = 80;

    
    public Map() {
    	
    	P = new PlainTile();
    	R = new RiverTile();
    	M1 = new M1Tile();
    	M2 = new M2Tile();
    	M3 = new M3Tile();
    	
    	tileMap = new Tile[][] {
    		{M1, P,  P,  P,  R,  P,  P,  M3, P},
    		{P,  M1, P,  P,  R,  M3, P,  P,  P},
    		{P,  M1, P,  M1, T,  P,  M3, P,  P},
    		{M3, P,  P,  P,  R,  M1, P,  P,  P},
    		{P,  P,  P,  M1, R,  P,  P,  P,  M3}
    	};
    }

	public void render(Graphics g) throws IOException {
		
		int r, c;
		ImageIcon currTile = null;
		
		for (r = 0; r < ROW; r++) {
			for (c = 0; c < COL; c++) {
				switch (tileMap[r][c]) {
					case M1: currTile = new ImageIcon(getClass().getClassLoader().getResource("**res/icon_mountain1.png**")); break;
					case M2: currTile = new ImageIcon(getClass().getClassLoader().getResource("**res/icon_mountain2.png**")); break;
					case M3: new ImageIcon(getClass().getClassLoader().getResource("**res/icon_mountain3.png**")); break;
					case P:  currTile = new ImageIcon(getClass().getClassLoader().getResource("**res/icon_plain.png**")); break;
					case R:  currTile = new ImageIcon(getClass().getClassLoader().getResource("**res/icon_river.png**")); break;
				}
				g.drawImage(currTile, MAPULX+c*TILESIZE, MAPULY+r*TILESIZE, TILESIZE, TILESIZE, null);
			}
		}
	}
}