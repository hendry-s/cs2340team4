package game;

import model.Player;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class IntroStateTwo extends BasicGameState {

	boolean levelSelected;
	boolean mapSelected;
	boolean numOfPlayerSelected;
	boolean playerInfoEntered;
	
	int level;			// 0: beginner,		1: intermediate, 2: tournament
	int map;			// 0: (default),	1: random
	int numOfPlayer;	// 2,3,4
	
	Input input;
	int posX;
	int posY;
	
	Player p1;
	Player p2;
	Player p3;
	Player P4;
	
	PlayerInfoFrame frame;
	
	@Override
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		// TODO Auto-generated method stub
		
		levelSelected = false;
		mapSelected = false;
		numOfPlayerSelected = false;
		playerInfoEntered = false;
		
		input = container.getInput();
		
		level = 0;
		map = 0;
		numOfPlayer = 2;
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawString("Choose Level: ", 100, 100);
		g.drawString("beginner", 250, 100);
		g.drawString("intermediate", 400, 100);
		g.drawString("tournament", 550, 100);
		
		if (levelSelected == true) {
			if (level == 0) {
				g.draw(new Rectangle(250f, 100f, 100f, 30f));
			} else if (level == 1) {
				g.draw(new Rectangle(400f, 100f, 110f, 30f));
			} else if (level == 2) {
				g.draw(new Rectangle(550f, 100f, 110f, 30f));
			}
			
			g.drawString("Choose Map: ", 100, 200);
			g.drawString("default", 250, 200);
			g.drawString("random", 400, 200);
			
			if (mapSelected == true) {
				if (map == 0) {
					g.draw(new Rectangle(250f, 200f, 100f, 30f));
				} else if (map == 1) {
					g.draw(new Rectangle(400f, 200f, 100f, 30f));
				}
				g.drawString("Number of Players: ", 100, 300);
				g.drawString("2", 300, 300);
				g.drawString("3", 350, 300);
				g.drawString("4", 400, 300);
				
				if (numOfPlayerSelected == true) {
					if (numOfPlayer == 2) {
						g.draw(new Rectangle(300f, 300f, 50f, 30f));
					} else if (numOfPlayer == 3) {
						g.draw(new Rectangle(350f, 300f, 50f, 30f));
					} else if (numOfPlayer == 4) {
						g.draw(new Rectangle(400f, 300f, 50f, 30f));
					}
					
					g.drawString("Click for Next: Player info", 500, 400);
				
					if (playerInfoEntered == true) {
						g.drawString("Click [Here] to Proceed...", 500, 500);
					}
				}
			}
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		
		posX = input.getMouseX();
		posY = input.getMouseY();
		
		if (levelSelected == false) {

			// level:beginner selected
			if ((posX>250 && posX<350) && (posY>100 && posY<130)) {
				if (Mouse.isButtonDown(0)) {
					levelSelected = true;
					level = 0;
				}
			}
			// level:intermediate selected
			if ((posX>400 && posX<500) && (posY>100 && posY<130)) {
				if (Mouse.isButtonDown(0)) {
					levelSelected = true;
					level = 1;
				}
			}
			// level:beginner selected
			if ((posX>550 && posX<650) && (posY>100 && posY<130)) {
				if (Mouse.isButtonDown(0)) {
					levelSelected = true;
					level = 2;
				}
			}
		}

		if (mapSelected == false) {
			
			// map:default selected
			if ((posX>250 && posX<350) && (posY>200 && posY<230)) {
				if (Mouse.isButtonDown(0)) {
					mapSelected = true;
					map = 0;
				}
			}
			// map:random selected
			if ((posX>400 && posX<500) && (posY>200 && posY<230)) {
				if (Mouse.isButtonDown(0)) {
					mapSelected = true;
					map = 1;
				}
			}			
		}
		
		if (numOfPlayerSelected == false) {
			
			// numOfPlayer:2 selected
			if ((posX>300 && posX<350) && (posY>300 && posY<330)) {
				if (Mouse.isButtonDown(0)) {
					numOfPlayerSelected = true;
					numOfPlayer = 2;
				}
			}
			// numOfPlayer:3 selected
			if ((posX>350 && posX<400) && (posY>300 && posY<330)) {
				if (Mouse.isButtonDown(0)) {
					numOfPlayerSelected = true;
					numOfPlayer = 3;
				}
			}	
			// numOfPlayer:4 selected
			if ((posX>400 && posX<450) && (posY>300 && posY<330)) {
				if (Mouse.isButtonDown(0)) {
					numOfPlayerSelected = true;
					numOfPlayer = 4;
				}
			}
		}
		
		if (levelSelected == true && mapSelected == true
				&& numOfPlayerSelected == true) {
			if ((posX>500 && posX<800) && (posY>400 && posY<500)) {
				if (Mouse.isButtonDown(0)) {
					GameData.getInstance().updateStateTwoInfo(this);
				//	sbg.enterState(2);
					frame = new PlayerInfoFrame();
					playerInfoEntered = true;
				}
			}
		}
		
		if (playerInfoEntered == true) {
			if ((posX>500 && posX<800) && (posY>500 && posY<600)) {
				if (Mouse.isButtonDown(0)) {
					sbg.enterState(3);
				}
			}
		}
			

	}

	@Override
	public int getID() {
		return 1;
	}

}
