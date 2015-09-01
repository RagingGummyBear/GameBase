package com.gamebase.main;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class DrawEffect implements Runnable{

	Random rand=new Random();
	Point p;
	Thread thread=new Thread(this);
	DrawEffect(Point p)
	{
		this.p=p;
		this.start();
	}
	synchronized void start(){
		thread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int endX[]=new int[3];
		endX[0]=p.x+100;
		endX[1]=p.x;
		endX[2]=p.x-100;
		int endY[]=new int[3];
		endY[0]=p.y;
		endY[1]=p.y+100;
		endY[2]=p.y-100;
		for(int i=0;i<8;i++)new DrawingEffectThread(p.x-100,p.y-100,p.x+100,p.y+100,i,this.random_Color(),p).start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	int random_Color()
	{
		if(rand.nextInt(5)==0)
		{
			return new Color(0,255,0,255).getRGB();
		}
		else 
		{
			if(rand.nextInt(4)==0)
			{
				return new Color(255,255,0,255).getRGB();
			}
			else 
				if(rand.nextInt(3)==0)
				{
					return new Color(255,0,255,255).getRGB();
				}
				else
					if(rand.nextInt(2)==0)
					{
						return new Color(255,200,0,255).getRGB();
					}
					else
						return new Color(255,0,255,200).getRGB();
						
			
		}
	}
}
