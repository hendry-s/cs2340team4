package JunitTesting;
import static org.junit.Assert.*;
import model.Player;
import model.Store;

public class BrendanTest {
	static Player brendan;
	Store store;
	
	public static void createPlayer() throws Exception {
		
		brendan = new Player("Brendan", 2,2,2,2);
		
	}
	
	public void buyOre() {
		store = new Store();
		store.buyOre(brendan, 2);
		
		assertTrue("Money should be 1500 (1600-(50*2))", brendan.getMoney() == 1500);
		assertTrue("Ore quantity should be 2", brendan.getOre() == 2);
	}
}
