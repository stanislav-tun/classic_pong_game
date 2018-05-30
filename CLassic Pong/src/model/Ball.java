package model;

import model.observer.IObserver;

public class Ball extends Behavior implements Runnable{
	
	private int x, dx;
	private boolean left = false, up = false;
	
	public Ball() {
		super();
		
		x = Sizes.WINDOW_HEIGHT / 2;
		dx = 0;
	}

	public void move(int dy, int dx) {
		if (y < 0) {
			up = true;
		} else if (y >= Sizes.WINDOW_HEIGHT - Sizes.BALL_WIDTH) {
			up = false;
		}

		if (x <= 0) {
			left = true;
		} else if (x >= Sizes.WINDOW_WIDHT - Sizes.BALL_WIDTH) {
			left = false;
		}

		y += dy;
		x += dx;

	}

	public void printCoordinates() {
		System.out.println("X: " + x + " Y: " + y);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (;;) {
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (up) {
				dy = 1;
			} else {
				dy = -1;
			}
			if (left) {
				dx = 3;
			} else {
				dx = -3;
			}
			move(dy, dx);
			notifyObserver();
		}
	}

	@Override
	public void notifyObserver() {
		for (IObserver o : observers) {
			//notify gui
			o.updateBall(x, y);
			//notify enemy
			o.update(up);
		}
	}
	@Override
	public void startThread() {
		thread = new Thread(this);
		thread.start();
	}
	
	

}
