package gfx;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tiles.M1Tile;
import tiles.M2Tile;
import tiles.M3Tile;
import tiles.PlainTile;
import tiles.RiverTile;
import tiles.Tile;
import tiles.TownTile;

public class Map
{
	private JPanel gridPanel;
	private Tile P, R, M1, M2, M3, T;

    private Tile[][] tileMap;
    private final int COL = 9;
    private final int ROW = 5;
    private final int MAPULX = 25; /* X-coordinate of upper left corner of MAP*/
    private final int MAPULY = 60; /* Y-coordinate of upper left corner of MAP*/
    private final int TILESIZE = 80;

    
    public Map() {
    	
    	P = new PlainTile();
    	R = new RiverTile();
    	M1 = new M1Tile();
    	M2 = new M2Tile();
    	M3 = new M3Tile();
    	T = new TownTile();
    	
    	tileMap = new Tile[][] {
    		{M1, P,  P,  P,  R,  P,  P,  M3, P},
    		{P,  M1, P,  P,  R,  M3, P,  P,  P},
    		{P,  M1, P,  M1, T,  P,  M3, P,  P},
    		{M3, P,  P,  P,  R,  M1, P,  P,  P},
    		{P,  P,  P,  M1, R,  P,  P,  P,  M3}
    	};
    }

	public JPanel render() {
		
		gridPanel = new JPanel();
		gridPanel.setBounds(MAPULX, MAPULY, 724, 404);
		gridPanel.setBackground(Color.WHITE);
		gridPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		int r, c;
		ImageIcon currTile = null;
		JLabel label = null;
		
		for (r = 0; r < ROW; r++) {
			for (c = 0; c < COL; c++) {
				
				gbc.gridy = r;
				gbc.gridx = c;
				
				    if(tileMap[r][c] == M1) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_mountain1.png"));
				    	label = new JLabel(currTile);
				    }
				    
				    else if(tileMap[r][c] == M2) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_mountain2.png"));
				    	label = new JLabel(currTile);
				    }
				    
				    if(tileMap[r][c] == M3) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_mountain3.png"));
				    	label = new JLabel(currTile);
				    }
				    
				    if(tileMap[r][c] == T) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/town.png"));
				    	label = new JLabel(currTile);
				    }
				    
				    if(tileMap[r][c] == P) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_plain.png"));
				    	label = new JLabel(currTile);
				    }
				    
				    if(tileMap[r][c] == R) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_river.png"));
				    	label = new JLabel(currTile);
				    }
				    
				    gridPanel.add(label, gbc);
			}
		}
		
		return gridPanel;
	}
}