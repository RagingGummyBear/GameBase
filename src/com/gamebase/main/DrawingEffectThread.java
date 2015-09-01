package com.gamebase.main;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class DrawingEffectThread implements Runnable{

	int startX=0;
	int startY=0;
	int endX=0;
	int endY=0;
	int side=0;
	Point p;
	boolean finished;
	BufferedImage image;
	Thread thread;
	int color;
	public synchronized void start()
	{
		System.out.println("Thread with side: "+side + " STARTED");
		thread=new Thread(this);
		thread.start();
	}
	public synchronized void stop()
	{
		try {
			thread.join();
		}catch(Exception e)
		{
			//e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		
		for(int i=startX;i<endY;i++)
		{
			for(int y=startY;y<endY;y++)
			{
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				//System.out.println("HAPPENS");
			
			//	System.out.println("y: "+y+" p.y:"+p.y);
				try{
				if(side==0 && y<p.y && (i<p.x+5 || i>p.x)){
					image.setRGB(i, y, color);
				}
				else if(side==1 && y<p.y && i>p.x && (y-p.y==-i-p.x))image.setRGB(i, y, color);
				else if(side==2 && i>p.x && (y==p.y+5 || y==p.y))image.setRGB(i, y, color);
				else if(side==3 && i>p.x && y>0 && (y-p.y==i-p.x))image.setRGB(i, y, color);
				else if(side==4 && y>p.y && (i==p.x || i==p.x+5))image.setRGB(i, y, color);
				else if(side==5 && i>p.x && y>p.y && (y-p.y==-i-p.x))image.setRGB(i, y, color);
				else if(side==6 && i<p.x && (y==p.y || y==p.y+5))image.setRGB(i, y, color);
				else if(side==7 && i<p.x && y<p.y && (y-p.y==i-p.x))image.setRGB(i, y, color);
				
				
				}
				catch(Exception e)
				{
					
				}
			}
		}
		finished=true;
		System.out.println("Thread with side: "+side + " FINISHED");
		this.stop();	
	}
	public DrawingEffectThread(int startX, int startY,int endX,int endY,int side,int c,Point p) {
		super();
		
		this.p=p;
		this.startX = startX;
		this.startY = startY;
		this.endX=endX;
		this.endY=endY;
		this.finished = false;
		this.side=side;
		this.image = Game.image;
		this.color=c;
		this.run();
	}

	
	

}
