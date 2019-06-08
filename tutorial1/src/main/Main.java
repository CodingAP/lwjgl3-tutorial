package main;

public class Main implements Runnable {
	public Thread game;
	
	public void start() {
		game = new Thread(this, "game");
		game.start();
	}
	
	public static void init() {
		System.out.println('Initializing Game!');
	}
	
	public void run() {
		init();
		while (true) {
			update();
			render();
		} 
	}
	
	private void update() {
		System.out.println('Updating Game!');
	}
	
	private void render() {
		System.out.println('Rendering Game!');
	}
	
	public static void main(String[] args) {
		new Main().start();
	}
}