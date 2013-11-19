package JunitTesting;
import static org.junit.Assert.*;
import model.Player;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Store;


public class JinTest {
	static Player p;
	Store store;
	
	@BeforeClass
	public static void createPlayer() throws Exception {
		
		p = new Player("Player 1", 2, 2, 1, 1);
	}
	
	@Test
	public void storeSellFood() {
		
		store = new Store();
		store.sellFood(p, 1);
		assertTrue("Successfully sell food to player 1", p.getFood() == 9);
		assertTrue("Store food quantity is now 17", store.getFoodNum() == 15);
	}
	
	@Test
	public void storeSellEnergy() {
		
		store = new Store();
		store.sellEnergy(p, 1);
		assertTrue("Successfully sell energy to player 1", p.getEnergy() == 5);
		assertTrue("Store food quantity is now 17", store.getEnergyNum() == 15);
	}
	
}
