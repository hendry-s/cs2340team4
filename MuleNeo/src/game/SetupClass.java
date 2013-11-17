package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class SetupClass extends StateBasedGame {
	
	public SetupClass(String title) {
		super(title);
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		this.addState(new IntroStateOne());		// id: 0
		this.addState(new IntroStateTwo());		// id: 1
		this.addState(new LandGrantState());	// id: 2
		this.addState(new TownState());			// id: 3
		this.addState(new MuleMountState());	// id: 4
		this.addState(new ProductionState());	// id: 5
		this.addState(new SummaryState());		// id: 6
		this.addState(new SaveDataState());		// id: 98
		this.addState(new LoadDataState());		// id: 99
		
		
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SetupClass("MULE"));
		
		app.setDisplayMode(800, 600, false);
		app.setAlwaysRender(true);
		app.setTargetFrameRate(60);
		
		app.start();
	}
	
	public void enterState() {
		
	}

	
}