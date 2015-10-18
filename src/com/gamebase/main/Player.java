package com.gamebase.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.LinkedList;

public class Player extends GameObject{
	public double []xs = {Game.WIDTH/2-65,Game.WIDTH/2+65,Game.WIDTH/2+65,Game.WIDTH/2-65};
	public double []ys = {Game.HEIGHT/2-10,Game.HEIGHT/2-10,Game.HEIGHT/2+10,Game.HEIGHT/2+10};
    int npoints = 4;
    double angle=0.05;
    boolean rotate_left=false;
    boolean rotate_right=false;
    public static boolean alive=true;
    Polygon polly;
    double angle_helper=0;

	public Player(int x, int y, ID id) {
		super(x, y, id);

		// TODO Auto-generated constructor stub		
		int pointsX[]=new int[4];
		int pointsY[]=new int[4];
		for(int i=0;i<4;i++)
		{
			pointsX[i]=(int) xs[i];
			pointsY[i]=(int) ys[i];
		}
		polly = new Polygon(pointsX, pointsY, npoints);
	}

	public void rotate_left()
	{
		
		int pointsX[]=new int[4];
		int pointsY[]=new int[4];
		for(int i=0;i<4;i++)
		{
			pointsX[i]=(int) xs[i];
			pointsY[i]=(int) ys[i];
		}
		polly = new Polygon(pointsX, pointsY, npoints);
		if(rotate_left){
			angle_helper+=angle;
		double []tempX=new double[4];
		double []tempY=new double[4];
		for(int i=0;i<4;i++)
		{
			tempX[i]=xs[i]-Game.WIDTH/2;
			tempY[i]=ys[i]-Game.HEIGHT/2;
		}
		for(int i=0;i<4;i++)
		{
			xs[i]=((tempX[i] * Math.cos(-angle) - tempY[i] * Math.sin(-angle)))+Game.WIDTH/2;
			ys[i]= ((tempX[i] * Math.sin(-angle) + tempY[i] * Math.cos(-angle)))+Game.HEIGHT/2;
		}
		
	}
	}
	public void rotate_right()
	{

		int pointsX[]=new int[4];
		int pointsY[]=new int[4];
		for(int i=0;i<4;i++)
		{
			pointsX[i]=(int) xs[i];
			pointsY[i]=(int) ys[i];
		}
		polly = new Polygon(pointsX, pointsY, npoints);
		if(rotate_right){
		double []tempX=new double[4];
		double []tempY=new double[4];
		for(int i=0;i<4;i++)
		{
			tempX[i]=xs[i]-Game.WIDTH/2;
			tempY[i]=ys[i]-Game.HEIGHT/2;
		}
		for(int i=0;i<4;i++)
		{
			xs[i]=((tempX[i] * Math.cos(angle) - tempY[i] * Math.sin(angle)))+Game.WIDTH/2;
			ys[i]= ((tempX[i] * Math.sin(angle) + tempY[i] * Math.cos(angle)))+Game.HEIGHT/2;
		}
		}
		
	}
	
	public LinkedList<Point> getPoints()
	{
		
		LinkedList<Point> lista=new LinkedList<Point>();
		int minX=polly.getBounds().x;
		int maxX=polly.getBounds().width+minX;
		int minY=polly.getBounds().y;
		int maxY=polly.getBounds().height+minY;

		Point temp=new Point(0,0);
		for(int i=minX;i<maxX;i++)
		{
			for(int y=minY;y<maxY;y++)
			{
				temp=new Point(i,y);
				if(polly.contains(temp))
				{
					lista.add(temp);
				}
			}
		}
		return lista;
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
	
		if(!alive)	
		{
			System.out.println("PLayer died");
		}

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.YELLOW);
		//g.fillRect(x, y, 400, 400);
		int pointsX[]=new int[4];
		int pointsY[]=new int[4];
		for(int i=0;i<4;i++)
		{
			pointsX[i]=(int) xs[i];
			pointsY[i]=(int) ys[i];
		}
		g.fillPolygon(pointsX, pointsY, npoints);
		
		
		
	}

	@Override
	public void tickSec(LinkedList<Point>p) {
		// TODO Auto-generated method stub
		
	}


}
