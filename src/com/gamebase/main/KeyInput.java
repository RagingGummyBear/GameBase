package com.gamebase.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	private Handler handler;
	KeyInput(Handler handler)
	{
		this.handler = handler;
	
	}
	
	public void keyPressed(KeyEvent e){
	int key = e.getKeyCode();
	if(key==KeyEvent.VK_ESCAPE)
	{
		Game.close_game();
	}
	
	}
	
	public void keyReleased(KeyEvent e){
	int key = e.getKeyCode();
	
	
	}
	
	
}
