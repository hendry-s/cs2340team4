package gfx;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Tile {

	private Image tileSet = null;
	private SpriteSheet tiles = null;
	
	private Image m1Tile = null;
	private Image m2Tile = null;
	private Image m3Tile = null;
	private Image plainTile = null;
	private Image riverTile = null;
	private Image townTile = null;
	
	
	public Tile() throws SlickException {
		tileSet = new Image("/data/tileSprite.png");
		tiles = new SpriteSheet(tileSet, 80, 80);
		
		tiles.startUse();
		m1Tile = tiles.getSubImage(0,0);
		m2Tile = tiles.getSubImage(1,0);
		m3Tile = tiles.getSubImage(2,0);
		plainTile = tiles.getSubImage(3,0);
		riverTile = tiles.getSubImage(4,0);
		townTile = tiles.getSubImage(5,0);
		/*
		m1Tile = new Image("/data/tile/icon_mountain1.png");
		m2Tile = new Image("/data/tile/icon_mountain2.png");
		m3Tile = new Image("/data/tile/icon_mountain3.png");
		plainTile = new Image("/data/tile/icon_plain.png");
		riverTile = new Image("/data/tile/icon_river.png");
		townTile = new Image("/data/tile/town.png");
		*/
		tiles.endUse();
	}
	
	public Image getM1Tile() {
		return m1Tile;
	}
	public Image getM2Tile() {
		return m2Tile;
	}
	public Image getM3Tile() {
		return m3Tile;
	}
	public Image getPlainTile() {
		return plainTile;
	}
	public Image getRiverTile() {
		return riverTile;
	}
	public Image getTownTile() {
		return townTile;
	}
}
