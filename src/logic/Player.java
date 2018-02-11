package logic;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import observer.Observer;
import observer.PlayerObserver;
import observer.Subject;

public class Player extends Thread implements Subject, PlayerObserver,Runnable {
	private ArrayList<Observer> observers;
	private int y;

	public Player() {
		observers = new ArrayList<Observer>();
		start();
	}

	public void moveUp() {
		y-=3;
		System.out.println("up "+y);
	}

	public void moveDown() {
		y+=3;
		System.out.println("down "+y);
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
			//оповещаем графику о изменении положения игрока
			notifyObserver();
			break;
		case KeyEvent.VK_DOWN:
			moveDown();
			notifyObserver();
			break;
		}

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
	}

}