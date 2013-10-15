import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class MuleGame {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Aim4C++ MULE GAME");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		CardLayout cardLayout = new CardLayout();
		MuleGamePanel mgp = new MuleGamePanel();
		Screen2 sc2 = new Screen2();
		
		contentPane.setLayout(cardLayout);
		contentPane.add(mgp);
		contentPane.add(sc2);
		
		
		
//		frame.getContentPane().add(mgp);
//		frame.getContentPane().remove(mgp);
//		frame.getContentPane().add(sc2);
//		frame.validate();
		
//		sc2.setVisible(false);
//		
//		frame.add(sc2);
//		frame.add(mgp);
//		
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
		frame.setBounds(100, 100, 783, 559);
		
		while (true) {
		    try {
		        Thread.sleep(1000);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    cardLayout.next(contentPane);
		}
	}
}
