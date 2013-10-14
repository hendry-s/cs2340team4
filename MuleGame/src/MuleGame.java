import javax.swing.JFrame;

public class MuleGame {

	public static void main(String[] args) {
		
		MuleGame game = new MuleGame();
		MuleGamePanel mgp =  new MuleGamePanel();
		
		JFrame frame = new JFrame("Aim4C++ MULE GAME");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mgp);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 783, 559);
				
	}
}
