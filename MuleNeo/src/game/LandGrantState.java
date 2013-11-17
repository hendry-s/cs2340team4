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
		map = new Map(GameData.getInstance().map);
		mapLayout = map.getMap();
		tiles = new Tile();
		
		m1Tile = tiles.getM1Tile();
		m2Tile = tiles.getM2Tile();
		m3Tile = tiles.getM3Tile();
		plainTile = tiles.getPlainTile();
		riverTile = tiles.getRiverTile();
		townTile = tiles.getTownTile();
		
		playerPosX = 500;
		playerPosY = 500;
		
		input = container.getInput();
		
		circle = new Circle(playerPosX, playerPosY, 3);
	}

	

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		 round = GameData.getInstance().round;
		 round = GameData.getInstance().turn;
		 
	
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
		if (playerPosX > 320 || playerPosX < 400
				|| playerPosY > 160 || playerPosY < 240) {
			
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
		
		
		
		g.drawString(GameData.getInstance().player1.getName(), 400, 400);
		
	}


	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

}
