package org.softuni;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameFrame extends JPanel implements ActionListener {

	Player player;
	Pipe pipe;
	Pipe secondPipe;
	Pipe thirdPipe;
	GreenLine greenLine;
	GreenLine secondGreenLine;

	public GameFrame() {
		Timer mainTimer;
		setFocusable(true);
		player = new Player(Main.PLAYER_START_X, Main.PLAYER_START_Y);
		pipe = new Pipe(Main.SCREEN_WIDTH, 450);
		secondPipe = new Pipe(Main.SCREEN_WIDTH + Main.PIPE_DISTANCE, 450);
		thirdPipe = new Pipe(Main.SCREEN_WIDTH + Main.PIPE_DISTANCE * 2, 450);
		greenLine = new GreenLine(0, Main.GREEN_LINE_Y);
		secondGreenLine = new GreenLine(GreenLine.getLineImg().getWidth(null), Main.GREEN_LINE_Y);
		addKeyListener(new KeyAdapt(player));
		mainTimer = new Timer(Main.GAME_SPEED, this);
		mainTimer.start();
	}

	// setting up the starting scene
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		ImageIcon ic = new ImageIcon("Background.png");
		g2d.drawImage(ic.getImage(), 0, 0, null);
		player.draw(g2d);
		pipe.draw(g2d);
		secondPipe.draw(g2d);
		thirdPipe.draw(g2d);
		greenLine.draw(g2d);
		secondGreenLine.draw(g2d);
	}

	public void gameOver(Graphics2D g2d) {
		g2d.drawString("Game over ! ", 100, 100);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		player.update(); // Game movement
		repaint();
		pipe.pipeMove();
		secondPipe.pipeMove();
		thirdPipe.pipeMove();
		greenLine.lineMove();
		secondGreenLine.lineMove();
	}
}
