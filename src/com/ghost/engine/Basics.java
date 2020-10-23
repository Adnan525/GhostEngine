package com.ghost.engine;

public class Basics implements Runnable
{
	public Thread mainThread;
	public Window window;
	
	public boolean isRunning = false;
	private final double FRAME_RATE = 1.0/60.0;
	private int width = 320;
	private int height = 240;
	private double scale = 1.0;
	private String title = "Ghost Engine Test";
	
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getScale() {
		return scale;
	}
	public void setScale(double scale) {
		this.scale = scale;
	}
	
	//starting the engine code
	public Basics()
	{
		
	}
	public void start()
	{
		window = new Window(this);
		mainThread = new Thread(this);
		mainThread.run(); //.run will run as main thread
	}
	public void stop()
	{
		
	}
	public void run()
	{
		isRunning = true;
		boolean render = false;
		double startTime = 0;
		double endTime = System.currentTimeMillis();
		double passedTime = 0;
		double unChecked = 0;
		
		while(isRunning)
		{
			startTime = System.currentTimeMillis();
			passedTime = startTime - endTime;
			endTime = startTime;
			
			unChecked+= passedTime;
			
			while(unChecked >= FRAME_RATE)
			{
				unChecked -= FRAME_RATE;
				render = true;
				//update the game
//				System.out.println(startTime + " " + endTime + " " + passedTime);
			}
			if(render)
			{
				window.update();
				render = false;
			}
			else 
			{
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		gameLoop();
		
	}
	public void gameLoop()
	{
		
	}
	
	public static void main(String args[])
	{
		Basics game = new Basics();
		game.start();
	}
}
