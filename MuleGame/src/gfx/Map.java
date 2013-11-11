package gfx;
import entities.Player;
import game.MuleGame;
import game.Screen3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
import turn.Turn;

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

    private Player[] players;
    private boolean townClickable = false;
    private boolean landClickable = true;
    
    private Turn turn;
    
    public Map() {
    	
    	this.players = Screen3.getPlayers();
    	turn = Screen3.getTurn();
    	
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
   
    public void startRound()
    {
    	townClickable = false;
    	landClickable = true;
    	
    	Player player = turn.getPlayerTurn();
    	
    	// Update game and turn labels on Screen3 JPanel.
    	Screen3 sc3 = MuleGame.getSC3();
    	sc3.setGameLabel("Land grant: Round " + turn.getRoundCount());
    	sc3.setTurnLabel(player.getName() + ", select a land.", player.getColor());
    	
    	if (turn.getRoundCount() > 2)
    	{
    		sc3.setPassButtonVisible(true);
    		sc3.setTurnLabel(player.getName() + ", purchase a land. Money: $" + player.getMoney(), player.getColor());
    	}
    }
    
    public void startTurn()
    {
    	townClickable = true;
    	
//    	// Start new turn by incrementing turnCount attribute.
//    	turn.incrementTurnCount();
    	
    	// To draw onto Screen3 JPanel
    	Screen3 sc3 = MuleGame.getSC3();
    	sc3.setGameLabel(turn.toString() + "   Enter town to start");
    	sc3.setPassButtonVisible(false);
    	
    	// Determine player turn
    	Player player = turn.getPlayerTurn();
    	sc3.setTurnLabel(player.getName() + "'s turn", player.getColor());
		//System.out.println(player.getName() + "'s turn"); // DEBUG purposes
		
		// Start new turn by incrementing turnCount attribute.
    	turn.incrementTurnCount();
    }
    
    public void passLandSelect()
    {
    	//Determine player land select
     	Player player = turn.getPlayerTurn();
     	turn.endPlayerTurn();	// increment index for player order[].
     	
     	if (turn.isLandSelectComplete() == true)
     	{
     		landClickable = false;
     		townClickable = true;
     		startTurn();
     	}
     	else
     	{
     		// Set turn status to next player
     		player = turn.getPlayerTurn();
     		Screen3 sc3 = MuleGame.getSC3();
         	sc3.setGameLabel("Land grant: Round " + (turn.getRoundCount()));
         	sc3.setTurnLabel(player.getName() + ", select a land.", player.getColor());
     	}
    }

    public void landSelect(JButton but, Border border, Tile tile)
    {    	 	
    	
    	// Determine player land select
    	Player player = turn.getPlayerTurn();
    	
    	// Land is free the first 2 rounds.
    	if (turn.getRoundCount() > 2)
    	{
	    	
	    	if (player.getMoney() >= tile.getPrice())	
			{
				player.purchase(tile.getPrice(), "Land");
			}
	    	else	// If player has insufficient funds to purchase land.
	    	{
	    		Screen3 sc3 = MuleGame.getSC3();
	        	sc3.setTurnLabel(player.getName() + " has insufficient funds: Money: $" + player.getMoney() + " < Land: $" + tile.getPrice(), player.getColor());
	        	return;
	    	}
    	}
    	
    	border = BorderFactory.createLineBorder(player.getColor(), 5);
    	but.setBorder(border);
		but.setEnabled(false);	// Tile becomes unclickable because a player now occupies it.
    	
    	turn.endPlayerTurn();	// increment index for player order[].
    	
    	if (turn.isLandSelectComplete() == true)
    	{
    		landClickable = false;
    		townClickable = true;
    		startTurn();
    	}
    	else
    	{
    		if (turn.getRoundCount() <= 2)
    		{
	    		// Set turn status to next player
	    		player = turn.getPlayerTurn();
	    		Screen3 sc3 = MuleGame.getSC3();
	        	sc3.setGameLabel("Land grant: Round " + (turn.getRoundCount()));
	        	sc3.setTurnLabel(player.getName() + ", select a land.", player.getColor());
    		}
    		else
    		{
    			// Set turn status to next player
	    		player = turn.getPlayerTurn();
	    		Screen3 sc3 = MuleGame.getSC3();
	        	sc3.setGameLabel("Land grant: Round " + (turn.getRoundCount()));
	        	sc3.setTurnLabel(player.getName() + ", purchase a land. Money: $" + player.getMoney(), player.getColor());
    		}
    	}
    			
		
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
		border = BorderFactory.createLineBorder(players[0].getColor(), 5);  // p1 goes first
		
		for (r = 0; r < ROW; r++) {
			for (c = 0; c < COL; c++) {
				
				gbc.gridy = r;
				gbc.gridx = c;
				
				    if(tileMap[r][c] instanceof M1Tile) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_mountain1.png"));
				    	button = new JButton(currTile);
				    	button.setPreferredSize(new Dimension(80, 80));
				    	final int row = r; // To save the row of the button.
				    	final int col = c; // To save the column of the button.
				    	button.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) { 
								
								if(e.getSource() instanceof JButton) {
									
									//System.out.println("row: " + row + " col: " + col); // DEBUG purposes
									//System.out.println("Price: " + tileMap[row][col].getPrice()); // DEBUG purposes
									//System.out.println("Round: " + turn.getRoundCount());	// DEBUG purposes
									
									if (landClickable == true)
									{
										if (turn.getRoundCount() <= 2) // Land is free for first 2 rounds.
											landSelect((JButton)e.getSource(), border, tileMap[row][col]);
										
									}	
								}
							}
				    	});
				    }
				    
				    else if(tileMap[r][c] instanceof M2Tile) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_mountain2.png"));
				    	button = new JButton(currTile);
				    	button.setPreferredSize(new Dimension(80, 80));
				    	final int row = r; // To save the row of the button.
				    	final int col = c; // To save the column of the button.
				    	button.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) { 

								if(e.getSource() instanceof JButton) {
									
									//System.out.println("row: " + row + " col: " + col); // DEBUG purposes
									//System.out.println("Price: " + tileMap[row][col].getPrice()); // DEBUG purposes
									//System.out.println("Round: " + turn.getRoundCount());	// DEBUG purposes
									
									if (landClickable == true)
										landSelect((JButton)e.getSource(), border, tileMap[row][col]);
								}
							}
				    	});
				    }
				    
				    else if(tileMap[r][c] instanceof M3Tile) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_mountain3.png"));
				    	button = new JButton(currTile);
				    	button.setPreferredSize(new Dimension(80, 80));
				    	final int row = r; // To save the row of the button.
				    	final int col = c; // To save the column of the button.
				    	button.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) { 

								if(e.getSource() instanceof JButton) {
									
									//System.out.println("row: " + row + " col: " + col); // DEBUG purposes
									//System.out.println("Price: " + tileMap[row][col].getPrice()); // DEBUG purposes
									//System.out.println("Round: " + turn.getRoundCount());	// DEBUG purposes
									
									if (landClickable == true)
										landSelect((JButton)e.getSource(), border, tileMap[row][col]);
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
									
									if (townClickable == true)
									{
										MuleGame.showTownScreen(); // Display Town Screen.
									}
								}
							}
				    	});
				    }
				    
				    else if(tileMap[r][c] instanceof PlainTile) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_plain.png"));
				    	button = new JButton(currTile);
				    	button.setPreferredSize(new Dimension(80, 80));
				    	final int row = r; // To save the row of the button.
				    	final int col = c; // To save the column of the button.
				    	button.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) { 

								if(e.getSource() instanceof JButton) {
									
									//System.out.println("row: " + row + " col: " + col); // DEBUG purposes
									//System.out.println("Price: " + tileMap[row][col].getPrice()); // DEBUG purposes
									//System.out.println("Round: " + turn.getRoundCount());	// DEBUG purposes
									
									if (landClickable == true)
										landSelect((JButton)e.getSource(), border, tileMap[row][col]);
								}
							}
				    	});
				    }
				    
				    else if(tileMap[r][c] instanceof RiverTile) {
				    	
				    	currTile = new ImageIcon(Map.class.getResource("/MULEIMAGE/resources/icon_river.png"));
				    	button = new JButton(currTile);
				    	button.setPreferredSize(new Dimension(80, 80));
				    	final int row = r; // To save the row of the button.
				    	final int col = c; // To save the column of the button.
				    	button.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) { 

								if(e.getSource() instanceof JButton) {
									
									//System.out.println("row: " + row + " col: " + col); // DEBUG purposes
									//System.out.println("Price: " + tileMap[row][col].getPrice()); // DEBUG purposes
									//System.out.println("Round: " + turn.getRoundCount());	// DEBUG purposes
									
									if (landClickable == true)
										landSelect((JButton)e.getSource(), border, tileMap[row][col]);
								}
							}
				    	});
				    }
				    
				    gridPanel.add(button, gbc);
			}
		}
		
		return gridPanel;
	}
	
	public JButton getButton() {
		
		return button;
	}
	
}