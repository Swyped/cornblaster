package com.cornblaster.engine;

public class GameContainer implements Runnable {
	private Thread thread;
	private boolean  running = false;
	private final double UPDATE_CAP = 1.0/60.0;
			
			
	private void dispose() {
		
	}
	public GameContainer() {
		
	}
	public void start() {
		thread = new Thread(this);
		thread.run();
	}
	public void stop() {
		
	}
	public void run() {
		running = true;
		boolean render = false;
		double firstTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double passedTime = 0;
		double unprocessedTime=0;
		while(running) {
			render = false;
			firstTime = System.nanoTime() / 1000000000.0f;
			passedTime = firstTime-lastTime;
			lastTime = firstTime;
			unprocessedTime+=passedTime;
			while(unprocessedTime>=UPDATE_CAP) {
				unprocessedTime-=UPDATE_CAP;
				render = true;
				System.out.println("Update");
				//TODO
			}
			if(render) {
				//TODO
			}
			else{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}		
	}
	dispose();
	public static void main(String args[]) {
		GameContainer gc = new GameContainer();
		gc.start();
	}
}