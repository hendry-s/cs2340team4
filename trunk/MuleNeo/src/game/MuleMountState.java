package game;

import gfx.Map;
import gfx.Tile;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MuleMountState extends BasicGameState {

	Map map;
	int[][] mapLayout;
	Tile tiles;
	
	Image m1Tile = null;
	Image m2Tile = null;
	Image m3Tile = null;
	Image plainTile = null;
	Image riverTile = null;
	Image townTile = null;
	
	final int TILE_WIDTH = 80;
	final int TILE_HEIGHT = 80;
	final int ROW = 5;
	final int COL = 9;
	
	int round;
	int turn;
	
	
	int playerPosX;
	int playerPosY;
	Input input;
	
	Circle circle;
	
	GameData data;
	Rectangle rect;
	

/* TextField is left out due to performance issues
	UnicodeFont font;
	TextField textField;
*/
	
	@Override
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		
		GameData.getInstance().justFromMuleMountState = true;
		
		map = new Map(GameData.getInstance().map);
		mapLayout = map.getMap();
		tiles = new Tile();
		
		m1Tile = tiles.getM1Tile();
		m2Tile = tiles.getM2Tile();
		m3Tile = tiles.getM3Tile();
		plainTile = tiles.getPlainTile();
		riverTile = tiles.getRiverTile();
		townTile = tiles.getTownTile();
		
		playerPosX = 360;
		playerPosY = 220;
		
		input = container.getInput();
		
		circle = new Circle(playerPosX, playerPosY, 3);
		
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
		 
		 if (GameData.getInstance().justFromTownState == true) {
			 playerPosX = 440;
			 playerPosY = 200;
		 }
		 GameData.getInstance().justFromTownState = false;
		 
			 
		// KeyListen
		if (input.isKeyDown(Input.KEY_LEFT)) {
			playerPosX -= delta/6;
		}
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			playerPosX += delta/6;
		}
		if (input.isKeyDown(Input.KEY_UP)) {
			playerPosY -= delta/6;
		}
		if (input.isKeyDown(Input.KEY_DOWN)) {
			playerPosY += delta/6;
		}
		
		// Collision Detection: Exiting Town
		if (playerPosX > 320 && playerPosX < 400
				&& playerPosY > 160 && playerPosY < 240) {
			
			GameData.getInstance().justFromMuleMountState = true;
			
			sbg.enterState(3);	// To TownState;
		}
	
		// Collision Detection: Map Boundary
		if (playerPosX <= 0) {
			playerPosX = 0;
		}
		if (playerPosX >= 719) {
			playerPosX = 719;
		}
		if (playerPosY <= 0) {
			playerPosY = 0;
		}
		if (playerPosY >= 399) {
			playerPosY = 399;
		}

/* TextField is left out due to performance issues
		// Game Message Update (in TextField)
		textField.setText("Helluva");
		textField.setFocus(true);
*/				
	}
	
	
	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {

		for (int i=0; i<ROW; i++) {
			for (int j=0; j<COL; j++) {
				if (mapLayout[i][j] == 0) {
					plainTile.draw(TILE_WIDTH*j, TILE_HEIGHT*i);
				} else if (mapLayout[i][j] == 1) {
					m1Tile.draw(TILE_WIDTH*j, TILE_HEIGHT*i);
				} else if (mapLayout[i][j] == 2) {
					m2Tile.draw(TILE_WIDTH*j, TILE_HEIGHT*i);
				} else if (mapLayout[i][j] == 3) {
					m3Tile.draw(TILE_WIDTH*j, TILE_HEIGHT*i);
				} else if (mapLayout[i][j] == 4) {
					riverTile.draw(TILE_WIDTH*j, TILE_HEIGHT*i);
				} else if (mapLayout[i][j] == 5) {
					townTile.draw(TILE_WIDTH*j, TILE_HEIGHT*i);
				}
			}
		}
		
		
		circle.setCenterX(playerPosX);
		circle.setCenterY(playerPosY);
		g.setColor(Color.red);
		g.draw(circle);
		
		
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

		
		for (int i=0; i<5; i++) {
			for (int j=0; j<9; j++) {
				int who = data.possessionLayout.getMapPossession()[i][j];
				if (who > 0) {
					if (who == 1) {
						g.setColor(data.player1.getColor());
					} else if (who == 2) {
						g.setColor(data.player2.getColor());
					} else if (who == 3) {
						g.setColor(data.player3.getColor());
					} else if (who == 4) {
						g.setColor(data.player4.getColor());
					}
				
					rect = new Rectangle((j*80), (i*80), 80f, 80f);
					g.draw(rect);
					
				}	
			}
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 4;
	}

}
