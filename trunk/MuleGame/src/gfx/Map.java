package gfx;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

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
	private JLabel label;
	private ImageIcon currTile;
	private Border border;

    private Tile[][] tileMap;
    private final int COL = 9;
    private final int ROW = 5;
    private final int MAPULX = 25; /* X-coordinate of upper left corner of MAP*/
    private final int MAPULY = 60; /* Y-coordinate of upper left corner of MAP*/
    private final int TILESIZE = 80;
    private JLabel[] lArray;
    private int i;

    
    public Map() {
    	tileMap = new Tile[5][9];
//    	P = new PlainTile();
//    	R = new RiverTile();
//    	M1 = new M1Tile();
//    	M2 = new M2Tile();
//    	M3 = new M3Tile();
//    	T = new TownTile();
    	for(int i = 0; i < tileMap.length; i++) {
    		for(int j = 0; j < tileMap[i].length; j++) {
    			//create M1 tiles
    			if((i == 0 && j == 2) || (i == 1 && j ==1) || (i == 2 && j == 8))
    				tileMap[i][j] = new M1Tile();
    			//create M2 tiles
    			else if((i == 3 && j == 1) || (i == 3 && j == 6) || (i == 4 && j == 2) || (i == 4 && j == 8))
    				tileMap[i][j] = new M2Tile();
    			//create M3 tiles
    			else if((i == 0 && j == 6) || (i == 1 && j == 8) || (i == 2 && j == 0))
    				tileMap[i][j] = new M3Tile();
    			//create River tiles
    			else if((i == 0 && j == 4) || (i == 1 && j == 4) || (i == 3 && j == 4) || (i == 4 && j == 4))
    				tileMap[i][j] = new RiverTile();
    			//create the Town tile
    			else if(i == 2 && j == 4)
    				tileMap[i][j] = new TownTile();
    			//else all other are Plain tiles
    			else
    				tileMap[i][j] = new PlainTile();
    		}
    	}
//    	tileMap = new Tile[][] {
//    		{P,  P,  M1, P,  R,  P,  M3, P,  P},
//    		{P,  M1, P,  P,  R,  P,  P,  P,  M3},
//    		{M3, P,  P,  P,  T,  P,  P,  P,  M1},
//    		{P,  M2, P,  P,  R,  P,  M2, P,  P},
//    		{P,  P,  M2, P,  R,  P,  P,  P,  M2}
//    	};
    }

	public JPanel render() {
		
		gridPanel = new JPanel();
		gridPanel.setBounds(MAPULX, MAPULY, 724, 404);
		gridPanel.setBackground(Color.WHITE);
		gridPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		int r, c;
		currTile = null;
		label = null;
		border = BorderFactory.createLineBorder(Color.BLUE, 5);;
		
		for (r = 0; r < ROW; r++) {
			for (c = 0; c < COL; c++) {
				
				gbc.gridy = r;
				gbc.gridx = c;
				
				    if(tileMap[r][c] instanceof M1Tile) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_mountain1.png"));
				    	label = new JLabel(currTile);
				    	label.setPreferredSize(new Dimension(80, 80));
				    	label.addMouseListener(new MouseAdapter() {
				    		
				    		public void mouseClicked(MouseEvent e) {
				    			
				    			if(e.getComponent() == label) {
				    				
				    				label.setBorder(border);
				    			}
				    		}
				    	});
				    }
				    
				    else if(tileMap[r][c] instanceof M2Tile) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_mountain2.png"));
				    	label = new JLabel(currTile);
				    	label.setPreferredSize(new Dimension(80, 80));
				    	label.addMouseListener(new MouseAdapter() {
				    		
				    		public void mouseClicked(MouseEvent e) {
				    			
				    			if(e.getComponent() == label) {
				    				
				    				label.setBorder(border);
				    			}
				    		}
				    	});
				    }
				    
				    else if(tileMap[r][c] instanceof M3Tile) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_mountain3.png"));
				    	label = new JLabel(currTile);
				    	label.setPreferredSize(new Dimension(80, 80));
				    	label.addMouseListener(new MouseAdapter() {
				    		
				    		public void mouseClicked(MouseEvent e) {
				    			
				    			if(e.getComponent() == label) {
				    				
				    				label.setBorder(border);
				    			}
				    		}
				    	});
				    }
				    
				    else if(tileMap[r][c] instanceof TownTile) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/town.png"));
				    	label = new JLabel(currTile);
				    	label.setPreferredSize(new Dimension(80, 80));
				    	label.addMouseListener(new MouseAdapter() {
				    		
				    		public void mouseClicked(MouseEvent e) {
				    			
				    			if(e.getComponent() == label) {
				    				
				    				label.setBorder(border);
				    			}
				    		}
				    	});
				    }
				    
				    else if(tileMap[r][c] instanceof PlainTile) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_plain.png"));
				    	label = new JLabel(currTile);
				    	label.setPreferredSize(new Dimension(80, 80));
				    	label.addMouseListener(new MouseAdapter() {
				    		
				    		public void mouseClicked(MouseEvent e) {
				    			
				    			if(e.getComponent() == label) {
				    				
				    				label.setBorder(border);
				    			}
				    		}
				    	});
				    }
				    
				    else if(tileMap[r][c] instanceof RiverTile) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_river.png"));
				    	label = new JLabel(currTile);
				    	label.setPreferredSize(new Dimension(80, 80));
				    	label.addMouseListener(new MouseAdapter() {
				    		
				    		public void mouseClicked(MouseEvent e) {
				    			
				    			if(e.getComponent() == label) {
				    				
				    				label.setBorder(border);
				    			}
				    		}
				    	});
				    }
				    
				    gridPanel.add(label, gbc);
			}
		}
		
		return gridPanel;
	}
}



