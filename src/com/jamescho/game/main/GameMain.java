package com.jamescho.game.main; // imports package (grouped classes)

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GameMain {
	
	private static final String GAME_TITLE = "LoneBall "; // game title variable
	public static final int GAME_WIDTH = 800; // shows width
	public static final int GAME_HEIGHT = 450; // shows height
	public static Game sGame;
	
	public static void main(String[] args){ //main method
		JFrame frame = new JFrame(GAME_TITLE); //makes an object for the window and gives a name
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // terminates the program
		frame.setResizable(false); // can't resize the frame
		sGame = new Game(GAME_WIDTH,GAME_HEIGHT);
		frame.add(sGame);//another way of saying frame.add(BorderLayout.CENTER, sGame)
		frame.pack(); // resizes the frame
		frame.setVisible(true); // shows the visibility
		frame.setIconImage(Resources.iconimage); //sets the icon image for launch
		
	}
}
