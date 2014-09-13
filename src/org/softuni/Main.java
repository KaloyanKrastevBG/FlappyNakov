package org.softuni;
import javax.swing.JFrame;

public class Main {

	// basic config
	public static final int GAME_FLOOR = 543; // sets the game floor
	public static final int SCREEN_WIDTH = 600;
	public static final int SCREEN_HEIGHT = 800;
	public static final int PLAYER_START_X = 150;
	public static final int PLAYER_START_Y = 300;
	public static final int GAME_SPEED = 15; // smaller - faster
	public static final int PLAYER_DECCELERATION = 1; // the jumping const
	public static final int GRAVITY_ACCELERATION = 1;
	public static final int MAX_PIPE_HEIGHT = 300;
	public static final int MIN_PIPE_HEIGHT = 10;
	public static final int PIPE_WIDTH = 29;
	public static final int HAT_HEIGHT = 50;
	public static final int HAT_WIDTH = 53;
	public static final int PIPE_SPACING = 150;
	public static final int PIPE_SPEED = 2;
	public static final int PIPE_DISTANCE = 235;
	public static final int GREEN_LINE_Y = Main.GAME_FLOOR + Player.getPlayerImg(
			"playerMiddle.png").getHeight(null) - 13;

	public static void main(String[] args) {
		JFrame frame = new JFrame("FlappyNakov");
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(new GameFrame());
		frame.setResizable(false);

	}

}
