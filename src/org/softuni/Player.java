package org.softuni;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player extends Entity {

	int velY = 0;

	public Player(int x, int y) {
		super(x, y);
	}

	// Player moving
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
		g2d.drawImage(getPlayerImg(Main.PLAYER_IMAGE_NAME), x, y,
				getPlayerImg(Main.PLAYER_IMAGE_NAME).getWidth(null) / 2,
				getPlayerImg(Main.PLAYER_IMAGE_NAME).getHeight(null), null);
//		g2d.setColor(Color.white);
//		g2d.draw(getBounds());
	}

	public void drawDeath(Graphics2D g2d) {
		g2d.drawString("Game over ! ", 100, 100);

	}

	public static Image getPlayerImg(String name) {
		ImageIcon ic = new ImageIcon(name);
		Image i = ic.getImage();
		return i;
	}

	// Key action
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
		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, getPlayerImg(Main.PLAYER_IMAGE_NAME).getWidth(
				null) / 2, getPlayerImg(Main.PLAYER_IMAGE_NAME).getHeight(null));
	}
}
