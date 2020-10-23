package com.ghost.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener{
	
	public Basics gameBasics;
	
	public boolean isKeyBoardActive = false;
	
	public int mouseX, mouseY;
	public int scroll;
	
	public final int USABLE_KEY = 256; 
	public boolean[] keys = new boolean[USABLE_KEY];
	//public boolean[] keysLastFrame = new boolean[USABLE_KEY];
	
	public final int MOUSE_BUTTON = 5;
	public boolean[] mouse = new boolean[MOUSE_BUTTON];
	//public boolean[] mouseLastFrame = new boolean[MOUSE_BUTTON];
	

	public Input(Basics bas)
	{
		this.gameBasics = bas;
		mouseX = 0;
		mouseY = 0;
		scroll = 0;
		
		gameBasics.getWindow().getCanvas().addKeyListener(this);
		gameBasics.getWindow().getCanvas().addMouseListener(this);
		gameBasics.getWindow().getCanvas().addMouseMotionListener(this);
		gameBasics.getWindow().getCanvas().addMouseWheelListener(this);
	}
	
	public boolean isKey(int keyCode) //check if a key is pressed
	{
		return keys[keyCode];
	}
	
	public boolean isMouse(int mouseButton)
	{
		return mouse[mouseButton];
	}

	@Override
	//moving while clicking
	public void mouseDragged(MouseEvent e) {
		mouseX = (int)(e.getX()/gameBasics.getScale());
		mouseY = (int)(e.getY()/gameBasics.getScale());
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = (int)(e.getX()/gameBasics.getScale());
		mouseY = (int)(e.getY()/gameBasics.getScale());
		
	}

	@Override
	//user click and release, used for double click or selecting
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouse[e.getButton()] = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouse[e.getButton()] = false;
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		isKeyBoardActive = true;
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		isKeyBoardActive = false;
		keys[e.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		scroll = e.getWheelRotation();
		
	}
}
