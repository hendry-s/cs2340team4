package gfx;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import tiles.M1Tile;
import tiles.M2Tile;
import tiles.M3Tile;
import tiles.PlainTile;
import tiles.RiverTile;
import tiles.Tile;
import tiles.TownTile;

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
	
	public Town() {
	
		townPanel = new JPanel();
		townPanel.setBounds(MAPULX, MAPULY, 724, 404);
		townPanel.setBackground(Color.WHITE);
		townPanel.setLayout(null);
		
		JButton buyFood = new JButton("Buy Food (Stock: " + foodQuantity + ")");
		townPanel.add(buyFood);
		
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