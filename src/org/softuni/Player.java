package org.softuni;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player extends Entity {

	int velY = 0;

	public Player(int x, int y) {
		super(x, y);
	}

	public void update() {
		if (velY <= 0) {
			y += 10 * velY;
			velY += 0 * Main.PLAYER_DECCELERATION;
		}
		if (y <= Main.SCREEN_HEIGHT) {
			if (velY >= 0 && velY < 10) {
				velY += Main.GRAVITY_ACCELERATION;
			} else {
				velY = 10;
			}

			y += velY;
		}

		if (y >= Main.GAME_FLOOR) {
			y = Main.GAME_FLOOR;
		}
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImg("playerMiddle.png"), x, y,
		getPlayerImg("playerMiddle.png").getWidth(null) / 2,
		getPlayerImg("playerMiddle.png").getHeight(null), null);
	}

	public void drawDeath(Graphics2D g2d) {
		g2d.drawString("Game over ! ", 100, 100);

	}

	public static Image getPlayerImg(String name) {
		ImageIcon ic = new ImageIcon(name);
		Image i = ic.getImage();
		return i;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE) {
			velY = -10;
		}
		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE) {
			velY = 0;
		}
	}
}
