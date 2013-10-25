package game;
import java.awt.Color;

import entities.Player;
import gfx.Map;
import gfx.Town;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class Screen4 extends JPanel {
	
	private Player p1;
	private Player p2;
	private Town town;

	
	public Screen4() {
		
		setBounds(0, 0, 767, 521);
		setBackground(Color.BLACK);
		setBorder(new LineBorder(new Color(0, 0, 0), 5));
		setLayout(null);
		setVisible(true);
		
	}
	
	public void render() {
		
		town = new Town();
		add(town.getPanel());
	}

	public void setPlayers(Player player1, Player player2) {
		
		this.p1 = p1;
		this.p2 = p2;
	}
}
