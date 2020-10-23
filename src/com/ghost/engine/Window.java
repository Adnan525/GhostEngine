package com.ghost.engine;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Window 
{
	public JFrame frame;
	public BufferedImage image; //top left is 0,0
	public Canvas canvas;
	public BufferStrategy strategy;
	public Graphics graphics;
	
	
	public Window(Basics bas)
	{
		image = new BufferedImage(bas.getWidth(), bas.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		canvas = new Canvas();
		Dimension canvasSize = new Dimension((int)(bas.getWidth()*bas.getScale()), (int)(bas.getHeight()*bas.getScale()));
		canvas.setPreferredSize(canvasSize);
		
		frame = new JFrame(bas.getTitle());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout()); //border layout dont know
		frame.add(canvas, BorderLayout.CENTER);
		frame.pack(); //set frame same size as canvas
		frame.setVisible(true);
		
		canvas.createBufferStrategy(2);
		strategy = canvas.getBufferStrategy();
		graphics = strategy.getDrawGraphics();
	}
	
	public void update()
	{
		graphics.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		strategy.show();
	}

	public BufferedImage getImage() {
		return image;
	}

	public Canvas getCanvas() {
		return canvas;
	}
}
