package gfx;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

import entities.Player;
import game.MuleGame;
import game.Screen3;
import tiles.M1Tile;
import tiles.M2Tile;
import tiles.M3Tile;
import tiles.PlainTile;
import tiles.RiverTile;
import tiles.Tile;
import tiles.TownTile;
import turn.Turn;

public class Town {
	
	/* initial store quantities: Beginner Default */
	private int foodQuantity = 16;
	private int energyQuantity = 16;
	private int oreQuantity = 0;
//	private int crystiteQuantity = 0;
	private int muleQuantity = 25;
	
	/* initial store prices */
	private int foodPrice = 30;
	private int energyPrice = 25;
	private int orePrice = 50;
//	private int crystitePrice = 100;
	private int mulePrice = 100;
	
	/* fees for mounting the purchased mule */
	private final int foodMountFee = 25;
	private final int energyMountFee = 50;
	private final int smithoreMountFee = 75;
//	private final int crystiteMountFee = 100;
	
	
	private JPanel townPanel;
	
    private final int COL = 9;
    private final int ROW = 5;
    private final int MAPULX = 25; /* X-coordinate of upper left corner of MAP*/
    private final int MAPULY = 60; /* Y-coordinate of upper left corner of MAP*/
    private final int TILESIZE = 80;
    
    private Player[] players;
    private Turn turn;
    
    private JButton buyFood;
    private JButton buyEnergy;
    private JButton buyOre;
    private JButton buyMule;
    private JButton exit;
	
	public Town() {
	
		this.players = Screen3.getPlayers();
		this.turn = Screen3.getTurn();
		
		townPanel = new JPanel();
		townPanel.setBounds(MAPULX, MAPULY, 724, 404);
		townPanel.setBackground(Color.WHITE);
		townPanel.setLayout(new FlowLayout());
		
		buyFood = new JButton("Buy Food (Stock: " + foodQuantity + ")");
		buyFood.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { 
				
				if(e.getSource() instanceof JButton) {
					
					buyProduct((JButton)e.getSource(), "Food");
				}
			}
    	});
		
		buyEnergy = new JButton("Buy Energy (Stock: " + energyQuantity + ")");
		buyEnergy.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { 
				
				if(e.getSource() instanceof JButton) {
					
					buyProduct((JButton)e.getSource(), "Energy");
				}
			}
    	});
		
		buyOre = new JButton("Buy Ore (Stock: " + oreQuantity + ")");
		buyOre.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { 
				
				if(e.getSource() instanceof JButton) {
					
					buyProduct((JButton)e.getSource(), "Ore");
				}
			}
    	});
		
		buyMule = new JButton("Buy Mule (Stock: " + muleQuantity + ")");
		buyMule.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { 
				
				if(e.getSource() instanceof JButton) {
					
					buyProduct((JButton)e.getSource(), "Mule");
				}
			}
    	});
		
		exit = new JButton("Exit to Map");
		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { 
				
				if(e.getSource() instanceof JButton) {
					
					MuleGame.exitToMap();
				}
			}
    	});
		
		townPanel.add(buyFood);
		townPanel.add(buyEnergy);
		townPanel.add(buyOre);
		townPanel.add(buyMule);
		townPanel.add(exit);
    }
	
	public void buyProduct(JButton but, String product)
	{
		
		
		switch (product)
		{
			case "Food":
				if (foodQuantity != 0)
				{
					if (turn.getTurnCount()%2 == 1) // if p1's turn
					{
						System.out.println(players[0].getName() + " money: " + players[0].getMoney() + " foodPrice: " + foodPrice);
						if (players[0].getMoney() >= foodPrice)
						{
							players[0].purchase(foodPrice);
							foodQuantity--;
							but.setText("Buy Food (Stock: " + foodQuantity + ")");
						}
						else
							System.out.println("Not enough money");
						
						System.out.println(players[0].getName() + " money after: " + players[0].getMoney());
					}
					else	// p2's turn
					{
						if (players[1].getMoney() >= foodPrice)
						{
							players[1].purchase(foodPrice);
							foodQuantity--;
							but.setText("Buy Food (Stock: " + foodQuantity + ")");
						}
						else
							System.out.println("Not enough money");
					}
				}
				break;
			case "Energy":
				if (energyQuantity != 0)
				{
					if (turn.getTurnCount()%2 == 1) // if p1's turn
					{
						System.out.println(players[0].getName() + " money: " + players[0].getMoney() + " energyPrice: " + energyPrice);
						if (players[0].getMoney() >= energyPrice)
						{
							players[0].purchase(energyPrice);
							energyQuantity--;
							but.setText("Buy Energy (Stock: " + energyQuantity + ")");
						}
						else
							System.out.println("Not enough money");
						
						System.out.println(players[0].getName() + " money after: " + players[0].getMoney());
					}
					else	// p2's turn
					{
						if (players[1].getMoney() >= energyPrice)
						{
							players[1].purchase(energyPrice);
							foodQuantity--;
							but.setText("Buy Energy (Stock: " + energyQuantity + ")");
						}
						else
							System.out.println("Not enough money");
					}
				}
				break;
			case "Ore":
				if (oreQuantity != 0)
				{
					if (turn.getTurnCount()%2 == 1) // if p1's turn
					{
						System.out.println(players[0].getName() + " money: " + players[0].getMoney() + " orePrice: " + orePrice);
						if (players[0].getMoney() >= orePrice)
						{
							players[0].purchase(orePrice);
							oreQuantity--;
							but.setText("Buy Ore (Stock: " + oreQuantity + ")");
						}
						else
							System.out.println("Not enough money");
						
						System.out.println(players[0].getName() + " money after: " + players[0].getMoney());
					}
					else	// p2's turn
					{
						if (players[1].getMoney() >= orePrice)
						{
							players[1].purchase(orePrice);
							oreQuantity--;
							but.setText("Buy Ore (Stock: " + oreQuantity + ")");
						}
						else
							System.out.println("Not enough money");
					}
				}
				break;
			case "Mule":
				if (muleQuantity != 0)
				{
					if (turn.getTurnCount()%2 == 1) // if p1's turn
					{
						System.out.println(players[0].getName() + " money: " + players[0].getMoney() + " mulePrice: " + mulePrice);
						if (players[0].getMoney() >= mulePrice)
						{
							players[0].purchase(mulePrice);
							muleQuantity--;
							but.setText("Buy Mule (Stock: " + muleQuantity + ")");
						}
						else
							System.out.println("Not enough money");
						
						System.out.println(players[0].getName() + " money after: " + players[0].getMoney());
					}
					else	// p2's turn
					{
						if (players[1].getMoney() >= mulePrice)
						{
							players[1].purchase(mulePrice);
							muleQuantity--;
							but.setText("Buy Mule (Stock: " + muleQuantity + ")");
						}
						else
							System.out.println("Not enough money");
					}
				}
				break;
			
		}
	}
	
	public JPanel getPanel() {
		return townPanel;
	}
	
	public int getFoodQuantity() {return foodQuantity; }
	public int getEnergyQuantity() {return energyQuantity; }
	public int getOreQuantity() {return oreQuantity; }
	public int getMuleQuantity() { return muleQuantity; }
	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}
	public void setEnergyQuantity(int energyQuantity) {
		this.energyQuantity = energyQuantity;
	}
	public void setOreQuantity(int oreQuantity) {
		this.oreQuantity = oreQuantity;
	}
	public void setMuleQuantity(int muleQuantity) {
		this.muleQuantity = muleQuantity;
	}
}