package JunitTesting;
import static org.junit.Assert.*;
import model.Mule;
import model.MuleType;
import model.Player;
import model.Store;

import org.junit.BeforeClass;
import org.junit.Test;
import org.newdawn.slick.Color;


public class OmarTest
{
	static Player player;
	static Store store;
	
	@BeforeClass
	public static void instantiatePlayer()
	{
		player = new Player("Joe", 1, 2, 50, 50);
	}
	
	@Test
	public void storeBuyEnergy() {
		
		store = new Store();
		int amount = 1;

		assertTrue("Before purchasing energy, player amount == 4", player.getEnergy() == 4);
		assertTrue("Before purchasing energy, store amount == 17", store.getEnergyNum() == 16);
		
		store.buyEnergy(player, amount);
		
		assertTrue("After purchasing energy, player amount == 3", player.getEnergy() == 3);
		assertTrue("After purchasing energy, store amount == 17", store.getEnergyNum() == 17);
		
		amount = 4;
		
		assertFalse("Cannot purchase more energy than the player has", store.buyEnergy(player, amount));
		assertTrue("Thus, player amount should not change", player.getEnergy() == 3);
		assertTrue("Thus, store amount should not change", store.getEnergyNum() == 17);
	} 
}
