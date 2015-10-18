package com.gamebase.main;

import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

public class Handler {

	static LinkedList<Point> points=new LinkedList<Point>();
	LinkedList<Obstacle1> object = new LinkedList<Obstacle1>();
	Player player;
	PointsUpdateThread thread;
	Random rand=new Random();
	int counter=0;
	
	public static void check(LinkedList<Point> lista)
	{
		 
		points=lista;
		
	}
	public void reset()
	{
		for(int i=0;i<object.size();i++)
			object.get(i).reset();
		Player.alive=true;
		
	}
	public void tickSec()
	{
		if(counter==700)
		{
			counter=0;
			int temp=rand.nextInt(8);
			System.out.println(temp);
			if(!object.get(temp).should_move)
			{
				object.get(temp).should_move=true;
			}
			else 
			{
				
				object.get(rand.nextInt(8)).should_move=true;
			}
		}
		counter++;
		if(thread!=null && !thread.running)thread.start();
		if(points!=null)for(int i=0;i<object.size();i++)
		{
			object.get(i).tickSec(points);
		}
	}
	public void tick()
	{
		if(player!=null)if(player.alive)
		{
			player.rotate_left();
		player.rotate_right();
		
		for(int i=0;i<object.size();i++)
		{
			object.get(i).tick();
		}
		}
	}
	public void render(Graphics g)
	{
		if(player!=null)player.render(g);
		for(int i=0;i<object.size();i++)
		{
			object.get(i).render(g);
		}
	}
	public void add_player(Player p)
	{
		this.player=p;
		thread=new PointsUpdateThread(player);
	}
	public void add_object(Obstacle1 object)
	{
		this.object.add(object);
	}
	public void remove_object(GameObject object)
	{
		this.object.remove(object);
	}
	
}
