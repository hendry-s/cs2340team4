import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Screen1 extends JPanel {

	private JPanel panel1;
	private JPanel panel2;
	private JPanel colorPanel1;
	private JPanel colorPanel2;
	private JButton btnContinue;
	private Screen2 sc2;
	
	public Screen1() {

		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0), 5));
		setLayout(null);
		setVisible(true);
	
		panel1 = new JPanel();
		panel1.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel1.setBounds(0, 0, 777, 85);
		panel1.setBackground(Color.WHITE);
		add(panel1);
		panel1.setLayout(null);
		
		JLabel lblMule = new JLabel("MULE");
		lblMule.setBackground(Color.WHITE);
		lblMule.setHorizontalAlignment(SwingConstants.CENTER);
		lblMule.setBounds(271, 11, 247, 75);
		lblMule.setIcon(null);
		lblMule.setForeground(Color.GREEN);
		lblMule.setFont(new Font("Showcard Gothic", Font.BOLD, 70));
		panel1.add(lblMule);
		
		panel2 = new JPanel();
		panel2.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel2.setBounds(0, 80, 777, 451);
		panel2.setBackground(Color.WHITE);
		add(panel2);
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
		panel2.add(comboBox_0);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("");
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Beginner Map", "Standard Map", "Tournament Map"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(138, 272, 129, 20);
		panel2.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("");
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4"}));
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setBounds(348, 347, 40, 20);
		panel2.add(comboBox_2);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Screen1.class.getResource("/MULEIMAGE/resources/Mule.jpg")));
		label.setBounds(215, 11, 345, 308);
		panel2.add(label);
		
		btnContinue = new JButton("Continue");
		btnContinue.setBounds(435, 347, 89, 23);
		panel2.add(btnContinue);
	}	
	
	public JButton getButton() {
		
		return btnContinue;
	}
}