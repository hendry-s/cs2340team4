import javax.swing.JFrame;

public class MuleGame {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Aim4C++ MULE GAME");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MuleGamePanel mgp = new MuleGamePanel();
		Screen2 sc2 = new Screen2();
		
		sc2.setVisible(false);
		
		frame.add(sc2);
		frame.add(mgp);
		
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
		frame.setBounds(100, 100, 783, 559);
	}
}