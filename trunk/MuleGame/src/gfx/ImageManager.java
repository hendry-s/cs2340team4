package gfx;

import java.awt.image.BufferedImage;

public class ImageManager {

	private BufferedImage player;
	private BufferedImage plainTile;
	private BufferedImage m1Tile;
    private BufferedImage m2Tile;
    private BufferedImage m3Tile;
    private BufferedImage riverTile;
	private BufferedImage townTile;
	
	public ImageManager() {
		ImageLoader loader = new ImageLoader();
		
//		player = 
		plainTile = loader.load("/icon_plain.png");
		m1Tile = loader.load("/icon_mountain1.png");
		m2Tile = loader.load("/icon_mountain2.png");
		m3Tile = loader.load("/icon_mountain3.png");
		riverTile = loader.load("/icon_river.png");
		townTile = loader.load("/icon_town.png");
	}
	
	public BufferedImage getPlayerImage() {return player;}
	public BufferedImage getPlainTileImage() {return plainTile;}
	public BufferedImage getM1TileImage() {return m1Tile;}
	public BufferedImage getM2TileImage() {return m2Tile;}
	public BufferedImage getM3TileImage() {return m3Tile;}
	public BufferedImage getRiverTileImage() {return riverTile;}
	public BufferedImage getTownTileImage() { return townTile;}
}
