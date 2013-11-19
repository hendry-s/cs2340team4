package game;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;

import gfx.Map;
import gfx.Tile;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class ProductionState extends BasicGameState {

	Map map;
	int[][] mapLayout;
	Tile tiles;
	
	Image m1Tile = null;
	Image m2Tile = null;
	Image m3Tile = null;
	Image plainTile = null;
	Image riverTile = null;
	Image townTile = null;
	
	int round;
	int turn;
	
	GameData data;
	
	String alertMessage1;
	String alertMessage2;
	String alertMessage3;
	
	Rectangle rect;
	
	Input input;
	
	final int TILE_WIDTH = 80;
	final int TILE_HEIGHT = 80;
	final int ROW = 5;
	final int COL = 9;
	
	
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
		
		data = GameData.getInstance();	
		
		input = container.getInput();
		
		alertMessage3 = "";
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		
		// Production Updater
		if (data.productionUpdated == false) {
			for (int i=0; i<5; i++) {
				for (int j=0; j<9; j++) {
					int landType = data.mapLayout.getMap()[i][j];
					int whichMule = data.mapMuleMount[i][j];
					int who = data.mapPossession[i][j];
					
					if (whichMule == 1) {	// Energy type
						if (landType == 0) {	// if plain
							data.mapProduction[i][j] = 3;
							if (who == 1) {
								data.player1.energy += 3;
							} else if (who == 2) {
								data.player2.energy += 3;
							} else if (who == 3) {
								data.player3.energy += 3;
							} else if (who == 4) {
								data.player4.energy += 3;
							}
						} else if (landType == 1 || landType == 2 || landType == 3) {	// if mountains
							data.mapProduction[i][j] = 1;
							if (who == 1) {
								data.player1.energy += 1;
							} else if (who == 2) {
								data.player2.energy += 1;
							} else if (who == 3) {
								data.player3.energy += 1;
							} else if (who == 4) {
								data.player4.energy += 1;
							}
						} else if (landType == 4) {	// if river
							data.mapProduction[i][j] = 2;
							if (who == 1) {
								data.player1.energy += 2;
							} else if (who == 2) {
								data.player2.energy += 2;
							} else if (who == 3) {
								data.player3.energy += 2;
							} else if (who == 4) {
								data.player4.energy += 2;
							}
						}
					} else if (whichMule == 2) {	// Food type
						if (landType == 0) {	// if plain
							data.mapProduction[i][j] = 2;
							if (who == 1) {
								data.player1.food += 2;
							} else if (who == 2) {
								data.player2.food += 2;
							} else if (who == 3) {
								data.player3.food += 2;
							} else if (who == 4) {
								data.player4.food += 2;
							}
						} else if (landType == 1 || landType == 2 || landType == 3) {	// if mountains
							data.mapProduction[i][j] = 1;
							if (who == 1) {
								data.player1.food += 1;
							} else if (who == 2) {
								data.player2.food += 1;
							} else if (who == 3) {
								data.player3.food += 1;
							} else if (who == 4) {
								data.player4.food += 1;
							}
						} else if (landType == 4) {	// if river
							data.mapProduction[i][j] = 4;
							if (who == 1) {
								data.player1.food += 4;
							} else if (who == 2) {
								data.player2.food += 4;
							} else if (who == 3) {
								data.player3.food += 4;
							} else if (who == 4) {
								data.player4.food += 4;
							}
						}
					} else if (whichMule == 3) {	// Ore type
						if (landType == 0) {	// if plain
							data.mapProduction[i][j] = 1;
							if (who == 1) {
								data.player1.ore += 1;
							} else if (who == 2) {
								data.player2.ore += 1;
							} else if (who == 3) {
								data.player3.ore += 1;
							} else if (who == 4) {
								data.player4.ore += 1;
							}
						} else if (landType == 1) {
							data.mapProduction[i][j] = 2;
							if (who == 1) {
								data.player1.ore += 2;
							} else if (who == 2) {
								data.player2.ore += 2;
							} else if (who == 3) {
								data.player3.ore += 2;
							} else if (who == 4) {
								data.player4.ore += 2;
							}
						} else if (landType == 2) {
							data.mapProduction[i][j] = 3;
							if (who == 1) {
								data.player1.ore += 3;
							} else if (who == 2) {
								data.player2.ore += 3;
							} else if (who == 3) {
								data.player3.ore += 3;
							} else if (who == 4) {
								data.player4.ore += 3;
							}
						} else if (landType == 3) {
							data.mapProduction[i][j] = 4;
							if (who == 1) {
								data.player1.ore += 4;
							} else if (who == 2) {
								data.player2.ore += 4;
							} else if (who == 3) {
								data.player3.ore += 4;
							} else if (who == 4) {
								data.player4.ore += 4;
							}
						} else if (landType == 4) {
							data.mapProduction[i][j] = 0;
						}
					}
				}
			}
			data.productionUpdated = true;
		}
		
		
		// Random Events Update
		if (!data.unluckyUpdated) {
			data.updateUnluckyOne();
			data.unluckyUpdated = true;
			
			if (data.unluckyOne == 1) {
				if (data.unluckyEvent == 0) {
					data.player1.food += 3;
					data.player1.energy += 2;
				} else if (data.unluckyEvent == 1) {
					data.player1.ore += 2;
				} else if (data.unluckyEvent == 2) {
					data.player1.money += 300;
				} else if (data.unluckyEvent == 3) {
					data.player1.money += 100;
				} else if (data.unluckyEvent == 4) {
					data.player1.money -= 100;
				} else if (data.unluckyEvent == 5) {
					data.player1.food /= 2;
				} else {
					data.player1.money -= 300;
				}
			} else if (data.unluckyOne == 2) {
				if (data.unluckyEvent == 0) {
					data.player2.food += 3;
					data.player2.energy += 2;
				} else if (data.unluckyEvent == 1) {
					data.player2.ore += 2;
				} else if (data.unluckyEvent == 2) {
					data.player2.money += 300;
				} else if (data.unluckyEvent == 3) {
					data.player2.money += 100;
				} else if (data.unluckyEvent == 4) {
					data.player2.money -= 100;
				} else if (data.unluckyEvent == 5) {
					data.player2.food /= 2;
				} else {
					data.player2.money -= 300;
				}
			} else if (data.unluckyOne == 3) {
				if (data.unluckyEvent == 0) {
					data.player3.food += 3;
					data.player3.energy += 2;
				} else if (data.unluckyEvent == 1) {
					data.player3.ore += 2;
				} else if (data.unluckyEvent == 2) {
					data.player3.money += 300;
				} else if (data.unluckyEvent == 3) {
					data.player3.money += 100;
				} else if (data.unluckyEvent == 4) {
					data.player3.money -= 100;
				} else if (data.unluckyEvent == 5) {
					data.player3.food /= 2;
				} else {
					data.player3.money -= 300;
				}
			} else {
				if (data.unluckyEvent == 0) {
					data.player4.food += 3;
					data.player4.energy += 2;
				} else if (data.unluckyEvent == 1) {
					data.player4.ore += 2;
				} else if (data.unluckyEvent == 2) {
					data.player4.money += 300;
				} else if (data.unluckyEvent == 3) {
					data.player4.money += 100;
				} else if (data.unluckyEvent == 4) {
					data.player4.money -= 100;
				} else if (data.unluckyEvent == 5) {
					data.player4.food /= 2;
				} else {
					data.player4.money -= 300;
				}
			}
			
		}
		
		alertMessage1 = "Round " + data.round + " Summary (Click the Screen to PROCEED, Press \"s\" to SAVE. )";
		alertMessage2 = data.unluckyOneName + ", " + data.unluckyEventName;

	
		// To PROCEED
		if (input.isMousePressed(0)) {
			data.round++;
			data.turn = 1;
			data.unluckyUpdated = false;
			data.productionUpdated = false;
			sbg.enterState(2);
		}
		
		// Game SAVE
		if (input.isKeyPressed(Input.KEY_S)) {
			ObjectOutputStream outGameData = null;
			ObjectOutputStream outPlayer1 = null;
			ObjectOutputStream outPlayer2 = null;
			ObjectOutputStream outPlayer3 = null;
			ObjectOutputStream outPlayer4 = null;
			ObjectOutputStream outStore = null;
			ObjectOutputStream outMapLayout = null;
			ObjectOutputStream outPossessionLayout = null;
			ObjectOutputStream outMuleMountLayout = null;
			
			try {
				outGameData= new ObjectOutputStream(new FileOutputStream("savedGameData.ser"));
				outPlayer1 = new ObjectOutputStream(new FileOutputStream("savedPlayer1.ser"));
				outPlayer2 = new ObjectOutputStream(new FileOutputStream("savedPlayer2.ser"));
				outPlayer3 = new ObjectOutputStream(new FileOutputStream("savedPlayer3.ser"));
				outPlayer4 = new ObjectOutputStream(new FileOutputStream("savedPlayer4.ser"));
				outStore= new ObjectOutputStream(new FileOutputStream("savedStore.ser"));
				outMapLayout= new ObjectOutputStream(new FileOutputStream("savedMapLayout.ser"));
				outPossessionLayout= new ObjectOutputStream(new FileOutputStream("savedPossessionLayout.ser"));
				outMuleMountLayout= new ObjectOutputStream(new FileOutputStream("savedMuleMountLayout.ser"));
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				outGameData.writeObject(data);
				outPlayer1.writeObject(data.player1);
				outPlayer2.writeObject(data.player2);
				outPlayer3.writeObject(data.player3);
				outPlayer4.writeObject(data.player4);
				outStore.writeObject(data.store);
				outMapLayout.writeObject(data.mapLayout);
				outPossessionLayout.writeObject(data.possessionLayout);
				outMuleMountLayout.writeObject(data.muleMountLayout);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				outGameData.close();
				outPlayer1.close();
				outPlayer2.close();
				outPlayer3.close();
				outPlayer4.close();
				outStore.close();
				outMapLayout.close();
				outPossessionLayout.close();
				outMuleMountLayout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			alertMessage3 = "Saved";
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



		g.drawString(alertMessage1, 20, 415);
		g.drawString(alertMessage2, 20, 430);
		g.drawString(alertMessage3, 740, 20);
		
		
		// Tile Selection (territory) 
		
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
		
		// Mule Mount updater
		for (int i=0; i<5; i++) {
			for (int j=0; j<9; j++) {
				int whichMule = data.mapMuleMount[i][j];
				int who = data.mapPossession[i][j];
				
				if (whichMule > 0) {
					// first, get the color
					if (who == 1) {
						g.setColor(data.player1.getColor());
					} else if (who == 2) {
						g.setColor(data.player2.getColor());
					} else if (who == 3) {
						g.setColor(data.player3.getColor());
					} else if (who == 4) {
						g.setColor(data.player4.getColor());
					}
					
					// then, check the mule mount type and update
					if (whichMule == 1) {	// energy type
						g.drawString("[Energy]", j*80+5, i*80+60);
					} else if (whichMule == 2) {	// food type
						g.drawString("[Food]", j*80+5, i*80+60);
					} else if (whichMule == 3) {	// ore type
						g.drawString("[Ore]", j*80+5, i*80+60);
					}
				}
			}
		}
		
		// Production Updater
		for (int i=0; i<5; i++) {
			for (int j=0; j<9; j++) {
				int which = data.mapProduction[i][j];
				int who = data.mapPossession[i][j];
				
				if (which > 0) {
					// first, get the color
					if (who == 1) {
						g.setColor(data.player1.getColor());
					} else if (who == 2) {
						g.setColor(data.player2.getColor());
					} else if (who == 3) {
						g.setColor(data.player3.getColor());
					} else if (who == 4) {
						g.setColor(data.player4.getColor());
					}
					
					// then, check the mule mount type and update
					if (which == 1) {	// energy type
						g.drawString("1", j*80+30, i*80+30);
					} else if (which == 2) {	// food type
						g.drawString("2", j*80+30, i*80+30);
					} else if (which == 3) {	// ore type
						g.drawString("3", j*80+30, i*80+30);
					} else if (which == 4) {	// ore type
						g.drawString("4", j*80+30, i*80+30);
					}
				}
			}
		}


		
		
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 5;
	}

}
