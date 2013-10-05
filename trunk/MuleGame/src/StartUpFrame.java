import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JList;
import java.awt.List;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;


public class StartUpFrame extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;

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
		setTitle("Aim4C++ MULE GAME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 559);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 767, 85);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMule = new JLabel("MULE");
		lblMule.setBackground(Color.WHITE);
		lblMule.setHorizontalAlignment(SwingConstants.CENTER);
		lblMule.setBounds(267, 11, 247, 75);
		lblMule.setIcon(null);
		lblMule.setForeground(Color.GREEN);
		lblMule.setFont(new Font("Showcard Gothic", Font.BOLD, 70));
		panel.add(lblMule);
		
		JLabel lblNewLabel_1 = new JLabel("LEVEL");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(10, 361, 98, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblSelectMap = new JLabel("MAP");
		lblSelectMap.setForeground(Color.BLUE);
		lblSelectMap.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblSelectMap.setBounds(10, 410, 70, 46);
		contentPane.add(lblSelectMap);
		
		JLabel lblSelectNumberOf = new JLabel("NUMBER OF PLAYERS");
		lblSelectNumberOf.setForeground(Color.BLUE);
		lblSelectNumberOf.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblSelectNumberOf.setBounds(10, 459, 308, 62);
		contentPane.add(lblSelectNumberOf);
		
		String[] level = {"Beginner", "Standard", "Tournament"};
		
		comboBox = new JComboBox();
		comboBox.setLightWeightPopupEnabled(false);
		comboBox.setName("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Beginner", "Standard", "Tournament"}));
		comboBox.setSelectedIndex(0);
		comboBox.setToolTipText("");
		comboBox.setBounds(118, 367, 106, 20);
		comboBox.addActionListener(comboBox);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("");
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Beginner Map", "Standard Map", "Tournament Map"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(118, 419, 106, 20);
		comboBox.addActionListener(comboBox_1);
		contentPane.add(comboBox_1);
		
		String[] player = {"2", "3", "4"};
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("");
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4"}));
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setBounds(340, 477, 40, 20);
		comboBox.addActionListener(comboBox_2);
		contentPane.add(comboBox_2);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(StartUpFrame.class.getResource("/MULEIMAGE/resources/Mule.jpg")));
		label.setBounds(216, 96, 351, 303);
		contentPane.add(label);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(647, 476, 89, 23);
		contentPane.add(btnContinue);
	}
}
