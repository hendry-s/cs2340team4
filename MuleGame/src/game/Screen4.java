package game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.Timer;

import entities.Player;
import gfx.Map;
import gfx.Town;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import turn.Turn;


public class Screen4 extends JPanel {
	
	private Player p1;
	private Player p2;
	private Town town;
	private Turn turn;
	
	private JLabel playerStats;
	private JLabel turnTime;
	private Timer timer;
	
	public Screen4() {
		
		setBounds(0, 0, 767, 521);
		setBackground(Color.BLACK);
		setBorder(new LineBorder(new Color(0, 0, 0), 5));
		setLayout(new BorderLayout());	// setLayout(null);
		setVisible(true);
		
		turn = Screen3.getTurn();
		Player player = turn.getPlayerTurn();
		
		playerStats = new JLabel(player.getName() + "'s turn-> Money: $" + player.getMoney() + " Energy: " + player.getEnergy() + " Food: " + player.getFood() + " Ore: " + player.getOre());
		playerStats.setForeground(player.getColor());
		playerStats.setFont(new Font("Showcard Gothic", Font.ITALIC, 18));
		add(playerStats, BorderLayout.NORTH);
		
		turnTime = new JLabel("Time: " + turn.getPlayerTurnTime() / 1000);
		turnTime.setForeground(Color.WHITE);
		add(turnTime, BorderLayout.WEST);
		
		timer = new Timer(1000, new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				//System.out.println("tick/tock");	// DEBUG purposes
				int timeLeft = turn.decrementPlayerTurnTime();
				updateTimeLabel(timeLeft);
				
				// End turn if time runs out.
				if (timeLeft == 0)
				{
					timer.stop();
					turn.endPlayerTurn();
					MuleGame.exitToMap();
				}
			}
		});
		
		timer.start();
		
		/**
		 * Component Listener
		 */
		addComponentListener(new ComponentListener() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				
				//System.out.println("componentShown Listener in Screen4"); // DEBUG purposes
				timer.start();
				updateLabelStats();
				updateTimeLabel(turn.getPlayerTurnTime());
			}
		});
		
	}
	
	public void render() {
		
		Player[] players = {p1, p2};
		town = new Town(this);
		add(town.getPanel(), BorderLayout.CENTER);
		add(town.getStorePanel(), BorderLayout.SOUTH);
		
	}
	
	public void updateLabelStats()
	{
		Player player = turn.getPlayerTurn();
		playerStats.setText(player.getName() + "'s turn-> Money: $" + player.getMoney() + " Energy: " + player.getEnergy() + " Food: " + player.getFood() + " Ore: " + player.getOre());
		playerStats.setForeground(player.getColor());
	}
	
	public void updateTimeLabel(int timeLeft)
	{
		turnTime.setText("Time: " + timeLeft / 1000);
	}

	public void stopTimer()
	{
		timer.stop();
	}
		
	public void setPlayers(Player player1, Player player2) {
		
		this.p1 = p1;
		this.p2 = p2;
	}
}
