package engine.graphics;

import engine.maths.Vector2f;
import engine.maths.Vector3f;

public class Vertex {
	private Vector3f position, normal;
	private Vector2f textureCoord;
	
	public Vertex(Vector3f position, Vector3f normal, Vector2f textureCoord) {
		this.position = position;
		this.normal = normal;
		this.textureCoord = textureCoord;
	}

	public Vector3f getPosition() {
		return position;
	}
	
	public Vector3f getNormal() {
		return normal;
	}

	public Vector2f getTextureCoord() {
		return textureCoord;
	}
}