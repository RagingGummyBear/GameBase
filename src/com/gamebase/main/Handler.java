package com.gamebase.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick()
	{
		for(int i=0;i<object.size();i++)
		{
			object.get(i).tick();
		}
	}
	public void render(Graphics g)
	{
		for(int i=0;i<object.size();i++)
		{
			object.get(i).render(g);
		}
	}
	public void add_object(GameObject object)
	{
		this.object.add(object);
	}
	public void remove_object(GameObject object)
	{
		this.object.remove(object);
	}
	
}
