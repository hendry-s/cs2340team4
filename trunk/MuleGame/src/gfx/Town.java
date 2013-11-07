package gfx;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Player;
import game.MuleGame;
import game.Screen3;
import game.Screen4;
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
	private JPanel storePanel;

	private final int COL = 9;
	private final int ROW = 5;
	private final int MAPULX = 25; /* X-coordinate of upper left corner of MAP*/
	private final int MAPULY = 60; /* Y-coordinate of upper left corner of MAP*/
	private final int TILESIZE = 80;

	private Player[] players;
	private Turn turn;
	private Screen4 sc4;

	private JButton buyFood;
	private JButton buyEnergy;
	private JButton buyOre;
	private JButton buyMule;
	private JButton exit;
	private JButton outfitFood;
	private JButton outfitEnergy;
	private JButton outfitOre;
	private JButton sellFood;
	private JButton sellEnergy;
	private JButton sellOre;
	
	private JLabel foodLabel;
	private JLabel energyLabel;
	private JLabel oreLabel;

	public Town(Screen4 sc4) {

		this.players = Screen3.getPlayers();
		this.turn = Screen3.getTurn();
		this.sc4 = sc4;

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

		outfitFood = new JButton("Outfit to Food");
		outfitFood.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() instanceof JButton){
					Player player = turn.getPlayerTurn();
					outfitMule((JButton)e.getSource(), "Food");
				}
			}

		});

		outfitEnergy = new JButton("Outfit to Energy");

		outfitEnergy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() instanceof JButton){
					Player player = turn.getPlayerTurn();
					outfitMule((JButton)e.getSource(), "Energy");
				}
			}

		});
		outfitOre = new JButton("Outfit to Ore");

		outfitOre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() instanceof JButton){
					Player player = turn.getPlayerTurn();
					outfitMule((JButton)e.getSource(), "Ore");
				}
			}

		});
		exit = new JButton("Exit to Map");
		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { 

				if(e.getSource() instanceof JButton) {
					turn.getPlayerTurn().setMuleOutfitted(false);	// reset muleoutfitted back to false after exit
					stopTurnTimer();
					turn.endPlayerTurn();	// increment index for player order[]
					
					MuleGame.exitToMap();
				}
			}
		});

		townPanel.add(buyFood);
		townPanel.add(buyEnergy);
		townPanel.add(buyOre);
		townPanel.add(buyMule);
		townPanel.add(outfitFood);
		townPanel.add(outfitEnergy);
		townPanel.add(outfitOre);
		townPanel.add(exit);


		JButton store = new JButton("Store");
		townPanel.add(store);
		JButton assay = new JButton("Assay");
		townPanel.add(assay);

		JButton pub = new JButton("Pub");
		townPanel.add(pub);
		pub.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { 

				if(e.getSource() instanceof JButton) {

					gambleMoney();
					stopTurnTimer();
					turn.endPlayerTurn();	// increment index for player order[]
					MuleGame.exitToMap();
				}
			}
		});

		JButton landOffice = new JButton("Land Offices");
		townPanel.add(landOffice);
		
		
		
		buildStorePanel();
		
		
		
	}
	
	
	/** method for creating the store panel
	 * which displays the amount of resources currently owned by the player
	 * allows player to sell his resources
	 */
	
	public void buildStorePanel() {
		storePanel = new JPanel();
		storePanel.setBounds(MAPULX, MAPULY, 724, 404);
		storePanel.setBackground(Color.WHITE);
		storePanel.setLayout(new GridLayout(3,2));
		
		sellFood = new JButton("Sell");
		sellFood.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				if(e.getSource() instanceof JButton){
					turn.getPlayerTurn().sellResources(100, "Food");
					foodLabel.setText("                     " + "Food: " + turn.getPlayerTurn().getFood());
				}
			}
		});
		
		sellEnergy = new JButton("Sell");
		sellEnergy.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				if(e.getSource() instanceof JButton){
					turn.getPlayerTurn().sellResources(100, "Energy");
					energyLabel.setText("                     " + "Energy: " + turn.getPlayerTurn().getEnergy());
				}
			}
		});
		
		sellOre = new JButton("Sell");
		sellOre.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				if(e.getSource() instanceof JButton){
					turn.getPlayerTurn().sellResources(100, "Ore");
					oreLabel.setText("                     " + "Ore: " + turn.getPlayerTurn().getOre());
				}
			}
		});
		
		foodLabel = new JLabel("                     " + "Food: " + turn.getPlayerTurn().getFood());
		energyLabel = new JLabel("                     " + "Energy: " + turn.getPlayerTurn().getEnergy());
		oreLabel = new JLabel("                     " + "Ore: " + turn.getPlayerTurn().getOre());
		
		storePanel.add(foodLabel);
		storePanel.add(sellFood);
		storePanel.add(energyLabel);
		storePanel.add(sellEnergy);
		storePanel.add(oreLabel);
		storePanel.add(sellOre);
	}
	
	public JPanel getStorePanel() {
		return storePanel;
	}

	public void outfitMule(JButton but, String product){
		Player player = turn.getPlayerTurn();
		
		switch (product){
		case "Food":
			if(player.hasMule() == true && player.muleHasOutfitted() == false){
				System.out.println(player.getName() + " money: " + player.getMoney() + " foodMountFee: " + foodMountFee);

				if (player.getMoney() >= foodMountFee)
				{
					player.outfitting(foodMountFee);
					player.setMuleOutfitted(true);
					sc4.updateLabelStats();
					
				}
				else
					System.out.println("Not enough money");

				System.out.println(player.getName() + " money after: " + player.getMoney() + " Mule oufitted to food. ");

			}
			break;

		case "Energy":
			if(player.hasMule() == true && player.muleHasOutfitted() == false){
				System.out.println(player.getName() + " money: " + player.getMoney() + " energyMountFee: " + energyMountFee);

				if (player.getMoney() >= energyMountFee)
				{
					player.outfitting(energyMountFee);
					player.setMuleOutfitted(true);
					sc4.updateLabelStats();
					
				}
				else
					System.out.println("Not enough money");

				System.out.println(player.getName() + " money after: " + player.getMoney() + " Mule oufitted to energy. ");

			}
			break;

		case "Ore":
			if(player.hasMule() == true && player.muleHasOutfitted() == false){
				System.out.println(player.getName() + " money: " + player.getMoney() + " smithoreMountFee: " + smithoreMountFee);

				if (player.getMoney() >= smithoreMountFee)
				{
					player.outfitting(smithoreMountFee);
					player.setMuleOutfitted(true);
					sc4.updateLabelStats();
					
				}
				else
					System.out.println("Not enough money");

				System.out.println(player.getName() + " money after: " + player.getMoney() + " Mule oufitted to smithore. ");

			}
			break;	
		}
	}


