package game;

import gfx.Town;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class TownState extends BasicGameState {

	int playerPosX;
	int playerPosY;
	Input input;
	Town town;
	Image townImage;

	Circle circle;
	
	
	@Override
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		town = new Town();
		townImage = town.getTownImage();
		
		input = container.getInput();
		
		playerPosX = 360;
		playerPosY = 200;
		
		circle = new Circle(400,300,5);
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
		
		// KeyListen
		if (input.isKeyDown(Input.KEY_LEFT)) {
			playerPosX -= delta/4;
		}
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			playerPosX += delta/4;
		}
		if (input.isKeyDown(Input.KEY_UP)) {
			playerPosY -= delta/4;
		}
		if (input.isKeyDown(Input.KEY_DOWN)) {
			playerPosY += delta/4;
		}
		
		// Collision Detection: Exiting Town
		if (playerPosX < 0 || playerPosX > 720
				|| playerPosY < 0 || playerPosY > 400) {
			
			sbg.enterState(3);	// LandGrantState;
		}
		
		
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		townImage.draw(0,0);
		
		circle.setCenterX(playerPosX);
		circle.setCenterY(playerPosY);
		g.setColor(Color.red);
		g.draw(circle);
		
		g.drawString(GameData.getInstance().playerName1, 500, 500);
	}



	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}
}
