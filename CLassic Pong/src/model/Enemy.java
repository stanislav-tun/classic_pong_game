package model;


import model.observer.IObserver;

public class Enemy extends Behavior implements IObserver, Runnable {

	private boolean ballUp;
	
	public Enemy() {
		super();
	}

	@Override
	public void run() {

		for(;;) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			if (ballUp) {
				dy = -1;
				
			} else {
				dy = 1;
				
			}
			move(dy);
			notifyObserver();
			
		}
					
	}
	
	
	@Override
	public void notifyObserver() {
		for (IObserver o : observers) {
			o.updateEnemy(y);
		}
	}

	@Override
	public void update(boolean up) {
		ballUp = up;
	}
	
	@Override
	public void updateBall(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEnemy(int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updatePlayer(int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void startThread() {
		thread = new Thread(this);
		thread.start();
	}

}
