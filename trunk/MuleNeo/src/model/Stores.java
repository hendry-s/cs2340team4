package model;

public class Stores {

	private int food;
	private int foodCost;
	private int energy;
	private int energyCost;
	private int ore;
	private int oreCost;
	private int mule;
	private int muleCost;


	public Stores() {
		food = 8;
		energy = 8;
		ore = 8;
		mule = 14;
		foodCost = 30;
		energyCost = 25;
		oreCost = 50;
		muleCost = 100;
	}

	// When the player is selling stuffs to the store
	public boolean buyFood(Player player, int quantity) {
		if (quantity > player.getFood()) {
			return false;
		} else {
			food += quantity;
			player.setFood(player.getFood() - quantity);
			player.setMoney(player.getMoney() + foodCost * quantity);
			return true;
		}
	}

	public boolean buyEnergy(Player player, int quantity) {
		if (quantity > player.getEnergy()) {
			return false;
		} else {
			energy += quantity;
			player.setEnergy(player.getEnergy() - quantity);
			player.setMoney(player.getMoney() + energyCost * quantity);
			return true;
		}
	}

	public boolean buyOre(Player player, int quantity) {
		if (quantity > player.getOre()) {
			return false;
		} else {
			ore += quantity;
			player.setOre(player.getOre() - quantity);
			player.setMoney(player.getMoney() + energyCost * quantity);
			return true;
		}
	}

	// when the player is buying from the shop,
	public boolean sellFood(Player player, int quantity) {
		if (player.getMoney() < quantity * foodCost || quantity > food) {
			return false;
		} else {
			food -= quantity;
			player.setFood(player.getFood() + quantity);
			player.setMoney(player.getMoney() - foodCost * quantity);
			return true;
		}
	}

	public boolean sellEnergy(Player player, int quantity) {
		if (player.getMoney() < quantity * energyCost || quantity > energy) {
			return false;
		} else {
			energy -= quantity;
			player.setEnergy(player.getEnergy() + quantity);
			player.setMoney(player.getMoney() - energyCost * quantity);
			return true;
		}
	}

	public boolean sellOre(Player player, int quantity) {
		if (player.getMoney() < quantity * oreCost || quantity > ore) {
			return false;
		} else {
			ore -= quantity;
			player.setOre(player.getOre() + quantity);
			player.setMoney(player.getMoney() - oreCost * quantity);
			return true;
		}
	}


	public int getFood() {
		return food;
	}

	public int getFoodCost() {
		return foodCost;
	}

	public void setFoodCost(int foodCost) {
		this.foodCost = foodCost;
	}

	public int getEnergy() {
		return energy;
	}

	public int getEnergyCost() {
		return energyCost;
	}

	public void setEnergyCost(int energyCost) {
		this.energyCost = energyCost;
	}

	public int getOre() {
		return ore;
	}

	public int getOreCost() {
		return oreCost;
	}

	public void setOreCost(int oreCost) {
		this.oreCost = oreCost;
	}

	public int getMule() {
		return mule;
	}

	public int getMuleCost() {
		return muleCost;
	}

	public void setMule(int mule) {
		this.mule = mule;
	}

	public void setMuleCost(int muleCost) {
		this.muleCost = muleCost;
	}


}
