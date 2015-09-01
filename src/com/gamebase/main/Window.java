package com.gamebase.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Window extends Canvas {

	JFrame frame;
	/**
	 * 
	 */
	private static final long serialVersionUID = -240840600533728354L;
	public Window(int height,int width,String title,Game game)
	{
		frame=new JFrame(title);
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
	public void close()
	{
		frame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
		//frame.dispose();
		
	}
	
}
