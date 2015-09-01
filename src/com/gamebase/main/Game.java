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
	
	private static final int WIDTH=1080;
	private static final int HEIGHT=WIDTH/12*9;
	private Thread thread;
	private boolean running=false;
	private Handler handler;
	private Random rand;
	static Window game;
	public static BufferedImage image;
	
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
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new MouseInput());
		game=new Window(HEIGHT,WIDTH,"Base game",this);
	/*	try {
			image = ImageIO.read(new File("C:\\Users\\Darko\\Desktop\\1368709023193.jpg"));
		} catch (IOException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		image=new BufferedImage(this.WIDTH,this.HEIGHT,BufferedImage.TYPE_4BYTE_ABGR);
		this.paintTheBackground();

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
		}	
			// TODO Auto-generated method stub
		
	}
	
	private void tick()
	{
		handler.tick();
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
		
		//g.setColor(Color.cyan);
		//g.fillRect(0, 0, WIDTH, WIDTH);
		g.drawImage(image, 0, 0, this);
		handler.render(g);
		
		
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new Game();
	}
}
