package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class SetupClass extends StateBasedGame {

	public SetupClass(String title) {
		super(title);
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		this.addState(new IntroStateOne());
		this.addState(new IntroStateTwo());
		this.addState(new IntroStateThree());
		this.addState(new LandGrantState());
		
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SetupClass("MULE"));
		
		app.setDisplayMode(800, 600, false);
		app.setAlwaysRender(true);
		app.setTargetFrameRate(60);
		
		app.start();
	}

	
}