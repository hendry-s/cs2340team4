package entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

import gfx.Map;
import gfx.Town;

public class Character implements KeyListener {
	protected int x;
	protected int y;
	protected Map map;
	protected Town town;

	protected ImageIcon icon;
	
	private boolean up=false, dn=false, lt=false, rt=false;
	private final int SPEED = 3;
	
	public Character() {}
	
	public void tick() {
		if(up) {y -= SPEED;}
		if(dn) {y += SPEED;}
		if(lt) {x -= SPEED;}
		if(rt) {x += SPEED;}
	}
	
	public void render(Graphics g) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {up=true;}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {dn=true;}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {lt=true;}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {rt=true;}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {up=false;}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {dn=false;}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {lt=false;}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {rt=false;}
		
	}
	
	public ImageIcon getCharacterIcon() {
		return icon;
	}
	
}
