package com.gamebase.main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;
import java.util.Random;

public class Maze {

	Random rand=new Random();
	public static int WIDTHSTART = 240;
	public static int WIDTHEND = 840;
	public static int HEIGHTSTART = 105;
	public static int HEIGHTEND = 705;
	Tile tiles[][] = new Tile[120][120];
	Point player = new Point(120/2,120/2);
	public boolean move_up = false;
	public boolean move_down = false;
	public boolean move_left = false;
	public boolean move_right = false;
	boolean ff=false;
	public static int size=50;
	
	public Maze()
	{
		for(int i = 0; i < 120; i++)
		{
				for(int y=0; y < 120; y++)
			{
				if(i<25)
				{
					tiles[i][y]= new Tile(false);
				}
				else if(i>93)
				{
					tiles[i][y] = new Tile(false);
				}
				else 
					if(y<25) tiles[i][y] = new Tile(false);
				else 
					
						if(y>93)
						{
							tiles[i][y] = new Tile(false);
						}
					else if(rand.nextInt(4-0+1)==1)
				{
					tiles[i][y]=new Tile(false);
				}
				else 
				{
					tiles[i][y]=new Tile(true);
				}
			}
		}
	}
	public void move()
	{
		if(ff){if(move_up)
		{
			this.move_up();
		}
		else if(move_down)
		{
			this.move_down();
		}
		else if(move_left)
		{
			this.move_left();
		}
		else if(move_right)
		{
			this.move_right();
		}
		ff=false;
		}
		else 
		{
			ff=true;
		}
	}
	public void move_up()
	{
	int temp2=player.y;
		int temp1=player.x-1;
		if(tiles[temp1][temp2].movable)
		{
			player.x-=1;
		}
		
	}
	public void move_down()
	{
		int temp2=player.y;
		int temp1=player.x+1;
		if(tiles[temp1][temp2].movable)
		{
			player.x+=1;
		}
		
	}
	public void move_left()
	{
		int temp2=player.y-1;
		int temp1=player.x;
		if(tiles[temp1][temp2].movable)
		{
			player.y-=1;
		}
	}
	public void move_right()
	{
		int temp2=player.y+1;
		int temp1=player.x;
		if(tiles[temp1][temp2].movable)
		{
			player.y+=1;
		}
	}
	
	public void render(Graphics g)
	{
		// TODO Auto-generated method stub
		g.setColor(Color.orange);
		Graphics2D g2 = (Graphics2D) g.create();
		Stroke old_stroke = g2.getStroke();
		g2.setStroke(new BasicStroke(10));
		//g.fillRect(x, y, 400, 400);
		int pointsX[]=new int[4];
		int pointsY[]=new int[4];
		pointsX[0] = 240;
		pointsX[1] = 840;
		pointsX[2] = 840;
		pointsX[3] = 240;
		pointsY[0] = 105;
		pointsY[1] = 105;
		pointsY[2] = 705;
		pointsY[3] = 705;
		g2.drawPolygon(pointsX, pointsY, 4);
		// da se icrtaat 50 tiles so toasto 25 od gore 25 od dole
		int tempX=player.x-((600/size)/2);
		int tempY=player.y-((600/size)/2);
		int temp1=tempX;
		int temp2=tempY;
		for(int i=0;i<(600/size);i++)
		{
			
			for(int y=0;y<(600/size);y++)
			{		
			
				tiles[temp1][temp2].render(g,this.WIDTHSTART+(size*y),this.HEIGHTSTART+(size*i),size);
				temp2++;
		
			}
			
			temp2=tempY;
			temp1++;
		}
		int xp[]= new int[4];
		int yp[] = new int[4];
		xp[0] = 540;
		xp[1] = xp[0]+size;
		xp[2] = xp[1];
		xp[3] = xp[0];
		yp[0] = 405;
		yp[1] = yp[0];
		yp[2] = yp[0]+size;
		yp[3] = yp[2];
		Polygon polly;
		g.setColor(Color.BLACK);
		g.fillPolygon(xp,yp,4);
		g2.setStroke(old_stroke);
	}
	
	
	
	
	
	
}
