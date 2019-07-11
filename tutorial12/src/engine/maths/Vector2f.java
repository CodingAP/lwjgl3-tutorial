package engine.maths;

public class Vector2f {
	private float x, y;
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public static Vector2f add(Vector2f vector1, Vector2f vector2) {
		return new Vector2f(vector1.getX() + vector2.getX(), vector1.getY() + vector2.getY());
	}
	
	public static Vector2f subtract(Vector2f vector1, Vector2f vector2) {
		return new Vector2f(vector1.getX() - vector2.getX(), vector1.getY() - vector2.getY());
	}
	
	public static Vector2f multiply(Vector2f vector1, Vector2f vector2) {
		return new Vector2f(vector1.getX() * vector2.getX(), vector1.getY() * vector2.getY());
	}
	
	public static Vector2f divide(Vector2f vector1, Vector2f vector2) {
		return new Vector2f(vector1.getX() / vector2.getX(), vector1.getY() / vector2.getY());
	}
	
	public static float length(Vector2f vector) {
		return (float) Math.sqrt(vector.getX() * vector.getX() + vector.getY() * vector.getY());
	}
	
	public static Vector2f normalize(Vector2f vector) {
		float len = Vector2f.length(vector);
		return Vector2f.divide(vector, new Vector2f(len, len));
	}
	
	public static float dot(Vector2f vector1, Vector2f vector2) {
		return vector1.getX() * vector2.getX() + vector1.getY() * vector2.getY();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector2f other = (Vector2f) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		return true;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}