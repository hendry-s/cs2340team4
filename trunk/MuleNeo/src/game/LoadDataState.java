package game;

import gfx.Map;
import gfx.MapMuleMount;
import gfx.MapPossession;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Player;
import model.Store;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class LoadDataState extends BasicGameState {

	@Override
	/**
	 *  Method that intializes the load data state of the game
	 *  @param container The container to hold the game
	 *  @param sbg The state of the game
	 */
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		GameData data = GameData.getInstance();
	}

	@Override
	/**
	 *  Method that renders the state of the game
	 *  @param container The container to hold the game
	 *  @param sbg The state of the game
	 *  @param g The Graphics object to draw onto the container
	 */
	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 *  Method that updates the state of the game
	 *  Loads all necessary information from serialized files to load back onto the game
	 *  Collects all necessary instances and loads game state with ID 2 when everthing
	 *  is completed
	 *  
	 *  @param container The container to hold the game
	 *  @param sbg The state of the game
	 *  @param delta The amount to move the position of the mouse
	 */
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		// TODO Auto-generated method stub

		ObjectInputStream inGameData = null;
		ObjectInputStream inPlayer1 = null;
		ObjectInputStream inPlayer2 = null;
		ObjectInputStream inPlayer3 = null;
		ObjectInputStream inPlayer4 = null;
		ObjectInputStream inStore = null;
		ObjectInputStream inMapLayout = null;
		ObjectInputStream inPossessionLayout = null;
		ObjectInputStream inMuleMountLayout = null;
		

		try {
			inGameData= new ObjectInputStream(new FileInputStream("savedGameData.ser"));
			inPlayer1 = new ObjectInputStream(new FileInputStream("savedPlayer1.ser"));
			inPlayer2 = new ObjectInputStream(new FileInputStream("savedPlayer2.ser"));
			inPlayer3 = new ObjectInputStream(new FileInputStream("savedPlayer3.ser"));
			inPlayer4 = new ObjectInputStream(new FileInputStream("savedPlayer4.ser"));
			inStore= new ObjectInputStream(new FileInputStream("savedStore.ser"));
			inMapLayout= new ObjectInputStream(new FileInputStream("savedMapLayout.ser"));
			inPossessionLayout= new ObjectInputStream(new FileInputStream("savedPossessionLayout.ser"));
			inMuleMountLayout= new ObjectInputStream(new FileInputStream("savedMuleMountLayout.ser"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			GameData recovGameData = (GameData)inGameData.readObject();
			Player recovPlayer1 = (Player)inPlayer1.readObject();
			Player recovPlayer2 = (Player)inPlayer2.readObject();
			Player recovPlayer3 = (Player)inPlayer3.readObject();
			Player recovPlayer4 = (Player)inPlayer4.readObject();
			Store recovStore = (Store)inStore.readObject();
			Map recovMapLayout = (Map)inMapLayout.readObject();
			MapPossession recovPossessionLayout = (MapPossession)inPossessionLayout.readObject();
			MapMuleMount recovMuleMountLayout = (MapMuleMount)inMuleMountLayout.readObject();
			
			GameData.getInstance().player1 = recovPlayer1;
			GameData.getInstance().player2 = recovPlayer2;
			GameData.getInstance().player3 = recovPlayer3;
			GameData.getInstance().player4 = recovPlayer4;
			GameData.getInstance().store = recovStore;
			GameData.getInstance().mapLayout = recovMapLayout;
			GameData.getInstance().possessionLayout = recovPossessionLayout;
			GameData.getInstance().muleMountLayout = recovMuleMountLayout;
			
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		try {
			inGameData.close();
			inPlayer1.close();
			inPlayer2.close();
			inPlayer3.close();
			inPlayer4.close();
			inStore.close();
			inMapLayout.close();
			inPossessionLayout.close();
			inMuleMountLayout.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		GameData.getInstance().round += 1;
		GameData.getInstance().turn = 1;
		sbg.enterState(2);
		
	}

	@Override
	/**
	 *  Method that returns the ID of the load data state of the game
	 *  @return The ID of the load data state
	 */
	public int getID() {
		// TODO Auto-generated method stub
		return 99;
	}
}
