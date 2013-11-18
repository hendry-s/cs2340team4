package game;

import gfx.Town;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class TownState extends BasicGameState {

	int playerPosX;
	int playerPosY;
	Input input;
	Town town;
	Image townImage;

	Circle playerWithNoMule;
	String playerWithMule;
	
	int round;
	int turn;
	
	String alertMessage;
	
	GameData data;
	
	@Override
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		town = new Town();
		townImage = town.getTownImage();
		
		input = container.getInput();
		
		playerPosX = 300;
		playerPosY = 200;
		
		playerWithNoMule = new Circle(400,300,5);
		
		data = GameData.getInstance();
		
/* TextField is left out due to performance issues
		// font setups
		font = new UnicodeFont(new java.awt.Font("DejaVu Serif", java.awt.Font.PLAIN, 14));
        
        font.addAsciiGlyphs();
        font.addGlyphs(400,600);
        font.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
        font.loadGlyphs();
        
        // TextField Setup
        textField = new TextField(container, font, 20, 420, 600, 16);
*/
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		round = GameData.getInstance().round;
		turn = GameData.getInstance().turn;
		
		
		if (GameData.getInstance().justFromMuleMountState == true) {
			 playerPosX = 300;
			 playerPosY = 200;
		 }
		 GameData.getInstance().justFromMuleMountState = false;
		 
		
		
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
			sbg.enterState(4);	// MuleMountState;
		}
		
		// Store Recognition: EnergyMule
		if (playerPosX > 76 && playerPosX < 224
				&& playerPosY > 51 && playerPosY < 142) {
			
			if (turn == 1) {
				data.player1.whatKindOfMule = 1;
				data.player1.spend(data.store.getEnergyMuleCost());
			} else if (turn == 2) {
				data.player2.whatKindOfMule = 1;
				data.player2.spend(data.store.getEnergyMuleCost());
			} else if (turn == 3) {
				data.player3.whatKindOfMule = 1;
				data.player3.spend(data.store.getEnergyMuleCost());
			} else if (turn == 4) {
				data.player4.whatKindOfMule = 1;
				data.player4.spend(data.store.getEnergyMuleCost());
			}
			playerPosX = 300;
			playerPosY = 200;	// get back
		}
		
		// Store Recognition: FoodMule
		if (playerPosX > 285 && playerPosX < 433
				&& playerPosY > 51 && playerPosY < 148) {
			
			if (turn == 1) {
				data.player1.whatKindOfMule = 2;
				data.player1.spend(data.store.getFoodMuleCost());
			} else if (turn == 2) {
				data.player2.whatKindOfMule = 2;
				data.player2.spend(data.store.getFoodMuleCost());
			} else if (turn == 3) {
				data.player3.whatKindOfMule = 2;
				data.player3.spend(data.store.getFoodMuleCost());
			} else if (turn == 4) {
				data.player4.whatKindOfMule = 2;
				data.player4.spend(data.store.getFoodMuleCost());
			}
			playerPosX = 300;
			playerPosY = 200;	// get back
		}
		
		// Store Recognition: OreMule
		if (playerPosX > 495 && playerPosX < 646
				&& playerPosY > 51 && playerPosY < 148) {
			
			if (turn == 1) {
				data.player1.whatKindOfMule = 3;
				data.player1.spend(data.store.getOreMuleCost());
			} else if (turn == 2) {
				data.player2.whatKindOfMule = 3;
				data.player2.spend(data.store.getOreMuleCost());
			} else if (turn == 3) {
				data.player3.whatKindOfMule = 3;
				data.player3.spend(data.store.getOreMuleCost());
			} else if (turn == 4) {
				data.player4.whatKindOfMule = 3;
				data.player4.spend(data.store.getOreMuleCost());
			}
			playerPosX = 300;
			playerPosY = 200;	// get back
		}
		
		// Store Recognition: Pub
		if (playerPosX > 495 && playerPosX < 646
				&& playerPosY > 246 && playerPosY < 344) {
			
			if (data.round <= 12) {
				if (turn == 1) {
					data.player1.addMoney(50);
					data.turn = 2;
				} else if (turn == 2) {
					data.player2.addMoney(50);
					if (data.numOfPlayer == 2) {
						data.round++;
						data.turn = 1;
					} else {
						data.turn = 3;
					}
				} else if (turn == 3) {
					data.player3.addMoney(50);
					if (data.numOfPlayer == 3) {
						data.round++;
						data.turn = 1;
					} else {
						data.turn = 4;
					}
				} else if (turn == 4) {
					data.player4.addMoney(50);
					data.round++;
					data.turn = 1;
				}
				data.landSelectionDone = false;
				
				data.player1.whatKindOfMule = 0;
				data.player2.whatKindOfMule = 0;
				if (turn >= 3)
					data.player3.whatKindOfMule = 0;
				if (turn >= 4)
					data.player4.whatKindOfMule = 0;
				
				sbg.enterState(2);
			} else {
				sbg.enterState(999);
			}
			
			playerPosX = 300;
			playerPosY = 200;	// get back
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
		
		
		// Render a circle object for the player with no mule
		// otherwise, a String "E", "F", "S" is displayed
		if (turn == 1) {
			if (data.player1.whatKindOfMule == 0) {
				playerWithNoMule.setCenterX(playerPosX);
				playerWithNoMule.setCenterY(playerPosY);
				g.setColor(data.player1.getColor());
				g.draw(playerWithNoMule);
			} else if (data.player1.whatKindOfMule == 1) {
				playerWithMule = "E";
				g.setColor(data.player1.getColor());
				g.drawString(playerWithMule, playerPosX, playerPosY);
			} else if (data.player1.whatKindOfMule == 2) {
				playerWithMule = "F";
				g.setColor(data.player1.getColor());
				g.drawString(playerWithMule, playerPosX, playerPosY);
			} else if (data.player1.whatKindOfMule == 3) {
				playerWithMule = "S";
				g.setColor(data.player1.getColor());
				g.drawString(playerWithMule, playerPosX, playerPosY);
			}
		} else if (turn == 2) {
			if (data.player2.whatKindOfMule == 0) {
				playerWithNoMule.setCenterX(playerPosX);
				playerWithNoMule.setCenterY(playerPosY);
				g.setColor(data.player2.getColor());
				g.draw(playerWithNoMule);
			} else if (data.player2.whatKindOfMule == 1) {
				playerWithMule = "E";
				g.setColor(data.player2.getColor());
				g.drawString(playerWithMule, playerPosX, playerPosY);
			} else if (data.player2.whatKindOfMule == 2) {
				playerWithMule = "F";
				g.setColor(data.player2.getColor());
				g.drawString(playerWithMule, playerPosX, playerPosY);
			} else if (data.player2.whatKindOfMule == 3) {
				playerWithMule = "S";
				g.setColor(data.player2.getColor());
				g.drawString(playerWithMule, playerPosX, playerPosY);
			}
		} else if (turn == 3) {
			if (data.player3.whatKindOfMule == 0) {
				playerWithNoMule.setCenterX(playerPosX);
				playerWithNoMule.setCenterY(playerPosY);
				g.setColor(data.player3.getColor());
				g.draw(playerWithNoMule);
			} else if (data.player3.whatKindOfMule == 1) {
				playerWithMule = "E";
				g.setColor(data.player3.getColor());
				g.drawString(playerWithMule, playerPosX, playerPosY);
			} else if (data.player3.whatKindOfMule == 2) {
				playerWithMule = "F";
				g.setColor(data.player3.getColor());
				g.drawString(playerWithMule, playerPosX, playerPosY);
			} else if (data.player3.whatKindOfMule == 3) {
				playerWithMule = "S";
				g.setColor(data.player3.getColor());
				g.drawString(playerWithMule, playerPosX, playerPosY);
			}
		} else if (turn == 4) {
			if (data.player4.whatKindOfMule == 0) {
				playerWithNoMule.setCenterX(playerPosX);
				playerWithNoMule.setCenterY(playerPosY);
				g.setColor(data.player4.getColor());
				g.draw(playerWithNoMule);
			} else if (data.player4.whatKindOfMule == 1) {
				playerWithMule = "E";
				g.setColor(data.player4.getColor());
				g.drawString(playerWithMule, playerPosX, playerPosY);
			} else if (data.player4.whatKindOfMule == 2) {
				playerWithMule = "F";
				g.setColor(data.player4.getColor());
				g.drawString(playerWithMule, playerPosX, playerPosY);
			} else if (data.player4.whatKindOfMule == 3) {
				playerWithMule = "S";
				g.setColor(data.player4.getColor());
				g.drawString(playerWithMule, playerPosX, playerPosY);
			}
		}

		// Status Updater
		g.setColor(GameData.getInstance().player1.getColor());
		g.drawString(GameData.getInstance().player1.getName(), 20, 460);
		g.drawString(GameData.getInstance().player1.getRace(), 20, 480);
		g.drawString("$: "+GameData.getInstance().player1.getMoney(), 20, 500);
		g.drawString("E: "+GameData.getInstance().player1.getEnergy(), 20, 515);
		g.drawString("F: "+GameData.getInstance().player1.getFood(), 20, 530);
		g.drawString("S: "+GameData.getInstance().player1.getOre(), 20, 545);
		g.drawString("Score: " + GameData.getInstance().player1.getScore(), 20, 565);
		
		g.setColor(GameData.getInstance().player2.getColor());
		g.drawString(GameData.getInstance().player2.getName(), 180, 460);
		g.drawString(GameData.getInstance().player2.getRace(), 180, 480);
		g.drawString("$: "+GameData.getInstance().player2.getMoney(), 180, 500);
		g.drawString("E: "+GameData.getInstance().player2.getEnergy(), 180, 515);
		g.drawString("F: "+GameData.getInstance().player2.getFood(), 180, 530);
		g.drawString("S: "+GameData.getInstance().player2.getOre(), 180, 545);
		g.drawString("Score: " + GameData.getInstance().player2.getScore(), 180, 565);
		
		if (GameData.getInstance().numOfPlayer >= 3) {
			g.setColor(GameData.getInstance().player3.getColor());
			g.drawString(GameData.getInstance().player3.getName(), 340, 460);
			g.drawString(GameData.getInstance().player3.getRace(), 340, 480);
			g.drawString("$: "+GameData.getInstance().player3.getMoney(), 340, 500);
			g.drawString("E: "+GameData.getInstance().player3.getEnergy(), 340, 515);
			g.drawString("F: "+GameData.getInstance().player3.getFood(), 340, 530);
			g.drawString("S: "+GameData.getInstance().player3.getOre(), 340, 545);
			g.drawString("Score: " + GameData.getInstance().player3.getScore(), 340, 565);
		}
		if (GameData.getInstance().numOfPlayer == 4) {
			g.setColor(GameData.getInstance().player4.getColor());
			g.drawString(GameData.getInstance().player4.getName(), 500, 460);
			g.drawString(GameData.getInstance().player4.getRace(), 500, 480);
			g.drawString("$: "+GameData.getInstance().player4.getMoney(), 500, 500);
			g.drawString("E: "+GameData.getInstance().player4.getEnergy(), 500, 515);
			g.drawString("F: "+GameData.getInstance().player4.getFood(), 500, 530);
			g.drawString("S: "+GameData.getInstance().player4.getOre(), 500, 545);
			g.drawString("Score: " + GameData.getInstance().player4.getScore(), 500, 565);
		}
		g.setColor(Color.white);
		g.drawString("STORE", 660, 460);
		g.drawString("FOOD   : " + GameData.getInstance().store.getFoodNum(), 660, 480);
		g.drawString("ENERGY : " + GameData.getInstance().store.getEnergyNum(), 660, 500);
		g.drawString("ORE    : " + GameData.getInstance().store.getOreNum(), 660, 520);
		g.drawString("MULE   : " + GameData.getInstance().store.getMuleNum(), 660, 540);


		g.drawString("Round " + round, 725, 5);
		g.drawString("Turn  " + turn, 725, 25);
//		g.drawString(alertMessage, 20, 420);
	}



	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}
}
