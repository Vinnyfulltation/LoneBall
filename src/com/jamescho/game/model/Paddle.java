package com.jamescho.game.model;

import java.awt.Rectangle;

import com.jamescho.game.main.GameMain;

public class Paddle {
	//keep variables and methods private is there are called by an other in the same class
	private int x, y, width, height, velY;
	private Rectangle rect;
	private final static int MOVE_SPEED_Y = 4;
	
	public Paddle(int x, int y, int width, int heigth){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = heigth;
		rect = new Rectangle(x,y,width,heigth);
		velY = 0; 
	}
	
	public void update(){
	    y += velY;
	    if(y < 0){
	    	y = 0;
	    }
	    else if(y + height > GameMain.GAME_HEIGHT ){
	    	y = GameMain.GAME_HEIGHT - height;
	    }
	    updateRect(); //updates rect every frame
	}
	
	private void updateRect(){
		rect.setBounds(x, y, width, height); // makes retangle bound
	}
	
	public void accelUp(){
		velY = -5;
		velY = -MOVE_SPEED_Y;
	}
	
	public void accelDown(){
		velY = 5;
		velY = MOVE_SPEED_Y;
	}
	
	public void stop(){
		velY = 0;
	}
	//set up getter methods so other classes can use them without modifying up code
	public int getY(){
		return y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeigth(){
		return height;
	}
	public Rectangle getRect(){
		return rect;
	}

}
