package game;

import gfx.Map;
import gfx.Tile;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class LandGrantState extends BasicGameState {

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
	
	
	@Override
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		
		GameData.getInstance().justFromLandGrantState = true;
		
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
	}

	

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		 round = GameData.getInstance().round;
		 round = GameData.getInstance().turn;
		 
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
			
			GameData.getInstance().justFromLandGrantState = true;
			
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
		return 2;
	}

}
