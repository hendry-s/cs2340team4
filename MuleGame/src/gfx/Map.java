package gfx;

import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Map
{
	
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

    
    public Map() {
    	tileMap = new Tile[][] {
    		{Tile.M1, Tile.P,  Tile.P,  Tile.P,  Tile.R,  Tile.P,  Tile.P,  Tile.M3, Tile.P},
    		{Tile.P,  Tile.M1, Tile.P,  Tile.P,  Tile.R,  Tile.M3, Tile.P,  Tile.P,  Tile.P},
    		{Tile.P,  Tile.M1, Tile.P,  Tile.M1, Tile.T,  Tile.P,  Tile.M3, Tile.P,  Tile.P},
    		{Tile.M3, Tile.P,  Tile.P,  Tile.P,  Tile.R,  Tile.M1, Tile.P,  Tile.P,  Tile.P},
    		{Tile.P,  Tile.P,  Tile.P,  Tile.M1, Tile.R,  Tile.P,  Tile.P,  Tile.P,  Tile.M3}
    	};
    }


    
/*    
    public void draw(Graphics g)
        {
            int ix=0;
            int iy=0;
            for(int row=0;row<height;row++)
            {
                for(int col=0;col<height;col++)
                {
                    if(tileMap[row][col]==0)
                    {
                         g.drawImage(BLOCK, ix, iy, null);
                         ix=ix+16;
                    }
                }
            }
        }
*/
}