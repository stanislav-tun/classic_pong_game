package model.observer;

public interface IObserver {
	public void updatePlayer(int y);
	public void updateBall(int x, int y);
	public void updateEnemy(int y);
	public void update(boolean up, boolean left);
	
}
