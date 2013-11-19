package JunitTesting;
import static org.junit.Assert.*;
import model.Player;
import model.Store;

import org.junit.BeforeClass;
import org.junit.Test;

public class BrendanTest {
	static Player brendan;
	static Store store;
	
	@BeforeClass
	public static void createPlayer() throws Exception {
		
		brendan = new Player("Brendan", 2,2,2,2);
		
	}
	@BeforeClass
	public static void createStore() throws Exception {
		store = new Store();
	}
	
	@Test
	public void buyOre() {
		
		store.setOreCost(75);
		assertTrue("Money should be 1600", brendan.getMoney() == 1600);
		assertTrue("Ore quantity should be 0", brendan.getOre() == 0);
		assertTrue("Ore price should be 75", store.getOreCost() == 75);
	}
	
	@Test
	public void sellOre() {
		
		
		assertFalse("Money should be 1500", brendan.getMoney() == 1500);
		assertFalse("Ore quantity should be 2", brendan.getOre() == 2);
		assertFalse("Ore price should be 100", store.getOreCost() == 100);
	}
}
