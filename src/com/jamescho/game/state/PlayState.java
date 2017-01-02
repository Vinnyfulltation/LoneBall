package com.jamescho.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

import com.jamescho.game.main.GameMain;
import com.jamescho.game.main.Resources;
import com.jamescho.game.model.Paddle;
import com.jamescho.game.model.Ball;
 
public class PlayState extends State {
	private Paddle paddleLeft, paddleRight;
	private static final int PADDLE_WIDTH = 15;
	private static final int PADDLE_HEIGHT = 60;
	private int playerScore = 0;
	private Font scoreFont;
	private Ball ball;
	private static final int BALL_DIAMETER = 20;
	

	@Override
	public void init() {
		// TODO Auto-generated method stub
		paddleLeft = new Paddle(0, 195, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddleRight = new Paddle(785, 195, PADDLE_WIDTH, PADDLE_HEIGHT);
		scoreFont = new Font ("SansSerif", Font.BOLD, 25);
		ball = new Ball (300, 200, BALL_DIAMETER, BALL_DIAMETER);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		paddleLeft.update();
        paddleRight.update();	
        ball.update();
        
        if (ballCollides(paddleLeft)){
        	playerScore++;
        	ball.onCollideWith(paddleLeft);
        	Resources.hit.play();
        }
        else if(ballCollides(paddleRight)){
        	playerScore++;
        	ball.onCollideWith(paddleRight);
        	Resources.hit.play();
        	}
        else if (ball.isDead()){
        	playerScore -= 3;
        	ball.reset();
        }
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Resources.darkBlue);
		g.fillRect(0, 0, GameMain.GAME_WIDTH, GameMain.GAME_HEIGHT);
		g.setColor(Resources.darkRed);
		g.fillRect(GameMain.GAME_WIDTH / 2,0,GameMain.GAME_WIDTH / 2, GameMain.GAME_HEIGHT );
		//draw spectator line
		g.drawImage(Resources.line,(GameMain.GAME_WIDTH / 2) ,0,null);
		g.setColor(Color.WHITE);
		g.fillRect(paddleRight.getX(), paddleRight.getY(), paddleRight.getWidth(), paddleRight.getHeigth());
		g.fillRect(paddleLeft.getX(), paddleLeft.getY(), paddleLeft.getWidth(), paddleLeft.getHeigth());
		//draw UI
		g.setFont(scoreFont);
		g.drawString("" + playerScore, 350, 40);
		//draw ball
		g.fillRect(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
	}

	@Override
	public void onClick(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyPress(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP){
			paddleLeft.accelUp();
			paddleRight.accelDown();
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			paddleLeft.accelDown();
			paddleRight.accelUp();
		}
		
	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN){
			paddleLeft.stop();
            paddleRight.stop();
		}
	}
	
	public boolean ballCollides(Paddle p){
		return ball.getRect().intersects(p.getRect());
	}

}
