package game;
import gfx.Map;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MuleGame {

	private static JFrame frame;
	private static Screen1 sc1;
	private static Screen2 sc2;
	private static Screen3 sc3;
	private static Screen4 sc4;
	private static Map map;
	
	public static void main(String[] args) {
		
		frame = new JFrame("Aim4C++ MULE GAME");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		sc1 = new Screen1();
		sc2 = new Screen2();
		sc3 = new Screen3();
		sc4 = new Screen4();

		frame.add(sc1);
		
		sc1.getButton().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				sc1.setVisible(false);
				frame.remove(sc1);
				
				frame.add(sc2);
			}
		});
		
		/*sc2.getButton().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				sc2.setVisible(false);
				frame.remove(sc2);
				
				sc3.setPlayers(sc2.getPlayer1(), sc2.getPlayer2());
				sc3.render();
				frame.add(sc3);
			}
		});*/
		
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
		frame.setBounds(100, 100, 783, 559);
	}
	
	public static void screen3()
	{
		sc2.setVisible(false);
		frame.remove(sc2);
		
		sc3.setPlayers(sc2.getPlayer1(), sc2.getPlayer2());
		sc3.render();
		frame.add(sc3);
	}
	
	public static void townScreen()
	{
		sc3.setVisible(false);
		
		sc4.render();
		frame.add(sc4);
	}
	
	public static Screen3 getSC3()
	{
		return sc3;
	}
}
