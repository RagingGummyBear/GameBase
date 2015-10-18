package com.gamebase.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.LinkedList;

public class Obstacle1 extends GameObject{

	double pointsX1[]={Game.WIDTH/2-90,Game.WIDTH/2-13,Game.WIDTH/2+13,Game.WIDTH/2+90,Game.WIDTH/2+90,Game.WIDTH/2-90};
	double pointsY1[]={Game.HEIGHT/2-50,Game.HEIGHT/2-80,Game.HEIGHT/2-80,Game.HEIGHT/2-50,Game.HEIGHT/2-15,Game.HEIGHT/2-15};
	double pointsX2[]={Game.WIDTH/2-90,Game.WIDTH/2-13,Game.WIDTH/2+13,Game.WIDTH/2+90,Game.WIDTH/2+90,Game.WIDTH/2-90};
	double pointsY2[]={Game.HEIGHT/2+50,Game.HEIGHT/2+80,Game.HEIGHT/2+80,Game.HEIGHT/2+50,Game.HEIGHT/2+15,Game.HEIGHT/2+15};
	int npoints = 6;
	int side=0;
	ContainsThread thread1,thread2;
	int velXsum=0;
	int velYsum=0;
	Polygon polly1;
	Polygon polly2;
	Player player;
	int counter=0;
	boolean should_move=false;
	
	public Obstacle1(int x, int y, ID id,Player p,int side) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	
		this.side=side;
		this.set();
		player=p;
	
