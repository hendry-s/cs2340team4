package game;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import turn.Turn;
import entities.Player;
import gfx.Map;

public class Screen3 extends JPanel {
	
	public static boolean running = false;
	private Player p1;
	private Player p2;
	
	private Map map;
	
	public Screen3() {
		
		setBounds(0, 0, 767, 521);
		setBackground(Color.BLACK);
		setBorder(new LineBorder(new Color(0, 0, 0), 5));
		setLayout(null);
		setVisible(true);
		
		
	}

	public void render() {
		
		final Player[] players = {p1, p2};
		
		map = new Map(players);
		add(map.render());
//		add(p1.render());
	}
	
/*	public void paintComponent(Graphics g) {
		
		map.render(g);
	}
*/	
	public void setPlayers(Player p1, Player p2)
	{
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Player[] getPlayers()
	{
		return new Player[]{p1, p2};
	}
	
	
	
	
//    static final Dimension dim = new Dimension(Width,Height);
//	Map nm;
	
	
//	public static final int WIDTH = 767, HEIGHT = 521, SCALE=1;
//	public static boolean running = false;
//	public Thread gameThread;
//	private Turn t1; // to add up to t8
//	private int turnCount = 0;
	
//	private ImageManager im;
	
//	private static Player player1, player2;
	

/*	
	public void init() {
		ImageLoader loader = new ImageLoader();
		
		im = new ImageManager(ss);
		
		player = new Player(0,0,im);
		
		this.addKeyListener(new KeyManager());
	}
	
	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60D; // tick per second
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		
		while(running){
			long now = System.nanoTime();
			delta += (now-lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				delta--;
			}
			render();
		}
		stop();
	}

	
	private void tick() {
		// TODO Auto-generated method stub
		
	}
	
	
	private void render() {
		// TODO Auto-generated method stub
		
	}

	
	
	private void stop() {
		// TODO Auto-generated method stub
		
	}
	*/
	
	
}
