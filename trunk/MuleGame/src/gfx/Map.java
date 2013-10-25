package gfx;
import game.MuleGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	private JButton button;
	private ImageIcon currTile;
	private Border border;

    private Tile[][] tileMap;
    private final int COL = 9;
    private final int ROW = 5;
    private final int MAPULX = 25; /* X-coordinate of upper left corner of MAP*/
    private final int MAPULY = 60; /* Y-coordinate of upper left corner of MAP*/
    private final int TILESIZE = 80;

    
    public Map() {
    	
    	tileMap = new Tile[5][9];
//    	P = new PlainTile();
//    	R = new RiverTile();
//    	M1 = new M1Tile();
//    	M2 = new M2Tile();
//    	M3 = new M3Tile();
//    	T = new TownTile();
    	for(int r = 0; r < tileMap.length; r++) {
    		for(int c = 0; c < tileMap[r].length; c++) {
    			//create M1 tiles
    			if((r == 0 && c == 2) || (r == 1 && c ==1) || (r == 2 && c == 8))
    				tileMap[r][c] = new M1Tile();
    			//create M2 tiles
    			else if((r == 3 && c == 1) || (r == 3 && c == 6) || (r == 4 && c == 2) || (r == 4 && c == 8))
    				tileMap[r][c] = new M2Tile();
    			//create M3 tiles
    			else if((r == 0 && c == 6) || (r == 1 && c == 8) || (r == 2 && c == 0))
    				tileMap[r][c] = new M3Tile();
    			//create River tiles
    			else if((r == 0 && c == 4) || (r == 1 && c == 4) || (r == 3 && c == 4) || (r == 4 && c == 4))
    				tileMap[r][c] = new RiverTile();
    			//create the Town tile
    			else if(r == 2 && c == 4)
    				tileMap[r][c] = new TownTile();
    			//else all other are Plain tiles
    			else
    				tileMap[r][c] = new PlainTile();
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
		button = null;
		border = BorderFactory.createLineBorder(Color.BLUE, 5);
		
		for (r = 0; r < ROW; r++) {
			for (c = 0; c < COL; c++) {
				
				gbc.gridy = r;
				gbc.gridx = c;
				
				    if(tileMap[r][c] instanceof M1Tile) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_mountain1.png"));
				    	button = new JButton(currTile);
				    	button.setPreferredSize(new Dimension(80, 80));
				    	button.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) { 
								
								if(e.getSource() instanceof JButton) {
									
									((JButton)e.getSource()).setBorder(border);
								}
							}
				    	});
				    }
				    
				    else if(tileMap[r][c] instanceof M2Tile) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_mountain2.png"));
				    	button = new JButton(currTile);
				    	button.setPreferredSize(new Dimension(80, 80));
				    	button.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) { 

								if(e.getSource() instanceof JButton) {
									
									((JButton)e.getSource()).setBorder(border);
								}
							}
				    	});
				    }
				    
				    else if(tileMap[r][c] instanceof M3Tile) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_mountain3.png"));
				    	button = new JButton(currTile);
				    	button.setPreferredSize(new Dimension(80, 80));
				    	button.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) { 

								if(e.getSource() instanceof JButton) {
									
									((JButton)e.getSource()).setBorder(border);
								}
							}
				    	});
				    }
				    
				    else if(tileMap[r][c] instanceof TownTile) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/town.png"));
				    	button = new JButton(currTile);
				    	button.setPreferredSize(new Dimension(80, 80));
				    	button.addActionListener(new ActionListener() {   // Omar's code

							public void actionPerformed(ActionEvent e) { 

								if(e.getSource() instanceof JButton) {
									
									MuleGame.townScreen();
								}
							}
				    	});
				    }
				    
				    else if(tileMap[r][c] instanceof PlainTile) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_plain.png"));
				    	button = new JButton(currTile);
				    	button.setPreferredSize(new Dimension(80, 80));
				    	button.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) { 

								if(e.getSource() instanceof JButton) {
									
									((JButton)e.getSource()).setBorder(border);
								}
							}
				    	});
				    }
				    
				    else if(tileMap[r][c] instanceof RiverTile) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_river.png"));
				    	button = new JButton(currTile);
				    	button.setPreferredSize(new Dimension(80, 80));
				    	button.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) { 

								if(e.getSource() instanceof JButton) {
									
									((JButton)e.getSource()).setBorder(border);
								}
							}
				    	});
				    }
				    
				    gridPanel.add(button, gbc);
			}
		}
		
		return gridPanel;
	}
}