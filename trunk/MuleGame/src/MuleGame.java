import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MuleGame {

	private static JFrame frame;
	static Screen2 sc2;
	static MuleGamePanel mgp;
	
	public static void main(String[] args) {
		
		frame = new JFrame("Aim4C++ MULE GAME");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mgp = new MuleGamePanel();
		frame.add(mgp);
		
		mgp.getButton().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				mgp.setVisible(false);
				frame.remove(mgp);
				
				sc2 = new Screen2();
				frame.add(sc2);
			}
		});
		
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
		frame.setBounds(100, 100, 783, 559);
	}
}
