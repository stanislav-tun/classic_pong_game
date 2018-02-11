package logic;

import java.util.ArrayList;

import gui.MyGui;
import observer.Observer;
import observer.Subject;

public class Ball implements Runnable, Subject {
	private int x, y;
	private ArrayList<Observer> observers;
	private boolean up, left = false;;

	public Ball() {
		x = 250;
		y = 150;
		observers = new ArrayList<Observer>();

	}

	public void moveUp() {
		if (y <= 0) {
			up = true;

		}
		y--;

	}

	public void moveDown() {
		if (y >= MyGui.HEIGHT-20) {
			up = false;

		}
		y++;

	}

	public void moveLeft() {
		if (x <= 0) {
			left = true;

		}
		x--;

	}

	public void moveRight() {
		if (x > MyGui.WIDTH-20) {
			left = false;
		}
		x++;

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
	public void addObserver(Observer o) {
		observers.add(o);

	}

	@Override
	public void deleteObserver(Observer o) {
		observers.remove(o);

	}

	@Override
	public void notifyObserver() {
		for (Observer o : observers) {
			o.update(x, y);
		}
	}

}
