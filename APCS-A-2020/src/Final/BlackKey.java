package Final;

import java.awt.Color;

public class BlackKey extends Key{
	private final Color color = Color.BLACK;

	public BlackKey(String key) {
		super(key);
		// TODO Auto-generated constructor stub
	}
	public Color getColor() {
		return color;
	}
	public Color pressColor() {
		return Color.GRAY;
	}

}
