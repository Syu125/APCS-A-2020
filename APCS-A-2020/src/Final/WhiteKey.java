package Final;

import java.awt.Color;

public class WhiteKey extends Key{
	private final Color color = Color.WHITE;
	public WhiteKey(String key) {
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
