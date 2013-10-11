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
    
	private static StartUpFrame frame;
	private JPanel contentPane;
	private JPanel screen2;
	private JPanel screen3;
	private JPanel panel;
	private JPanel panel2;
	private JPanel colorPanel1;
	private JPanel colorPanel2;
	private JComboBox comboBox;
	private JButton btnSelectColor1;
	private JButton btnSelectColor2;
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
		setResizable(false);
		setBounds(100, 100, 783, 559);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		
		panel2 = new JPanel();
		panel2.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel2.setBounds(0, 80, 777, 451);
		panel2.setBackground(Color.WHITE);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LEVEL");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(30, 195, 98, 38);
		panel2.add(lblNewLabel_1);
		
		JLabel lblSelectMap = new JLabel("MAP");
		lblSelectMap.setForeground(Color.BLUE);
		lblSelectMap.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblSelectMap.setBounds(30, 262, 70, 46);
		panel2.add(lblSelectMap);
		
		JLabel lblSelectNumberOf = new JLabel("NUMBER OF PLAYERS");
		lblSelectNumberOf.setForeground(Color.BLUE);
		lblSelectNumberOf.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblSelectNumberOf.setBounds(30, 329, 308, 62);
		panel2.add(lblSelectNumberOf);
		
		JComboBox comboBox_0 = new JComboBox();
		comboBox_0.setToolTipText("");
		comboBox_0.setModel(new DefaultComboBoxModel(new String[] {"Beginner", "Standard", "Tournament"}));
		comboBox_0.setSelectedIndex(0);
		comboBox_0.setBounds(138, 201, 98, 20);
		comboBox.addActionListener(comboBox_0);
		panel2.add(comboBox_0);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("");
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Beginner Map", "Standard Map", "Tournament Map"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(138, 272, 129, 20);
		comboBox.addActionListener(comboBox_1);
		panel2.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("");
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4"}));
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setBounds(348, 347, 40, 20);
		comboBox.addActionListener(comboBox_2);
		panel2.add(comboBox_2);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(StartUpFrame.class.getResource("/MULEIMAGE/resources/Mule.jpg")));
		label.setBounds(215, 11, 345, 308);
		panel2.add(label);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(435, 347, 89, 23);
		panel2.add(btnContinue);
		
		JLabel lblAimc = new JLabel("Aim4C++");
		lblAimc.setFont(new Font("Cambria", Font.BOLD, 14));
		lblAimc.setBounds(655, 398, 64, 20);
		panel2.add(lblAimc);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setBounds(0, 0, 777, 85);
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
	    		comboBox_3.setBounds(290, 214, 89, 20);
	    		screen2.add(comboBox_3);
	    		
	    		JComboBox comboBox_4 = new JComboBox();
	    		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Player 1", "Player 2"}));
	    		comboBox_4.setBounds(290, 77, 89, 20);
	    		screen2.add(comboBox_4);
	    		
	    		JComboBox comboBox_5 = new JComboBox();
	    		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Human", "Flapper", "Bonzoid", "Ugaite", "Buzzite"}));
	    		comboBox_5.setBounds(290, 283, 89, 20);
	    		screen2.add(comboBox_5);
	    		
	    		JComboBox comboBox_6 = new JComboBox();
	    		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Player 1", "Player 2"}));
	    		comboBox_6.setBounds(290, 145, 89, 20);
	    		screen2.add(comboBox_6);
	    		
	    		colorPanel1 = new JPanel();
	    		colorPanel1.setBorder(new LineBorder(new Color(0, 0, 0), 5));
	    		colorPanel1.setBounds(420, 347, 30, 30);
	    		colorPanel1.setBackground(Color.WHITE);
	    		screen2.add(colorPanel1);
	    		colorPanel1.setLayout(null);
	    		
	    		btnSelectColor1 = new JButton("Select Color");
	    		btnSelectColor1.setBounds(288, 352, 122, 23);
	    		screen2.add(btnSelectColor1);
	    		
	    		btnSelectColor1.addActionListener(new ActionListener() {
	    			
	    			public void actionPerformed(ActionEvent e) {
	    				
	    				JColorChooser clr = new JColorChooser();
	    				Color color = clr.showDialog(screen2, "Pick a Color", Color.black);
	    				
	    				 if (color != null) {
	    					 
	    				      colorPanel1.setBackground(color);
	    				 }
	    			}
	    		});
	    		
	    		colorPanel2 = new JPanel();
	    		colorPanel2.setBorder(new LineBorder(new Color(0, 0, 0), 5));
	    		colorPanel2.setBounds(420, 416, 30, 30);
	    		colorPanel2.setBackground(Color.WHITE);
	    		screen2.add(colorPanel2);
	    		colorPanel2.setLayout(null);
	    		
	    		btnSelectColor2 = new JButton("Select Color");
	    		btnSelectColor2.setBounds(288, 421, 122, 23);
	    		screen2.add(btnSelectColor2);
	    		
	    		btnSelectColor2.addActionListener(new ActionListener() {
	    			
	    			public void actionPerformed(ActionEvent e) {
	    				
	    				JColorChooser clr = new JColorChooser();
	    				Color color = clr.showDialog(screen2, "Pick a Color", Color.black);
	    				
	    				 if (color != null) {
	    					 
	    				      colorPanel2.setBackground(color);
	    				 }
	    			}
	    		});
	    		
	    		JLabel lblPlayerRace1 = new JLabel("PLAYER 1 RACE");
	    		lblPlayerRace1.setForeground(Color.BLUE);
	    		lblPlayerRace1.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
	    		lblPlayerRace1.setBounds(38, 206, 229, 38);
	    		screen2.add(lblPlayerRace1);
	    		
	    		JLabel lblPlayerRace2 = new JLabel("PLAYER 2 RACE");
	    		lblPlayerRace2.setForeground(Color.BLUE);
	    		lblPlayerRace2.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
	    		lblPlayerRace2.setBounds(38, 275, 229, 38);
	    		screen2.add(lblPlayerRace2);
	    		
	    		JLabel lblPlayer1 = new JLabel("PLAYER 1 NAME");
	    		lblPlayer1.setForeground(Color.BLUE);
	    		lblPlayer1.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
	    		lblPlayer1.setBounds(38, 68, 229, 38);
	    		screen2.add(lblPlayer1);
	    		
	    		JLabel lblPlayer2 = new JLabel("PLAYER 2 NAME");
	    		lblPlayer2.setForeground(Color.BLUE);
	    		lblPlayer2.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
	    		lblPlayer2.setBounds(38, 137, 229, 38);
	    		screen2.add(lblPlayer2);
	    		
	    		JLabel lblPlayer1Color = new JLabel("PLAYER 1 COLOR");
	    		lblPlayer1Color.setForeground(Color.BLUE);
	    		lblPlayer1Color.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
	    		lblPlayer1Color.setBounds(38, 344, 242, 38);
	    		screen2.add(lblPlayer1Color);
	    		
	    		JLabel lblPlayer2Color = new JLabel("PLAYER 2 COLOR");
	    		lblPlayer2Color.setForeground(Color.BLUE);
	    		lblPlayer2Color.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
	    		lblPlayer2Color.setBounds(38, 413, 242, 38);
	    		screen2.add(lblPlayer2Color);
	    		
	    		startGame = new JButton("Start Game");
	    		startGame.setBounds(550, 421, 122, 23);
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