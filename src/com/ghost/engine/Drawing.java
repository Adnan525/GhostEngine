package com.ghost.engine;

import java.awt.image.DataBufferInt;

public class Drawing {
	private int width, height;
	private int[] pixelData;
	
	public Drawing(Basics bas)
	{
		width = bas.getWidth();
		height = bas.getHeight();
		pixelData = ((DataBufferInt)bas.getWindow().getImage().getRaster().getDataBuffer()).getData();
	}
	public void clear()
	{
		for(int i =0; i<pixelData.length; i++)
		{
			pixelData[i] += 0;
		}
	}

}
