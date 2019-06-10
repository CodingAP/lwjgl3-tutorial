package engine.io;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

public class Input {
	private static boolean[] keys = new boolean[GLFW.GLFW_KEY_LAST];
	private static boolean[] buttons = new boolean[GLFW.GLFW_MOUSE_BUTTON_LAST];
	private static double mouseX, mouseY;
	
	private GLFWKeyCallback keyboard;
	private GLFWCursorPosCallback mouseMove;
	private GLFWMouseButtonCallback mouseButtons;
	
	public Input() {
		keyboard = new GLFWKeyCallback() {
			public void invoke(long window, int key, int scancode, int action, int mods) {
				keys[key] = (action != GLFW.GLFW_RELEASE);
			}
		};
		
		mouseMove = new GLFWCursorPosCallback() {
			public void invoke(long window, double xpos, double ypos) {
				mouseX = xpos;
				mouseY = ypos;
			}
		};
		
		mouseButtons = new GLFWMouseButtonCallback() {
			public void invoke(long window, int button, int action, int mods) {
				buttons[button] = (action != GLFW.GLFW_RELEASE);
			}
		};
	}
	
	public static boolean isKeyDown(int key) {
		return keys[key];
	}
	
	public static boolean isButtonDown(int button) {
		return buttons[button];
	}
	
	public void destroy() {
		keyboard.free();
		mouseMove.free();
		mouseButtons.free();
	}

	public static double getMouseX() {
		return mouseX;
	}

	public static double getMouseY() {
		return mouseY;
	}

	public GLFWKeyCallback getKeyboardCallback() {
		return keyboard;
	}

	public GLFWCursorPosCallback getMouseMoveCallback() {
		return mouseMove;
	}

	public GLFWMouseButtonCallback getMouseButtonsCallback() {
		return mouseButtons;
	}
}