package gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import observer.Observer;
import observer.Subject;

public class MyGui extends JFrame implements KeyListener, Subject, Observer {
	/**
	 * 
	 */
	
	private JPanel panel;
	private JLabel pl1, enemy, ball;
	private ArrayList<Observer> observers;
	public static final int WIDTH = 500, HEIGHT = 300;
	
	public MyGui() {

		observers = new ArrayList<Observer>();

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0,0,WIDTH,HEIGHT);

		pl1 = new JLabel();
		pl1.setOpaque(true);
		pl1.setBounds(0, 0, 20, 60);
		pl1.setBackground(Color.blue);

		enemy = new JLabel();
		enemy.setOpaque(true);
		enemy.setBounds(400, 0, 20, 60);
		enemy.setBackground(Color.red);

		ball = new JLabel();
		ball.setOpaque(true);
		ball.setBounds(250, 150, 20, 20);
		ball.setBackground(Color.black);

		init();

	}

	public void init() {
		panel.add(pl1);
		panel.add(enemy);
		panel.add(ball);

		add(panel);
		addKeyListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT+21);
		setVisible(true);

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// оповещаем о нажатии клавиши класс Player
		notifyObserver(arg0);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// notifyObserver(arg0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);

	}

	@Override
	public void deleteObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub

	}

	public void notifyObserver(KeyEvent key) {
		// TODO Auto-generated method stub
		for (Observer o : observers) {
			o.update(key);
		}

	}

	@Override
	public void update() {
		// TODO default update method

	}

	@Override
	public void update(int y) {
		// TODO update player coordinates
		pl1.setLocation(0, y);
		
	}

	@Override
	public void update(int x, int y) {
		// TODO update ball coordinates
		// System.out.println("x=" + x + " y=" + y);
		ball.setLocation(x, y);

	}

	@Override
	public void update(KeyEvent key) {
		// TODO this method don't need here

	}

}
