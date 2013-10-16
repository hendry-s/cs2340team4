package turn;

import java.awt.Graphics;

public class Turn {

	LandGrant lg;
	Development dev;
	Production prod;
	Auction auc;
	Summary sum;

	public Turn() {
		lg = new LandGrant();
	}
}
