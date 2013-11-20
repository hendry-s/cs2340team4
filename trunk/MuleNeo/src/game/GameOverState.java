package game;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *  Class that represents the Game Over state of the game
 *  
 *  @author Jin Sim
 *	@date November 15, 2013
 */
public class GameOverState extends BasicGameState {

	@Override
	/**
	 *  Method that initializes the state
	 *  @param arg0 The argument for the container
	 *  @param arg1 The argument for the state
	 */
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 *  Method that renders the Game Over message via a String representation
	 *  @param arg0 The argument for the container
	 *  @param arg1 The argument for the state
	 *  @param g The Graphics object used to draw in the container
	 */
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		
		g.drawString("Game Over", 400, 400);
	}

	@Override
	/**
	 *  Method that updates the state of the game
	 *  @param arg0 The argument for the container
	 *  @param arg1 The argument for the state
	 *  @param arg2 A necessary argument for something
	 */
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 *  Method that returns the ID of the state
	 *  @return The ID of the Game Over state
	 */
	public int getID() {
		// TODO Auto-generated method stub
		return 999;
	}

}
