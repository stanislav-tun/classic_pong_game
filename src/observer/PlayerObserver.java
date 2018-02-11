package observer;

import java.awt.event.KeyEvent;

public interface PlayerObserver extends Observer {
	/*
	 * /(non-Javadoc)
	 * @see observer.Observer#update()
	 * Здесь переопределяются методы суперинтерфеса
	 * чтобы они не переопределялись в классе player
	 * так как они там не нужны. 
	 */
	@Override
	default void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	default void update(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	default void update(int y) {
		// TODO Auto-generated method stub
		
	}
}
