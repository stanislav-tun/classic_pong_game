package observer;

import java.awt.event.KeyEvent;

public interface Observer {
	public void update();
	public void update(int y);
	public void update(int x,int y);
	public void update(KeyEvent key);
}
