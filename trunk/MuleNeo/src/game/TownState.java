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
		
		playerPosX = 300;
		playerPosY = 200;
		
		circle = new Circle(400,300,5);
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		
		if (GameData.getInstance().justFromLandGrantState == true) {
			 playerPosX = 300;
			 playerPosY = 200;
		 }
		 GameData.getInstance().justFromLandGrantState = false;
		 
		
		
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
			
			GameData.getInstance().justFromTownState = true;
			sbg.enterState(2);	// LandGrantState;
		}
		
		
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		townImage.draw(0,0);
		
		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		
		g.drawString("" + playerPosX +", " + playerPosY, 500,500);
		g.drawString("" + mouseX + ", " + mouseY, 500, 550);
		
		circle.setCenterX(playerPosX);
		circle.setCenterY(playerPosY);
		g.setColor(Color.red);
		g.draw(circle);
		

		// Status Updater
		g.setColor(GameData.getInstance().player1.getColor());
		g.drawString(GameData.getInstance().player1.getName(), 20, 460);
		g.drawString(GameData.getInstance().player1.getRace(), 20, 480);
		g.drawString("$: "+GameData.getInstance().player1.getMoney(), 20, 500);
		g.drawString("E: "+GameData.getInstance().player1.getEnergy(), 20, 520);
		g.drawString("F: "+GameData.getInstance().player1.getFood(), 20, 540);
		g.drawString("S: "+GameData.getInstance().player1.getOre(), 20, 560);
		
		g.setColor(GameData.getInstance().player2.getColor());
		g.drawString(GameData.getInstance().player2.getName(), 180, 460);
		g.drawString(GameData.getInstance().player2.getRace(), 180, 480);
		g.drawString("$: "+GameData.getInstance().player2.getMoney(), 180, 500);
		g.drawString("E: "+GameData.getInstance().player2.getEnergy(), 180, 520);
		g.drawString("F: "+GameData.getInstance().player2.getFood(), 180, 540);
		g.drawString("S: "+GameData.getInstance().player2.getOre(), 180, 560);
		
		if (GameData.getInstance().numOfPlayer >= 3) {
			g.setColor(GameData.getInstance().player3.getColor());
			g.drawString(GameData.getInstance().player3.getName(), 340, 460);
			g.drawString(GameData.getInstance().player3.getRace(), 340, 480);
			g.drawString("$: "+GameData.getInstance().player3.getMoney(), 340, 500);
			g.drawString("E: "+GameData.getInstance().player3.getEnergy(), 340, 520);
			g.drawString("F: "+GameData.getInstance().player3.getFood(), 340, 540);
			g.drawString("S: "+GameData.getInstance().player3.getOre(), 340, 560);
		}
		if (GameData.getInstance().numOfPlayer == 4) {
			g.setColor(GameData.getInstance().player4.getColor());
			g.drawString(GameData.getInstance().player4.getName(), 500, 460);
			g.drawString(GameData.getInstance().player4.getRace(), 500, 480);
			g.drawString("$: "+GameData.getInstance().player4.getMoney(), 500, 500);
			g.drawString("E: "+GameData.getInstance().player4.getEnergy(), 500, 520);
			g.drawString("F: "+GameData.getInstance().player4.getFood(), 500, 540);
			g.drawString("S: "+GameData.getInstance().player4.getOre(), 500, 560);
		}
		g.setColor(Color.white);
		g.drawString("STORE", 660, 460);
		g.drawString("FOOD   : " + GameData.getInstance().store.getFoodNum(), 660, 480);
		g.drawString("ENERGY : " + GameData.getInstance().store.getEnergyNum(), 660, 500);
		g.drawString("ORE    : " + GameData.getInstance().store.getOreNum(), 660, 520);
		g.drawString("MULE   : " + GameData.getInstance().store.getMuleNum(), 660, 540);
		
		

	}



	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}
}
