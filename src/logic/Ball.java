package logic;

import gui.MyGui;
import observer.Observer;

public class Ball extends Player {
	private int x;
	private boolean up, left = false;;

	public Ball() {
		super();
		x = 250;
		y = 150;
	}

	@Override
	public void moveUp() {
		if (y <= 0) {
			up = true;

		}
		y--;

	}

	@Override
	public void moveDown() {
		if (y >= MyGui.HEIGHT - 20) {
			up = false;

		}
		y++;

	}

	public void moveLeft() {
		if (x <= 0) {
			left = true;

		}
		x -= 2;

	}

	public void moveRight() {
		if (x > MyGui.WIDTH - 20) {
			left = false;
		}
		x += 2;

	}

	@Override
	public void run() {
		for (;;) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notifyObserver();

			if (up) {
				moveDown();
			} else {
				moveUp();
			}
			if (left) {
				moveRight();
			} else {
				moveLeft();
			}

		}

	}

	@Override
	public void notifyObserver() {
		for (Observer o : observers) {
			o.update(x, y);
		}
	}

}