public void buyProduct(JButton but, String product)
{


	switch (product)
	{
	case "Food":
		if (foodQuantity != 0)
		{
			Player player = turn.getPlayerTurn();
			System.out.println(player.getName() + " money: " + player.getMoney() + " foodPrice: " + foodPrice + " Food Quantity: " + player.getFood());

			if (player.getMoney() >= foodPrice)
			{
				player.purchase(foodPrice, "Food");
				foodQuantity--;
				but.setText("Buy Food (Stock: " + foodQuantity + ")");
				sc4.updateLabelStats();
			}
			else
				System.out.println("Not enough money");

			System.out.println(player.getName() + " money after: " + player.getMoney() + " Food Quantity: " + player.getFood());

		}
		break;
	case "Energy":
		if (energyQuantity != 0)
		{
			Player player = turn.getPlayerTurn();
			System.out.println(player.getName() + " money: " + player.getMoney() + " energyPrice: " + energyPrice + " Energy Quantity: " + player.getEnergy());

			if (player.getMoney() >= energyPrice)
			{
				player.purchase(energyPrice, "Energy");
				energyQuantity--;
				but.setText("Buy Energy (Stock: " + energyQuantity + ")");
				sc4.updateLabelStats();
			}
			else
				System.out.println("Not enough money");

			System.out.println(player.getName() + " money after: " + player.getMoney() + " Energy Quantity: " + player.getEnergy());

		}
		break;
	case "Ore":
		if (oreQuantity != 0)
		{
			Player player = turn.getPlayerTurn();
			System.out.println(player.getName() + " money: " + player.getMoney() + " orePrice: " + orePrice + " Ore Quantity: " + player.getOre());
			if (player.getMoney() >= orePrice)
			{
				player.purchase(orePrice, "Ore");
				oreQuantity--;
				but.setText("Buy Ore (Stock: " + oreQuantity + ")");
				sc4.updateLabelStats();
			}
			else
				System.out.println("Not enough money");

			System.out.println(player.getName() + " money after: " + player.getMoney() + " Ore Quantity: " + player.getOre());

		}
		break;
	case "Mule":
		if (muleQuantity != 0)
		{
			Player player = turn.getPlayerTurn();
			System.out.println(player.getName() + " money: " + player.getMoney() + " mulePrice: " + mulePrice);
			if (player.getMoney() >= mulePrice)
			{
				player.purchase(mulePrice, "Mule");
				muleQuantity--;
				but.setText("Buy Mule (Stock: " + muleQuantity + ")");
				sc4.updateLabelStats();
			}
			else
				System.out.println("Not enough money");

			System.out.println(player.getName() + " money after: " + player.getMoney());

		}
		break;

	}
}

public void gambleMoney()
{
	Player player = turn.getPlayerTurn();

	Random rand = new Random();
	int gamble = rand.nextInt(100) + 51; // From $50 - $150 can be won.
	System.out.println("Money won: " + gamble); // DEBUG purposes
	System.out.println("Money BEFORE gambling: " + player.getMoney()); // DEBUG purposes

	player.gambleMoneyWon(gamble);
	System.out.println("Money AFTER gambling: " + player.getMoney()); // DEBUG purposes
}

public void stopTurnTimer()
{
	sc4.stopTimer();
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