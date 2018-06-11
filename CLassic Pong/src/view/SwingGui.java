package view;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Sizes;
import model.observer.IObserver;

public class SwingGui extends JFrame implements IObserver {

	private JPanel panel;
	private JLabel ball, player, enemy;
	private Rectangle rectangleBall, rectangleEnemy, rectanglePlayer;
	public SwingGui() {
		setLayout(null);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, Sizes.WINDOW_WIDHT, Sizes.WINDOW_HEIGHT);
		panel.setBackground(Color.BLACK);

		ball = new JLabel();
		ball.setLayout(null);
		ball.setBounds(Sizes.WINDOW_HEIGHT / 2, Sizes.WINDOW_WIDHT / 2, Sizes.BALL_WIDTH, Sizes.BALL_WIDTH);
		ball.setOpaque(true);
		ball.setBackground(Color.WHITE);

		enemy = new JLabel();
		enemy.setLayout(null);
		enemy.setBounds(540, 150, Sizes.PLAYER_WIDTH, Sizes.PLAYER_HEIGHT);
		enemy.setOpaque(true);
		enemy.setBackground(Color.RED);

		player = new JLabel();
		player.setLayout(null);
		player.setBounds(20, 150, Sizes.PLAYER_WIDTH, Sizes.PLAYER_HEIGHT);
		player.setOpaque(true);
		player.setBackground(Color.CYAN);
		
		rectangleBall = new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
		rectangleEnemy = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
		rectanglePlayer = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
		
		init();
	}

	public void init() {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		panel.add(ball);
		panel.add(enemy);
		panel.add(player);
		add(panel);

		setSize(Sizes.WINDOW_WIDHT, Sizes.WINDOW_HEIGHT+30);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void update(boolean up, boolean left) {
		// TODO Auto-generated method stub
		// not in use in this class need to fix this logic error
	}

	@Override
	public void updateBall(int x, int y) {
		//sync toolkit helps to fix a bug with displaying and repainting swing elements
		//when they change position with method setBounds();
		Toolkit.getDefaultToolkit().sync();

		rectangleBall.y = y;
		rectangleBall.x = x;
		
		ball.setBounds(rectangleBall);
		ball.repaint();
	}

	@Override
	public void updateEnemy(int y) {
		
		Toolkit.getDefaultToolkit().sync();
		
		rectangleEnemy.y = y;
		
		enemy.setBounds(rectangleEnemy);
		enemy.repaint();
	}

	@Override
	public void updatePlayer(int y) {
		//Toolkit.getDefaultToolkit().sync();

		rectanglePlayer.y = y;
		
		player.setBounds(rectanglePlayer);
		player.repaint();
		
	}
}
