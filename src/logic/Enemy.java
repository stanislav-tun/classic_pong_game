package logic;

import observer.Observer;

public class Enemy extends Player {

	public Enemy() {
		super();
	}

	@Override
	public void update(int x, int y) {
		if (this.y != y) {
			if (this.y < y) {
				moveUp();
			} else {
				moveDown();
			}
		}
		notifyObserver();

	}

	@Override
	public void notifyObserver() {
		for (Observer o : observers) {
			o.updateEnemy(y);
		}
	}

}
