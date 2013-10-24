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
	
	public static void main(String[] args) {
		
		frame = new JFrame("Aim4C++ MULE GAME");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		sc1 = new Screen1();
		sc2 = new Screen2();
		sc3 = new Screen3();

		frame.add(sc1);
		
		sc1.getButton().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				sc1.setVisible(false);
				frame.remove(sc1);
				
				frame.add(sc2);
			}
		});
		
		sc2.getButton().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				sc2.setVisible(false);
				frame.remove(sc2);
				
				sc3.render();
				sc3.setPlayers(sc2.getPlayer1(), sc2.getPlayer2());
				frame.add(sc3);
			}
		});
		
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
		frame.setBounds(100, 100, 783, 559);
	}
}
