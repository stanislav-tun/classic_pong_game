package logic;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import gui.MyGui;
import observer.Observer;
import observer.PlayerObserver;
import observer.Subject;

public class Player extends Thread implements Subject, PlayerObserver {
	protected ArrayList<Observer> observers;
	protected int y;

	public Player() {
		observers = new ArrayList<Observer>();
		start();
	}

	public void moveUp() {
		if (y <= 0) {
			y = 0;
		} else {
			y -= 3;
		}

	}

	public void moveDown() {
		if (y >= MyGui.WIDTH - 60) {
			y = MyGui.WIDTH - 60;
		} else {
			y -= 3;
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
			o.update(y);
		}
	}

	@Override
	public void update(KeyEvent key) {
		// TODO
		switch (key.getKeyCode()) {
		case KeyEvent.VK_UP:
			moveUp();
			// оповещаем графику о изменении положения игрока
			notifyObserver();
			break;
		case KeyEvent.VK_DOWN:
			moveDown();
			notifyObserver();
			break;
		}

	}

}