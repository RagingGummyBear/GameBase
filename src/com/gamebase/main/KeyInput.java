package com.gamebase.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	public Maze maze;
	KeyInput(Maze m)
	{
		maze = m;
	
	}
	
	public void keyPressed(KeyEvent e){
	int key = e.getKeyCode();
	if(key==KeyEvent.VK_F1)
	{
	//handler.reset();
	}
	else if(key==KeyEvent.VK_RIGHT)
	{

		maze.move_right = true;
	// maze.move_right();
		
		
	}
	else if(key==KeyEvent.VK_LEFT)
	{		
			//	handler.player.rotate_left=true;
	
		maze.move_left = true;
		//maze.move_left();
					
	}
	else 

		{
			if(key== KeyEvent.VK_UP)
			{
				maze.move_up = true;
				//maze.move_up();
			}
			else 
			{
				if(key == KeyEvent.VK_DOWN)
				{
					maze.move_down = true;
					//maze.move_down();
				}
			}
		}
	
	}
	
	public void keyReleased(KeyEvent e){
	int key = e.getKeyCode();
	
		if(key==KeyEvent.VK_RIGHT)
		{

			maze.move_right = false;
		// maze.move_right();
			
			
		}
		else if(key==KeyEvent.VK_LEFT)
		{		
				//	handler.player.rotate_left=true;
		
			maze.move_left = false;
			//maze.move_left();
						
		}
		else 

			{
				if(key== KeyEvent.VK_UP)
				{
					maze.move_up = false;
					//maze.move_up();
				}
				else 
				{
					if(key == KeyEvent.VK_DOWN)
					{
						maze.move_down = false;
						//maze.move_down();
					}
				}
			}
	}
	
	
}
