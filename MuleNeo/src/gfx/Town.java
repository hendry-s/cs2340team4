package gfx;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Town {

	private Image townImage = null;
	
	public Town() throws SlickException {
		townImage = new Image("/data/Town.png");
	}
	
	public Image getTownImage() {
		return townImage;
	}
	
}