		int tempX1[]=new int[6];
		int tempY1[]=new int[6];
		int tempX2[]=new int[6];
		int tempY2[]=new int[6];
		for(int i=0;i<6;i++)
		{
			tempX1[i]=(int)pointsX1[i];
			tempY1[i]=(int)pointsY1[i];
			tempX2[i]=(int)pointsX2[i];
			tempY2[i]=(int)pointsY2[i];
		}
		polly1=new Polygon(tempX1,tempY1,npoints);
		polly2=new Polygon(tempX2,tempY2,npoints);

	}

	/*void reset(int velX)

	{
		this.velX=velX;
		
	}*/
	

	void set()
	{
		should_move=false;
		switch (this.side){
		case 0: {
			
			double []tempX1=new double[6];
			double []tempX2=new double[6];
			double []tempY1=new double[6];
			double []tempY2=new double[6];
			for(int i=0;i<6;i++)
			{
				tempX1[i]=pointsX1[i]-Game.WIDTH/2;
				tempX2[i]=pointsX2[i]-Game.WIDTH/2;
				tempY1[i]=pointsY1[i]-Game.HEIGHT/2;
				tempY2[i]=pointsY2[i]-Game.HEIGHT/2;
			}
			for(int i=0;i<6;i++)
			{
				pointsX1[i]=((tempX1[i] * Math.cos(1.58) - tempY1[i] * Math.sin(1.58)))+Game.WIDTH/2;
				pointsX2[i]=((tempX2[i] * Math.cos(1.58) - tempY2[i] * Math.sin(1.58)))+Game.WIDTH/2;
				pointsY1[i]= ((tempX1[i] * Math.sin(1.58) + tempY1[i] * Math.cos(1.58)))+Game.HEIGHT/2;
				pointsY2[i]= ((tempX2[i] * Math.sin(1.58) + tempY2[i] * Math.cos(1.58)))+Game.HEIGHT/2;
			}		
			for(int i=0;i<6;i++)
			{
				pointsY1[i]-=Game.HEIGHT/2+120;
				pointsY2[i]-=Game.HEIGHT/2+120;
			}
			
			
			this.velY=4;
			this.velX=0;
			break;
		}
		case 1: {
			
			double []tempX1=new double[6];
			double []tempX2=new double[6];
			double []tempY1=new double[6];
			double []tempY2=new double[6];
			for(int i=0;i<6;i++)
			{
				tempX1[i]=pointsX1[i]-Game.WIDTH/2;
				tempX2[i]=pointsX2[i]-Game.WIDTH/2;
				tempY1[i]=pointsY1[i]-Game.HEIGHT/2;
				tempY2[i]=pointsY2[i]-Game.HEIGHT/2;
			}
			for(int i=0;i<6;i++)
			{
				pointsX1[i]=((tempX1[i] * Math.cos(2.5) - tempY1[i] * Math.sin(2.5)))+Game.WIDTH/2;
				pointsX2[i]=((tempX2[i] * Math.cos(2.5) - tempY2[i] * Math.sin(2.5)))+Game.WIDTH/2;
				pointsY1[i]= ((tempX1[i] * Math.sin(2.5) + tempY1[i] * Math.cos(2.5)))+Game.HEIGHT/2;
				pointsY2[i]= ((tempX2[i] * Math.sin(2.5) + tempY2[i] * Math.cos(2.5)))+Game.HEIGHT/2;
			}		
			for(int i=0;i<6;i++)
			{
				pointsY1[i]-=Game.HEIGHT/2+90;
				pointsY2[i]-=Game.HEIGHT/2+90;
			
				pointsX1[i]+=Game.WIDTH/2+120;
				pointsX2[i]+=Game.WIDTH/2+120;
			}
			
						
			this.velX=-4;
			this.velY=3;
			break;
		}
		case 2: {
			for(int i=0;i<npoints;i++){
			pointsX1[i]+=Game.WIDTH/2+120;
			pointsX2[i]+=Game.WIDTH/2+120;
			}
			this.velX=-4;
			this.velY=0;
			break;
		}
		case 3: {
			double []tempX1=new double[6];
			double []tempX2=new double[6];
			double []tempY1=new double[6];
			double []tempY2=new double[6];
			for(int i=0;i<6;i++)
			{
				tempX1[i]=pointsX1[i]-Game.WIDTH/2;
				tempX2[i]=pointsX2[i]-Game.WIDTH/2;
				tempY1[i]=pointsY1[i]-Game.HEIGHT/2;
				tempY2[i]=pointsY2[i]-Game.HEIGHT/2;
			}
			for(int i=0;i<6;i++)
			{
				pointsX1[i]=((tempX1[i] * Math.cos(-2.5) - tempY1[i] * Math.sin(-2.5)))+Game.WIDTH/2;
				pointsX2[i]=((tempX2[i] * Math.cos(-2.5) - tempY2[i] * Math.sin(-2.5)))+Game.WIDTH/2;
				pointsY1[i]= ((tempX1[i] * Math.sin(-2.5) + tempY1[i] * Math.cos(-2.5)))+Game.HEIGHT/2;
				pointsY2[i]= ((tempX2[i] * Math.sin(-2.5) + tempY2[i] * Math.cos(-2.5)))+Game.HEIGHT/2;
			}		
			for(int i=0;i<6;i++)
			{
				pointsY1[i]+=Game.HEIGHT/2+90;
				pointsY2[i]+=Game.HEIGHT/2+90;
			
				pointsX1[i]+=Game.WIDTH/2+120;
				pointsX2[i]+=Game.WIDTH/2+120;
			}
			
			this.velX=-4;
			this.velY=-3;
			break;
		}
		case 4: {
			
			double []tempX1=new double[6];
			double []tempX2=new double[6];
			double []tempY1=new double[6];
			double []tempY2=new double[6];
			for(int i=0;i<6;i++)
			{
				tempX1[i]=pointsX1[i]-Game.WIDTH/2;
				tempX2[i]=pointsX2[i]-Game.WIDTH/2;
				tempY1[i]=pointsY1[i]-Game.HEIGHT/2;
				tempY2[i]=pointsY2[i]-Game.HEIGHT/2;
			}
			for(int i=0;i<6;i++)
			{
				pointsX1[i]=((tempX1[i] * Math.cos(1.58) - tempY1[i] * Math.sin(1.58)))+Game.WIDTH/2;
				pointsX2[i]=((tempX2[i] * Math.cos(1.58) - tempY2[i] * Math.sin(1.58)))+Game.WIDTH/2;
				pointsY1[i]= ((tempX1[i] * Math.sin(1.58) + tempY1[i] * Math.cos(1.58)))+Game.HEIGHT/2;
				pointsY2[i]= ((tempX2[i] * Math.sin(1.58) + tempY2[i] * Math.cos(1.58)))+Game.HEIGHT/2;
			}		
			for(int i=0;i<6;i++)
			{
				pointsY1[i]+=Game.HEIGHT/2+120;
				pointsY2[i]+=Game.HEIGHT/2+120;
			}
			
			
			this.velX=0;
			this.velY=-4;
			break;
		}
		case 5: {
			

			double []tempX1=new double[6];
			double []tempX2=new double[6];
			double []tempY1=new double[6];
			double []tempY2=new double[6];
			for(int i=0;i<6;i++)
			{
				tempX1[i]=pointsX1[i]-Game.WIDTH/2;
				tempX2[i]=pointsX2[i]-Game.WIDTH/2;
				tempY1[i]=pointsY1[i]-Game.HEIGHT/2;
				tempY2[i]=pointsY2[i]-Game.HEIGHT/2;
			}
			for(int i=0;i<6;i++)
			{
				pointsX1[i]=((tempX1[i] * Math.cos(2.5) - tempY1[i] * Math.sin(2.5)))+Game.WIDTH/2;
				pointsX2[i]=((tempX2[i] * Math.cos(2.5) - tempY2[i] * Math.sin(2.5)))+Game.WIDTH/2;
				pointsY1[i]= ((tempX1[i] * Math.sin(2.5) + tempY1[i] * Math.cos(2.5)))+Game.HEIGHT/2;
				pointsY2[i]= ((tempX2[i] * Math.sin(2.5) + tempY2[i] * Math.cos(2.5)))+Game.HEIGHT/2;
			}		
			for(int i=0;i<6;i++)
			{
				pointsY1[i]+=Game.HEIGHT/2+90;
				pointsY2[i]+=Game.HEIGHT/2+90;
			
				pointsX1[i]-=Game.WIDTH/2+120;
				pointsX2[i]-=Game.WIDTH/2+120;
			}
			
			
			
			this.velX=4;
			this.velY=-3;
			break;
		}
		case 6: {
			this.velX=4;
			this.velY=0;
			for(int i=0;i<6;i++)
			{
				pointsX1[i]-=Game.WIDTH/2+120;
				pointsX2[i]-=Game.WIDTH/2+120;
			}
			break;
		}
		case 7: {
			
			double []tempX1=new double[6];
			double []tempX2=new double[6];
			double []tempY1=new double[6];
			double []tempY2=new double[6];
			for(int i=0;i<6;i++)
			{
				tempX1[i]=pointsX1[i]-Game.WIDTH/2;
				tempX2[i]=pointsX2[i]-Game.WIDTH/2;
				tempY1[i]=pointsY1[i]-Game.HEIGHT/2;
				tempY2[i]=pointsY2[i]-Game.HEIGHT/2;
			}
			for(int i=0;i<6;i++)
			{
				pointsX1[i]=((tempX1[i] * Math.cos(-2.5) - tempY1[i] * Math.sin(-2.5)))+Game.WIDTH/2;
				pointsX2[i]=((tempX2[i] * Math.cos(-2.5) - tempY2[i] * Math.sin(-2.5)))+Game.WIDTH/2;
				pointsY1[i]= ((tempX1[i] * Math.sin(-2.5) + tempY1[i] * Math.cos(-2.5)))+Game.HEIGHT/2;
				pointsY2[i]= ((tempX2[i] * Math.sin(-2.5) + tempY2[i] * Math.cos(-2.5)))+Game.HEIGHT/2;
			}		
			for(int i=0;i<6;i++)
			{
				pointsY1[i]-=Game.HEIGHT/2+90;
				pointsY2[i]-=Game.HEIGHT/2+90;
			
				pointsX1[i]-=Game.WIDTH/2+120;
				pointsX2[i]-=Game.WIDTH/2+120;
			}
			
			this.velX=4;
			this.velY=3;
			break;
		}
		default: {
			this.velX=0;
			this.velY=0;
		}
		}
	}
	
	void reset()
	{
		for(int i=0;i<6;i++)
		{
			this.pointsX1[i]-=velXsum;
			this.pointsX2[i]-=velXsum;
			this.pointsY1[i]-=velYsum;
			this.pointsY2[i]-=velYsum;
		}
		velXsum=0;
		velYsum=0;
		this.should_move=false;
		
	}
	
	
	boolean hit_event(LinkedList<Point> lista)
	{
		
		if(lista!=null)for(int i=0;i<lista.size();i++)
		{
			try{
			if(lista!=null && polly1!=null)if(polly1.contains(lista.get(i)))
				return true;
			if(lista!=null && polly2!=null)if(polly2.contains(lista.get(i)))return true;
			
			}catch(Exception e)
			{
				
			}
		}
		return false;
	}
	
	@Override
	public void tick() {
		
if(should_move){
		for(int i=0;i<6;i++)
		{
			pointsX1[i]+=this.velX;
			pointsX2[i]+=this.velX;
			pointsY1[i]+=this.velY;
			pointsY2[i]+=this.velY;
		}
		this.velXsum+=velX;
		this.velYsum+=velY;
		int tempX1[]=new int[6];
		int tempY1[]=new int[6];
		int tempX2[]=new int[6];
		int tempY2[]=new int[6];
		for(int i=0;i<6;i++)
		{
			tempX1[i]=(int) pointsX1[i];
			tempY1[i]=(int)pointsY1[i];
			tempX2[i]=(int)pointsX2[i];
			tempY2[i]=(int)pointsY2[i];
		}
		
		polly1=new Polygon(tempX1,tempY1,npoints);
		polly2=new Polygon(tempX2,tempY2,npoints);
		thread1=new ContainsThread(polly1,side);
		thread2=new ContainsThread(polly2,side);
		// TODO Auto-generated method stub
}

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GREEN);
		int tempX1[]=new int[6];
		int tempY1[]=new int[6];
		int tempX2[]=new int[6];
		int tempY2[]=new int[6];
		for(int i=0;i<6;i++)
		{
			tempX1[i]=(int) pointsX1[i];
			tempY1[i]=(int)pointsY1[i];
			tempX2[i]=(int)pointsX2[i];
			tempY2[i]=(int)pointsY2[i];
		}
		g.fillPolygon(tempX1, tempY1, npoints);
		g.fillPolygon(tempX2,tempY2 , npoints);
		//Rectangle2D rect=player.polly.getBounds2D();
		//g.fillRect(rect.OUT_TOP,rect.OUT_LEFT,rect.OUT_RIGHT,rect.OUT_BOTTOM);
	}


	@Override
	public void tickSec(LinkedList<Point>p) {
		if(this.should_move){
			if(thread1!=null){
		
			thread1.set_list(p);
			thread1.start();
			
		}
		
		if(thread2!=null){
			thread2.set_list(p);
			thread2.start();
		}
		}
		if(this.should_move)counter++;
		else counter=0;
		if(counter==1400){
			counter=0;
			this.reset();
		}
		// TODO Auto-generated method stub
		/*if(hit_event(p))
		{
			player.alive=false;
			velX=0;
		//System.out.println("HITED");
		}*/
		
	}



	
	
	
}
