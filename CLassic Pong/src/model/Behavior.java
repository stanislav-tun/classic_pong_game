package model;

import java.util.ArrayList;

import model.observer.IObserver;
import model.observer.ISubject;

public abstract class Behavior implements Move, ISubject, Runnable {

	protected int y, dy;
	protected ArrayList<IObserver> observers;
	protected Thread thread;

	public Behavior() {

		y = Sizes.WINDOW_WIDHT / 2;
		dy = 0;
		observers = new ArrayList<IObserver>();
	}

	@Override
	public void move(int dy) {

		if (y <= 0) {
			y = 0;
		} else if (y >= Sizes.WINDOW_HEIGHT - Sizes.PLAYER_HEIGHT) {
			y = Sizes.WINDOW_HEIGHT - Sizes.PLAYER_HEIGHT;
		}

		y += dy;
	}

	@Override
	public void signUpObserver(IObserver o) {
		observers.add(o);

	}

	@Override
	public void deleteObserver(IObserver o) {
		observers.remove(o);

	}

	@Override
	public void notifyObserver() {
		for (IObserver o : observers) {
			o.updatePlayer(y);
		}

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	/* this method was created just for reduction of creating thread object
	 * in main class. Now no need to start each Thread object, just create new
	 * Player or another class extended from Behavior and call this method to 
	 * start thread */
	public void startThread() {
		thread = new Thread(this);
		thread.start();
	}

}
