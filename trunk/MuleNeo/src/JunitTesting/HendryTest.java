package JunitTesting;
import static org.junit.Assert.*;
import model.Mule;
import model.MuleType;
import model.Player;

import org.junit.BeforeClass;
import org.junit.Test;
import org.newdawn.slick.Color;


public class HendryTest {

	static Player player1;
	static Player player2;
	Mule m;
	
	@BeforeClass
	public static void setBeforeClass() throws Exception{
		player1 = new Player("P1", 0, 0, 1, 1);
		player2 = new Player("p2", 1, 1, 1,1);
	}
	
	@Test
	public void createFoodMule(){
		m = new Mule(player1, MuleType.FOOD);
		assertTrue("Successfully create food mule", m.getMuleType() == MuleType.FOOD);
	}
	
	@Test
	public void createCrystiteMule(){
		m = new Mule(player1, MuleType.CRYSTITE);
		assertTrue("Successfully create cristite mule", m.getMuleType() == MuleType.CRYSTITE);
	}
	
	@Test
	public void createEnergyMule(){
		m = new Mule(player1, MuleType.ENERGY);
		assertTrue("Successfully create energy mule", m.getMuleType() == MuleType.ENERGY);
	}
	
	@Test
	public void createSmithoreMule(){
		m = new Mule(player1, MuleType.SMITHORE);
		assertTrue("Successfully create smithore mule", m.getMuleType() == MuleType.SMITHORE);
	}
	
	@Test
	public void testPlayerConfig(){
		assertTrue("Successfully set up player 1 property", player1.getName() == "P1");
		assertTrue("Successfully set up player 1 race", player1.getRace() == "Bonzoid");
		assertTrue("Successfully set up player 1 color", player1.getColor() == Color.red);
	}
	
	@Test
	public void testPlayer1Properties(){
		assertTrue("Successfully set up player 1 initial money", player1.getMoney() == 1000);
		assertTrue("Successfully set up player 1 initial food", player1.getFood() == 8);
		assertTrue("Successfully set up player 1 initial energy", player1.getEnergy() == 4);
	}
	
	@Test
	public void testPlayer2Config(){
		assertTrue("Successfully set up player 1 property", player2.getName() == "p2");
		assertTrue("Successfully set up player 1 race", player2.getRace() == "Buzzite");
		assertTrue("Successfully set up player 1 color", player2.getColor() == Color.blue);
	}
	
	@Test
	public void testPlayer2Properties(){
		assertTrue("Successfully set up player 2 initial money", player2.getMoney() == 1000);
		assertTrue("Successfully set up player 2 initial food", player2.getFood() == 8);
		assertTrue("Successfully set up player 2 initial energy", player2.getEnergy() == 4);
	}
	
}
