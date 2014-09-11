package org.softuni;

import java.awt.EventQueue;
import javax.swing.JFrame;
import org.softuni.Board;

public class Application extends JFrame{

	public Application() {
		//init method called in the constructor
		initUI();
	}

	private void initUI() {
		add(new Board());
		setSize(600,1000);
		setResizable(false);
		setTitle("Flappy Nakov by Dark Blue Team");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set the location of the window - null = center of the screen
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run(){
				Application ex = new Application();
				ex.setVisible(true);
			}
		});
	}

}
