package com.jamescho.game.main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.Color;

import javax.imageio.ImageIO;

public class Resources{
	
	public static BufferedImage welcome, iconimage, line; //create multiple variables
	public static AudioClip hit,bounce;
	public static Color darkBlue, darkRed;
		
	public static void load(){
		// initialize with the resources (file name of the picture)
		welcome = loadImage("welcome.png"); 
		iconimage = loadImage("iconimage.png"); 
		line = loadImage("line.png");
		hit = loadSound("hit.wav");
		bounce = loadSound("bounce.wav");
		darkBlue = new Color(25, 83, 105);//constructor accepts RGB
		darkRed = new Color(105, 13, 13);
		
	}
	
	public static AudioClip loadSound(String filename){
		URL fileURL = Resources.class.getResource("/resources/" + filename);
		return Applet.newAudioClip(fileURL);
	}
	
	public static BufferedImage loadImage(String filename){
		BufferedImage img = null;
		try{ 
			img = ImageIO.read(Resources.class.getResourceAsStream("/resources/" + filename));
			// if this method may fails catch will execute
		}
		catch(Exception e){
			System.out.println("Error while reading: " + filename);
			e.printStackTrace(); // tells what error occurred and where
		}
		return img;
	}

}
