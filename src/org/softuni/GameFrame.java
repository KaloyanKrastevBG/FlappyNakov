package org.softuni;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameFrame extends JPanel implements ActionListener {

	Player player;
	GreenLine greenLine;
	GreenLine secondGreenLine;
	Timer mainTimer;
	Pipe[] pipes = new Pipe[3];
	private boolean gameOver = false;

	// setting up the game frame
	public GameFrame() {
		setFocusable(true);
		requestFocus();
		player = new Player(Main.PLAYER_START_X, Main.PLAYER_START_Y);
		pipes[0] = (new Pipe(Main.SCREEN_WIDTH, 450));
		pipes[1] = (new Pipe(Main.SCREEN_WIDTH + Main.PIPE_DISTANCE, 450));
		pipes[2] = (new Pipe(Main.SCREEN_WIDTH + Main.PIPE_DISTANCE * 2, 450));
		greenLine = new GreenLine(0, Main.GREEN_LINE_Y);
		secondGreenLine = new GreenLine(GreenLine.getLineImg().getWidth(null),
				Main.GREEN_LINE_Y);
		addKeyListener(new KeyAdapt(player));
		mainTimer = new Timer(Main.GAME_SPEED, this);
		mainTimer.start();

	}

	// parameter of repaint()
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		ImageIcon ic = new ImageIcon(Main.BACKGROUND_IMAGE_NAME);
		g2d.drawImage(ic.getImage(), 0, 0, null);
		player.draw(g2d);
		for (Pipe pipe : pipes) {
			pipe.draw(g2d);
			pipe.pipeMove();
		}
		greenLine.draw(g2d);
		secondGreenLine.draw(g2d);
		greenLine.lineMove();
		secondGreenLine.lineMove();
		if(gameOver){
			gameOver(g2d);
		}
		
	}

	public void gameOver(Graphics2D g2d) {
		g2d.setColor(Color.white);
		//g2d.setFont(new Font("TimesRoman", Font.BOLD, 30)); 
		Font font = new Font("Arial", Font.BOLD, 50);
		g2d.setFont(font);
		g2d.drawString("Game over ! ", (Main.SCREEN_WIDTH/2)-150, 200);
	}

	@Override
	// Game movement
	public void actionPerformed(ActionEvent e) {
		player.update();
		checkCollision();
		repaint(); // repainting after every update
	}

	private void checkCollision() {
		for (Pipe pipe : pipes) {
			Rectangle[] enemyBoundaries = pipe.getEnemyBounds();
			for (Rectangle rectangle : enemyBoundaries) {
				if (player.getBounds().intersects(rectangle)
						/*|| player.y >= Main.GAME_FLOOR*/) {
					gameOver = true;
					mainTimer.stop();
				}
			}
		}
	}
}
