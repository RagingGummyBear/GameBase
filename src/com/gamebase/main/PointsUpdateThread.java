package com.gamebase.main;

import java.awt.Point;
import java.awt.Polygon;
import java.util.LinkedList;

public class PointsUpdateThread implements Runnable{

	Boolean running=false;
	Thread thread;

	LinkedList<Point> points;
	Player player;
	public PointsUpdateThread(Player p )
	{

		player=p;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		points=new LinkedList<Point>();
		Polygon polly=player.polly;
		int minX=polly.getBounds().x;
		int maxX=polly.getBounds().width+minX;
		int minY=polly.getBounds().y;
		int maxY=polly.getBounds().height+minY;

		Point temp=new Point(0,0);
		for(int i=minX;i<maxX;i++)
		{
			
			for(int y=minY;y<maxY;y++)
			{
				if(y>minY && i!=maxX-1 && i!=minX)
				{
					y+=maxY-3;
				}
				temp=new Point(i,y);
				if(polly.contains(temp))
				{
					points.add(temp);
				}
			}
		}
		Handler.check(points);
		try {
			running= false;
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	synchronized void start()
	{
		thread=new Thread(this);
		running=true;
		thread.start();
	}
	synchronized void stop()
	{
		try {
		running=false;
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
