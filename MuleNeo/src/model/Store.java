package model;

import game.GameData;

public class Store {

	private int foodNum;
	private int energyNum;
	private int oreNum;
//	private int crystiteNum;
	private int muleNum;
	
	private int foodCost;
	private int energyCost;
	private int oreCost;
//	private int crystiteCost;
	
	private int muleCost;
	private int energyMuleOutfitCost;
	private int foodMuleOutfitCost;
	private int oreMuleOutfitCost;

	public Store() {
		if (GameData.getInstance().level == 0) {
			foodNum = 16;
			energyNum = 16;
			oreNum = 0;
			muleNum = 25;
		} else {
			foodNum = 8;
			energyNum = 8;
			oreNum = 8;
			muleNum = 25;
		}
		foodCost = 30;
		energyCost = 25;
		oreCost = 50;
		muleCost = 100;
		energyMuleOutfitCost = 50;
		foodMuleOutfitCost = 25;
		oreMuleOutfitCost = 75;
	}

	// When the player is selling stuffs to the store
	public boolean buyFood(Player player, int quantity) {
		if (quantity > player.getFood()) {
			return false;
		} else {
			foodNum += quantity;
			player.setFood(player.getFood() - quantity);
			player.setMoney(player.getMoney() + foodCost * quantity);
			return true;
		}
	}

	public boolean buyEnergy(Player player, int quantity) {
		if (quantity > player.getEnergy()) {
			return false;
		} else {
			energyNum += quantity;
			player.setEnergy(player.getEnergy() - quantity);
			player.setMoney(player.getMoney() + energyCost * quantity);
			return true;
		}
	}

	public boolean buyOre(Player player, int quantity) {
		if (quantity > player.getOre()) {
			return false;
		} else {
			oreNum += quantity;
			player.setOre(player.getOre() - quantity);
			player.setMoney(player.getMoney() + energyCost * quantity);
			return true;
		}
	}

	// when the player is buying from the shop,
	public boolean sellFood(Player player, int quantity) {
		if (player.getMoney() < quantity * foodCost || quantity > foodNum) {
			return false;
		} else {
			foodNum -= quantity;
			player.setFood(player.getFood() + quantity);
			player.setMoney(player.getMoney() - foodCost * quantity);
			return true;
		}
	}

	public boolean sellEnergy(Player player, int quantity) {
		if (player.getMoney() < quantity * energyCost || quantity > energyNum) {
			return false;
		} else {
			energyNum -= quantity;
			player.setEnergy(player.getEnergy() + quantity);
			player.setMoney(player.getMoney() - energyCost * quantity);
			return true;
		}
	}

	public boolean sellOre(Player player, int quantity) {
		if (player.getMoney() < quantity * oreCost || quantity > oreNum) {
			return false;
		} else {
			oreNum -= quantity;
			player.setOre(player.getOre() + quantity);
			player.setMoney(player.getMoney() - oreCost * quantity);
			return true;
		}
	}


	public int getFoodNum() {
		return foodNum;
	}

	public int getFoodCost() {
		return foodCost;
	}

	public void setFoodCost(int foodCost) {
		this.foodCost = foodCost;
	}

	public int getEnergyNum() {
		return energyNum;
	}

	public int getEnergyCost() {
		return energyCost;
	}

	public void setEnergyCost(int energyCost) {
		this.energyCost = energyCost;
	}

	public int getOreNum() {
		return oreNum;
	}

	public int getOreCost() {
		return oreCost;
	}

	public void setOreCost(int oreCost) {
		this.oreCost = oreCost;
	}

	public int getMuleNum() {
		return muleNum;
	}

	public int getEnergyMuleCost() {
		return muleCost + energyMuleOutfitCost;
	}
	
	public int getFoodMuleCost() {
		return muleCost + foodMuleOutfitCost;
	}
	
	public int getOreMuleCost() {
		return muleCost + oreMuleOutfitCost;
	}

	public void setMule(int muleNum) {
		this.muleNum = muleNum;
	}

	public void setMuleCost(int muleCost) {
		this.muleCost = muleCost;
	}


}
