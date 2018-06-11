package model;


import model.observer.IObserver;

public class Enemy extends Behavior implements IObserver {

	private boolean ballUp, ballLeft;
	private int ballX, ballY;
	public Enemy() {
		super();
	}

	@Override
	public void run() {

		for(;;) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			if (ballUp) {
				dy = 1;
				
				
			} else {
				dy = -1;
				
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
	public void update(boolean up, boolean left) {
		ballUp = up;
		ballLeft = left;
	}
	
	@Override
	public void updateBall(int x, int y) {
		// TODO Auto-generated method stub
		ballX = x;
		ballY = y;
	}

	@Override
	public void updateEnemy(int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updatePlayer(int y) {
		// TODO Auto-generated method stub
		
	}

}
