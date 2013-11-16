import static org.junit.Assert.*;

import java.awt.Color;

import entities.Player;
import entities.Mule;
import entities.Human;
import entities.Flapper;

import game.MuleGame;

import org.junit.BeforeClass;
import org.junit.Test;



public class HendryTest {

	static Player test_player1;
	static Player test_player2;

	Human h;
	Flapper f;
	Mule m;

	public static void setUp() throws Exception{
		test_player1 = new Player("Henry", Color.BLACK, "Human");
		test_player2 = new Player("Noob", Color.GREEN, "Flapper");
	}

	@Test
	public void HumanRace(){
		h = new Human("Hendry", Color.BLACK, "Human");
		assertTrue("Successfully create a human race", h.getRace() == "Human" );
	}

	@Test
	public void Player1Name(){
		h = new Human("Hendry", Color.BLACK, "Human");
		assertTrue("Successfully create a human race with name", h.getName() == "Hendry" );
	}

	@Test
	public void Player1Money(){
		h = new Human("Hendry", Color.BLACK, "Human");
		assertTrue("Successfully set up initial player's property", h.getMoney() == 600);
	}

	@Test
	public void Player1Energy(){
		h = new Human("Hendry", Color.BLACK, "Human");
		assertTrue("Successfully set up initial player's property", h.getEnergy() == 4);
	}

	@Test
	public void Player1Food(){
		h = new Human("Hendry", Color.BLACK, "Human");
		assertTrue("Successfully set up initial player's property", h.getFood() == 8);
	}

	@Test
	public void Player1Ore(){
		h = new Human("Hendry", Color.BLACK, "Human");
		assertTrue("Successfully set up initial player's property", h.getOre() == 0 );		
	}

	@Test 
	public void FlapperProperties(){
		f = new Flapper("Noob", Color.GREEN, "Flapper");
		assertTrue("Successfully create a Flapper race with name", f.getName() == "Noob" );
		assertTrue("Successfully create a human race", f.getRace() == "Flapper" );
		assertTrue("Successfully set up initial player's property", f.getMoney() == 1600);
		assertTrue("Successfully set up initial player's property", f.getEnergy() == 4);
		assertTrue("Successfully set up initial player's property", f.getFood() == 8);
		assertTrue("Successfully set up initial player's property", f.getOre() == 0 );
	}

	@Test
	public void Players1Mule(){
		h = new Human("Hendry", Color.BLACK, "Human");
		assertTrue("Initially player should not have a mule", h.hasMule() == false);
	}
	
	@Test
	public void Player1BuyFood() {
		h = new Human("Hendry", Color.BLACK, "Human");
		assertTrue("Player 1 initial money is 600 before purchase anything", h.getMoney() == 600);
		h.purchase(30, "Food");
		assertTrue("Player 1 Successfully puchase food", h.getFood() == 9);
		assertTrue("Player 1 money after buy food is now 570", h.getMoney() == 570);

	}
	
	@Test
	public void Player1BuyOre() {
		h = new Human("Hendry", Color.BLACK, "Human");
		h.purchase(50, "Ore");
		assertTrue("Player 1 Successfully puchase ore", h.getOre() == 1);
		assertTrue("Player 1 money after buy ore is now 550", h.getMoney() == 550);
	}
	
	@Test
	public void Players2Mule(){
		f = new Flapper("Noob", Color.GREEN, "Flapper");
		assertFalse("Initially player should not have a mule", f.hasMule() == true);
	}

	

}
