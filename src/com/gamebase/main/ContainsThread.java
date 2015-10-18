package com.gamebase.main;

import java.awt.Point;
import java.awt.Polygon;
import java.util.LinkedList;

public class ContainsThread implements Runnable{
	Thread thread;
	Polygon poly;
	int side;
	LinkedList<Point> points=new LinkedList<Point>();
	boolean running=false;
	
	public void set_list(LinkedList<Point> p )
	{
		points=p;
	}	
	ContainsThread(Polygon p,int s)
	{
		side=s;
		poly=p;
	}

	@Override
	public void run() {
	
		for(int i=0;i<points.size();i++)
		{
			if(poly.contains(points.get(i)))
				{
				Player.alive=false;
				break;
				}
		}
		running=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
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
