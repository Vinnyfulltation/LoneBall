package com.jamescho.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.jamescho.game.main.GameMain;

public abstract class State {
	
	public abstract void init();
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
	public abstract void onClick(MouseEvent e);
	
	public abstract void onKeyPress(KeyEvent e);
	
	public abstract void onKeyRelease(KeyEvent e);
	
	public void setCurrentState(State newState){
		GameMain.sGame.setCurrentState(newState);
	}
	
	

}
/*The init() method will be called when a we transition into to a new game state. It is a great place
to initialize any game objects that will be used throughout the game state.

The update() method of the current state will be called by the game loop on every frame. We use
it to update every game object inside the game state.

The render() method of the current state will be called by the game loop on every frame. We use
it to render game images to the screen.

The onClick() method of the current state will be called when the player makes a mouse click. It
receives information regarding this mouse event as a parameter.

The onKeyPress() method of the current state will be called when the player presses a keyboard
button. It receives information regarding the key event, such as the identity of the key that was
pressed. We use this method to make changes to our game (such as moving the character).

The onKeyRelease() method of the current state will be called when the player releases a
keyboard button. It receives information regarding the key event, such as the identity of the key
was released. We use this method to make changes to our game (such as stopping a moving
character).*/