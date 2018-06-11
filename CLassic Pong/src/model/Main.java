package model;

import view.SwingGui;

public class Main {
	
	private Ball ball;
	private SwingGui gui;
	private Enemy enemy;
	private Player player;
	
	public Main() {
		
		player = new Player();
		enemy = new Enemy();
		ball = new Ball();
		gui = new SwingGui();
		gui.addKeyListener(player);
		
		ball.signUpObserver(gui);
		enemy.signUpObserver(gui);
		player.signUpObserver(gui);
		ball.signUpObserver(enemy);
		
		ball.startThread();
		enemy.startThread();
		//player.startThread();
	
	}

	public static void main(String[] args) {
		new Main();
	}

}
