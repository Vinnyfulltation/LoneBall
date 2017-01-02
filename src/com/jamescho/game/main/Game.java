package com.jamescho.game.main;

import com.jamescho.game.state.State;
import com.jamescho.game.state.loadState;
import com.jamescho.framework.util.InputHandler;

import javax.swing.JPanel; //imports JPanel class
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

@SuppressWarnings("serial")//Serialization

public class Game extends JPanel implements Runnable{
	
	private volatile State currentState; //variable tracks the game its current state
	private int GameWidth;
	private int GameHeight;
	private Image GameImage;
	
	private Thread GameThread;
	private volatile boolean running;
	private InputHandler inputHandler;
	
	public Game(int GameWidth,int GameHeight){
		this.GameHeight = GameHeight;
		this.GameWidth = GameWidth;
		setPreferredSize(new Dimension(GameWidth,GameHeight));
		setBackground(Color.BLACK);
		setFocusable(true); // receive use input
		requestFocus();
	}
	
	public void setCurrentState(State newState){
		System.gc(); //cleans up unused objects for space(gc stands for garbage collector)
		newState.init();
		currentState = newState;
		inputHandler.setCurrentState(currentState);
	}
	
	@Override
	public void addNotify(){ // this gets called when game is added to main
		super.addNotify();
		initInput();
		setCurrentState(new loadState());
		initGame();
	}
	
	public void initGame(){
		running = true;
		GameThread = new Thread(this,"Game Thread");
		GameThread.start(); // performs the run method
	}

	@Override
	public void run() { //runnable object is needed to run the thread
		// TODO Auto-generated method stub
		System.out.println("Run successfull!");
		while(running){
			currentState.update();
			prepareGameImage();
			currentState.render(GameImage.getGraphics());
			repaint(); //request for the program to call the paintComponent()
			
			try{
				Thread.sleep(14);// gives time for 14 milliseconds to perform other task
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		//Ends game when running becomes false
		System.exit(0);
	}
	
	private void prepareGameImage(){
		if (GameImage == null){
			GameImage = createImage(GameWidth,GameHeight);
		}
		Graphics g = GameImage.getGraphics();
		g.clearRect(0,0, GameWidth,GameHeight);
	}
	
	public void exit(){
		running = false;
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		if(GameImage == null){
			return;
		}
		g.drawImage(GameImage, 0, 0, null); // null is an ImageObserver object to determine if an image is loaded
	}
	
	private void initInput(){
		inputHandler = new InputHandler();
		addKeyListener (inputHandler);
		addMouseListener(inputHandler);
		
	}
    
}
