package org.softuni;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Pipe extends Entity {
	Random r = new Random();
	private int pipeHeight;

	public Pipe(int x, int y) {
		super(x, y);
		pipeHeight = Main.MIN_PIPE_HEIGHT + r.nextInt(Main.MAX_PIPE_HEIGHT);
	}

	public void draw(Graphics g) {
		int pipeY = Main.GAME_FLOOR + Player.getPlayerImg("playerMiddle.png").getHeight(null)
				- pipeHeight;
		int hatUpY = pipeY - Main.HAT_HEIGHT;
		int hatDownY = hatUpY - Main.PIPE_SPACING - Main.HAT_HEIGHT;
		int pipeUpHeight = hatDownY;
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(getPipeImgs("hoodMiddle.png"), x, pipeY, Main.PIPE_WIDTH,
				pipeHeight, null);
		g2d.drawImage(getPipeImgs("hoodUp.png"), x - 12, hatUpY,
				Main.HAT_WIDTH, Main.HAT_HEIGHT, null);
		g2d.drawImage(getPipeImgs("hatdownd.png"), x - 12, hatDownY,
				Main.HAT_WIDTH, Main.HAT_HEIGHT, null);
		g2d.drawImage(getPipeImgs("hoodMiddle.png"), x, 0, Main.PIPE_WIDTH,
				pipeUpHeight, null);
	}

	public Image getPipeImgs(String name) {
		ImageIcon ic = new ImageIcon(name);
		Image i = ic.getImage();
		return i;
	}
	
	public void pipeMove(){
		if (x >= - Main.HAT_WIDTH) {
			x -= Main.PIPE_SPEED;
		} else {
			x = Main.SCREEN_WIDTH + 40;
			pipeHeight = Main.MIN_PIPE_HEIGHT + r.nextInt(Main.MAX_PIPE_HEIGHT);
		}

	}
	
	
}
