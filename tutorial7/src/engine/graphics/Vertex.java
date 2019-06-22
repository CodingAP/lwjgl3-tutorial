package engine.graphics;

import engine.maths.Vector3f;

public class Vertex {
	private Vector3f position, color;
	
	public Vertex(Vector3f position, Vector3f color) {
		this.position = position;
		this.color = color;
	}

	public Vector3f getPosition() {
		return position;
	}
	
	public Vector3f getColor() {
		return color;
	}
}