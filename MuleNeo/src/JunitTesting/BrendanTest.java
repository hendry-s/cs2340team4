package JunitTesting;
import static org.junit.Assert.*;
import model.Player;
import model.Store;

public class BrendanTest {
	static Player brendan;
	static Store store;
	
	public static void createPlayer() throws Exception {
		
		brendan = new Player("Brendan", 2,2,2,2);
		
	}
	
	public static void createStore() throws Exception {
		store = new Store();
	}
	
	public void buyOre() {
		
		store.buyOre(brendan, 2);
		
		assertTrue("Money should be 1500 (1600-(50*2))", brendan.getMoney() == 1500);
		assertTrue("Ore quantity should be 2", brendan.getOre() == 2);
	}
	
	public void sellOre() {
		
		store.sellOre(brendan,  1); 
		
		assertFalse("Money should be 1500", brendan.getMoney() == 1500);
		assertFalse("Ore quantity should be 2", brendan.getOre() == 2);
		assertFalse("Ore price should be 100", store.getOreCost() == 100);
	}
}
