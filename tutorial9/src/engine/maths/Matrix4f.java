package engine.maths;

public class Matrix4f {
	public static final int SIZE = 4;
	private float[] elements;
	
	public float get(int x, int y) {
		return elements[y * SIZE + x];
	}
	
	public void set(int x, int y, float value) {
		elements[y * SIZE + x] = value;
	}
	
	public float[] getAll() {
		return elements;
	}
}