import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JColorChooser;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;


public class StartUpFrame extends JFrame {

	private JPanel contentPane;
	private JPanel screen2;
	private JPanel screen3;
	private JPanel panel;
	private JPanel panel2;
	private JPanel colorPanel;
	private JComboBox comboBox;
	private static StartUpFrame frame;
	private JButton btnSelectColor;
	private JButton startGame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new StartUpFrame();
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
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		
		panel2 = new JPanel();
		panel2.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel2.setBounds(0, 80, 767, 441);
		panel2.setBackground(Color.WHITE);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LEVEL");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(10, 195, 98, 38);
		panel2.add(lblNewLabel_1);
		
		JLabel lblSelectMap = new JLabel("MAP");
		lblSelectMap.setForeground(Color.BLUE);
		lblSelectMap.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblSelectMap.setBounds(10, 262, 70, 46);
		panel2.add(lblSelectMap);
		
		JLabel lblSelectNumberOf = new JLabel("NUMBER OF PLAYERS");
		lblSelectNumberOf.setForeground(Color.BLUE);
		lblSelectNumberOf.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblSelectNumberOf.setBounds(10, 329, 308, 62);
		panel2.add(lblSelectNumberOf);
		
		JComboBox comboBox_0 = new JComboBox();
		comboBox_0.setToolTipText("");
		comboBox_0.setModel(new DefaultComboBoxModel(new String[] {"Beginner", "Standard", "Tournament"}));
		comboBox_0.setSelectedIndex(0);
		comboBox_0.setBounds(118, 201, 138, 20);
		comboBox.addActionListener(comboBox_0);
		panel2.add(comboBox_0);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("");
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Beginner Map", "Standard Map", "Tournament Map"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(118, 272, 169, 20);
		comboBox.addActionListener(comboBox_1);
		panel2.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("");
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4"}));
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setBounds(328, 347, 60, 20);
		comboBox.addActionListener(comboBox_2);
		panel2.add(comboBox_2);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(StartUpFrame.class.getResource("/MULEIMAGE/resources/Mule.jpg")));
		label.setBounds(215, 11, 345, 308);
		panel2.add(label);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(415, 347, 89, 23);
		panel2.add(btnContinue);
		
		JLabel lblAimc = new JLabel("Aim4C++");
		lblAimc.setFont(new Font("Cambria", Font.BOLD, 14));
		lblAimc.setBounds(655, 398, 64, 20);
		panel2.add(lblAimc);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setBounds(0, 0, 767, 85);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMule = new JLabel("MULE");
		lblMule.setBackground(Color.WHITE);
		lblMule.setHorizontalAlignment(SwingConstants.CENTER);
		lblMule.setBounds(271, 11, 247, 75);
		lblMule.setIcon(null);
		lblMule.setForeground(Color.GREEN);
		lblMule.setFont(new Font("Showcard Gothic", Font.BOLD, 70));
		panel.add(lblMule);
		
		btnContinue.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	screen2 = new JPanel();
	    		screen2.setBounds(0, 0, 767, 521);
	    		screen2.setBackground(Color.WHITE);
	    		screen2.setBorder(new LineBorder(new Color(0, 0, 0), 5));
	    		contentPane.add(screen2);
	    		screen2.setLayout(null);
	    		
	    		JComboBox comboBox_3 = new JComboBox();
	    		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Human", "Flapper", "Bonzoid", "Ugaite", "Buzzite"}));
	    		comboBox_3.setBounds(290, 145, 109, 20);
	    		screen2.add(comboBox_3);
	    		
	    		JComboBox comboBox_4 = new JComboBox();
	    		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Player 1", "Player 2", "Player 3", "Player 4"}));
	    		comboBox_4.setBounds(290, 77, 109, 20);
	    		screen2.add(comboBox_4);
	    		
	    		colorPanel = new JPanel();
	    		colorPanel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
	    		colorPanel.setBounds(420, 209, 30, 30);
	    		colorPanel.setBackground(Color.WHITE);
	    		screen2.add(colorPanel);
	    		colorPanel.setLayout(null);
	    		
	    		btnSelectColor = new JButton("Select Color");
	    		btnSelectColor.setBounds(288, 213, 122, 23);
	    		screen2.add(btnSelectColor);
	    		
	    		btnSelectColor.addActionListener(new ActionListener() {
	    			
	    			public void actionPerformed(ActionEvent e) {
	    				
	    				JColorChooser clr = new JColorChooser();
	    				Color color = clr.showDialog(screen2, "Pick a Color", Color.black);
	    				
	    				 if (color != null) {
	    					 
	    				      colorPanel.setBackground(color);
	    				 }
	    			}
	    		});
	    		
	    		JLabel lblPlayerRace = new JLabel("PLAYER RACE");
	    		lblPlayerRace.setForeground(Color.BLUE);
	    		lblPlayerRace.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
	    		lblPlayerRace.setBounds(38, 137, 209, 38);
	    		screen2.add(lblPlayerRace);
	    		
	    		JLabel lblPlayer = new JLabel("PLAYER NAME");
	    		lblPlayer.setForeground(Color.BLUE);
	    		lblPlayer.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
	    		lblPlayer.setBounds(38, 68, 209, 38);
	    		screen2.add(lblPlayer);
	    		
	    		JLabel lblPlayerColor = new JLabel("PLAYER COLOR");
	    		lblPlayerColor.setForeground(Color.BLUE);
	    		lblPlayerColor.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
	    		lblPlayerColor.setBounds(38, 207, 222, 38);
	    		screen2.add(lblPlayerColor);
	    		
	    		startGame = new JButton("Start Game");
	    		startGame.setBounds(288, 295, 122, 23);
	    		screen2.add(startGame);	    		
	    		
	    		startGame.addActionListener(new ActionListener() {
	    			
	    			public void actionPerformed(ActionEvent e) {
	    				
	    				screen3 = new JPanel();
	    	    		screen3.setBounds(0, 0, 767, 521);
	    	    		screen3.setBackground(Color.WHITE);
	    	    		screen3.setBorder(new LineBorder(new Color(0, 0, 0), 5));
	    	    		contentPane.add(screen3);
	    	    		screen3.setLayout(null);
	    	    		
	    	    		frame.setContentPane(screen3);
	    	    		frame.invalidate();
	    	    		frame.validate();
	    			}
	    		});
	        	
	        	frame.setContentPane(screen2);
	        	frame.invalidate();
	        	frame.validate();
	        }
	    });
		
	}
}