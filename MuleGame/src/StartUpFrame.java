import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;


public class StartUpFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtMule;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartUpFrame frame = new StartUpFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartUpFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		contentPane.add(panel, BorderLayout.CENTER);
		
		txtMule = new JTextField();
		txtMule.setBackground(Color.GREEN);
		txtMule.setForeground(Color.BLUE);
		txtMule.setHorizontalAlignment(SwingConstants.CENTER);
		txtMule.setFont(new Font("Showcard Gothic", Font.BOLD, 60));
		txtMule.setText("MULE");
		panel.add(txtMule);
		txtMule.setColumns(10);
	}

}
