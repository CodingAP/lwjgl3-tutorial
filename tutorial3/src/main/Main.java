package main;

import org.lwjgl.glfw.GLFW;

import engine.io.Input;
import engine.io.Window;

public class Main implements Runnable {
	public Thread game;
	public Window window;
	public final int WIDTH = 1280, HEIGHT = 760;
	
	public void start() {
		game = new Thread(this, "game");
		game.start();
	}
	
	public void init() {
		window = new Window(WIDTH, HEIGHT, "Game");
		window.create();
	}
	
	public void run() {
		init();
		while (!window.shouldClose()) {
			update();
			render();
			if (Input.isKeyDown(GLFW.GLFW_KEY_ESCAPE)) return;
		}
		window.destroy();
	}
	
	private void update() {
		window.update();
		if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_LEFT)) System.out.println("X: " + Input.getMouseX() + ", Y: " + Input.getMouseY());
	}
	
	private void render() {
		window.swapBuffers();
	}
	
	public static void main(String[] args) {
		new Main().start();
	}
}