package com.jamescho.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.jamescho.game.main.Resources;

public class loadState extends State{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		Resources.load();
		System.out.println("Loading successfull!");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		setCurrentState(new MenuState()); //transition to menustate
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyPress(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
