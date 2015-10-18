package com.gamebase.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Game extends Canvas implements Runnable {
	
	static final int WIDTH=1080;
	static final int HEIGHT=WIDTH/12*9;
	private Thread thread;
	private boolean running=false;
	private Handler handler;
	private Random rand;
	static Window game;
	public Maze maze;
//	public static BufferedImage image;
	
	void paintTheBackground(){	
		
	}
	
	static void close_game()
	{
		game.close();
		
	}
	
	Game()
	{
		
		rand=new Random();
		handler = new Handler();
			maze=new Maze();
		
		this.addKeyListener(new KeyInput(maze));
		this.addMouseListener(new MouseInput());
		game=new Window(HEIGHT,WIDTH,"Base game",this);
		//=new BufferedImage(this.WIDTH,this.HEIGHT,BufferedImage.TYPE_4BYTE_ABGR);
		//this.paintTheBackground();
	
		/*
		handler.add_player(new Player(Game.WIDTH/2,Game.HEIGHT/2,ID.Player));
		handler.add_object(new Obstacle1(this.WIDTH/2,this.HEIGHT/2,ID.Enemy,handler.player,7));
		handler.add_object(new Obstacle1(this.WIDTH/2,this.HEIGHT/2,ID.Enemy,handler.player,6));
		handler.add_object(new Obstacle1(this.WIDTH/2,this.HEIGHT/2,ID.Enemy,handler.player,5));
		handler.add_object(new Obstacle1(this.WIDTH/2,this.HEIGHT/2,ID.Enemy,handler.player,4));
		handler.add_object(new Obstacle1(this.WIDTH/2,this.HEIGHT/2,ID.Enemy,handler.player,3));
		handler.add_object(new Obstacle1(this.WIDTH/2,this.HEIGHT/2,ID.Enemy,handler.player,2));
		handler.add_object(new Obstacle1(this.WIDTH/2,this.HEIGHT/2,ID.Enemy,handler.player,1));
		handler.add_object(new Obstacle1(this.WIDTH/2,this.HEIGHT/2,ID.Enemy,handler.player,0));
		*/
		

	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1550691097823471818L;

	public synchronized void start()
	{
		thread=new Thread(this);
		thread.start();
		running=true;
	}
	public synchronized void stop()
	{
		try {
			thread.join();
			running=false;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public void run() {     //SOMETHING VERY POWERFUL?! Nah just a simple timer?
		long lastTime=System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		long timer2=timer;
		int frames = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta+= (now - lastTime) / ns;
			lastTime = now;
			while(delta>=1)
			{
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis()-timer>1000)
			{
				
				timer += 1000;
				System.out.println("FPS: "+ frames);
				frames = 0;
			}
			if(System.currentTimeMillis()-timer2>300)
			{
				timer+=300;
				//handler.tickSec();
			}
		}	
			// TODO Auto-generated method stub
		
	}
	
	private void tick()
	{
		maze.move();
		//handler.tick();
		
	}
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, WIDTH);
		//g.drawImage(image, 0, 0, this);
		maze.render(g);
		handler.render(g);
		
		
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new Game();
	}
}
