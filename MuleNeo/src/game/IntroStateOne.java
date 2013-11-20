package game;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Image;

/**
 *  Class for the introductory state of the game
 *  Controls what the user will initially see when game is first started
 *  Creates objects for the images for the new, load and exit game screens
 *  
 *  @author Jin Sim
 *  @date November 15, 2013
 */
public class IntroStateOne extends BasicGameState {
	
	Image newGame = null;
	Image loadGame = null;
	Image exitGame = null;
	
	Input input;
	int posX;
	int posY;
	Rectangle rect;
	

	@Override
	/**
	 *  Method that initializes the images for the new, load and exit game screens
	 *  Collects input from the user
	 *  @param container The container to hold the game
	 *  @param sbg The state of the game
	 */
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		
		newGame = new Image("/data/menuIcons/newGame.png");
		loadGame = new Image("/data/menuIcons/loadGame.png");
		exitGame = new Image("/data/menuIcons/exitGame.png");
		
		input = container.getInput();
	}

	@Override
	/**
	 *  Method that updates the game depending on which button on the container
	 *  was pressed
	 *  @param container The container to hold the game
	 *  @param sbg The state of the game
	 *  @param delta The change in coordinates for updating the UI
	 */
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		
		posX = input.getMouseX();
		posY = input.getMouseY();
		
		// newGame button pressed
		if ((posX>300 && posX<500) && (posY>200 && posY<300)) {
			if (Mouse.isButtonDown(0)) {
				sbg.enterState(1);		// WE enter Intro State 2
			}
		}
		
		// loadGame button pressed
		if ((posX>300 && posX<500) && (posY>300 && posY<400)) {
			if (Mouse.isButtonDown(0)) {
				sbg.enterState(99);
			}
		}
		
		// exitGame button pressed
		if ((posX>300 && posX<500) && (posY>400 && posY<500)) {
			if (Mouse.isButtonDown(0)) {
				System.exit(0);
			}
		}
		
		
	}
	
	@Override
	/**
	 *  Method that renders the game onto the container
	 *  @param container The container to hold the game
	 *  @param sbg The state of the game
	 *  @param g The Graphics object to draw onto the container
	 */
	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		posX = input.getMouseX();
		posY = input.getMouseY();
		
		g.drawString("(x,y) " + posX + "  " + posY, 100, 300);
		
		g.drawString("Welcome to M.U.L.E.", 100, 100);
		newGame.draw(300,200);
		loadGame.draw(300,300);
		exitGame.draw(300,400);
		
		posX = Mouse.getX();
		posY = Mouse.getY();
		
		// newGame button hover
		if ((posX>300 && posX<500) && (posY>200 && posY<300)) {
			rect = new Rectangle(300f, 400f, 200f, 100f);
			g.draw(rect);
		}
		
		// loadGame button hover
		else if ((posX>300 && posX<500) && (posY>300 && posY<400)) {
			rect = new Rectangle(300f, 300f, 200f, 100f);
			g.draw(rect);
		}
		
		// exitGame button hover
		else if ((posX>300 && posX<500) && (posY>400 && posY<500)) {
			rect = new Rectangle(300f, 200f, 200f, 100f);
			g.draw(rect);
		}
		
		
		
		
	}



	@Override
	/**
	 *  Method that returns the ID of the intro state
	 *  @return The ID of the intro state
	 */
	public int getID() {
		return 0;
	}

}
