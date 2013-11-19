package JunitTesting;
import static org.junit.Assert.*;
import model.Player;

import org.junit.BeforeClass;
import org.junit.Test;
import model.Store;


public class ParthkumarTest {

	static Player p1;
	Store s;
	
	@BeforeClass
	public static void createPlayer() throws Exception {
		
		p1 = new Player("Parth", 3, 3, 2, 2);
	}
	
	@Test
	public void storeBuyFood() {
		
		s = new Store();
		int quantity = 1;
		s.buyFood(p1, quantity);
		assertTrue("Successfully bought food from Parth", p1.getFood() == 7);
		assertTrue("Store food quantity is now 17", s.getFoodNum() == 17);
		assertFalse("Not able to buy food from Parth",  quantity > p1.getFood());
		assertFalse("Store food quantity is now 18", p1.getFood() == 18);
		
	}
}
