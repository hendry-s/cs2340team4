package game;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Image;

public class IntroStateOne extends BasicGameState {
	
	Image newGame = null;
	Image loadGame = null;
	Image exitGame = null;
	
	Input input;
	int posX;
	int posY;
	Rectangle rect;
	
	@Override
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		
		newGame = new Image("/data/menuIcons/newGame.png");
		loadGame = new Image("/data/menuIcons/loadGame.png");
		exitGame = new Image("/data/menuIcons/exitGame.png");
		
		input = container.getInput();
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		
		posX = input.getMouseX();
		posY = input.getMouseY();
		
		// newGame button pressed
		if ((posX>300 && posX<500) && (posY>200 && posY<300)) {
			if (Mouse.isButtonDown(0)) {
				sbg.enterState(1);
			}
		}
		
		// loadGame button pressed
		if ((posX>300 && posX<500) && (posY>300 && posY<400)) {
			if (Mouse.isButtonDown(0)) {
//				sbg.enterState(99);
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
	public int getID() {
		return 0;
	}

}
