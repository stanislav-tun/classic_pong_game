package model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Behavior implements KeyListener {

	public Player() {
		super();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			dy = -1;
			move(dy);
		}
		if (key == KeyEvent.VK_DOWN) {
			dy = 1;
			move(dy);
		}
		notifyObserver();
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			dy = 0;
			
		}
		if (key == KeyEvent.VK_DOWN) {
			dy = 0;
		
		}	
	}
	

}
