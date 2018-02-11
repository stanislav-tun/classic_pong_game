package logic;

import gui.MyGui;

public class Main {
	private Player player, enemy, ball;
	private MyGui gui;

	public Main() {
		player = new Player();
		enemy = new Enemy();
		gui = new MyGui();
		ball = new Ball();

		player.addObserver(gui);
		ball.addObserver(gui);
		ball.addObserver(enemy);
		enemy.addObserver(gui);
		gui.addObserver(player);

	}

	public static void main(String[] args) {
		new Main();

	}

}
