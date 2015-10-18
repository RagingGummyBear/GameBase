package com.gamebase.main;

import java.awt.Color;
import java.awt.Graphics;

public class Tile {

	public boolean movable;
	
	public Tile(boolean b)
	{
		movable=b;
	}
	public void render(Graphics g,int startX,int startY,int size)
	{
		int xp[]=new int[4];
		int yp[] = new int[4];
		xp[0] = startX;
		xp[1] = startX+size;
		xp[2] = startX+size;
		xp[3] = startX;
		yp[0] = startY;
		yp[1] = startY;
		yp[2] = startY+size;
		yp[3] = startY+size;
		if(movable)
		{
			g.setColor(Color.pink);
			g.drawPolygon(xp, yp, 4);
		}
		else 
		{
			g.setColor(Color.red);
			g.fillPolygon(xp,yp,4);
		}
	}
	
	
}
