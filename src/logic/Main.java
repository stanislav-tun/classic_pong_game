package logic;

import gui.MyGui;

public class Main {
	private Player player;
	private MyGui gui;
	private Ball ball;
	private Thread t;

	public Main() {

		player = new Player();
		
		gui = new MyGui();
		ball = new Ball();
		t = new Thread(ball);
		player.addObserver(gui);
		ball.addObserver(gui);
		gui.addObserver(player);
		t.start();
		
	}

	public static void main(String[] args) {
		new Main();

	}

}
