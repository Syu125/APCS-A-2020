package Pong;

public class Wall extends Block {
	public Wall() {
		super();
	}

	public Wall(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public boolean wallCollide(Ball b) {
		if(b.getxPos() >= getxPos() &&
				b.getxPos()+b.getWidth() <= getxPos() + getWidth() &&
				b.getyPos() >= getyPos() &&
				b.getxPos()+b.getHeight() <= getyPos() + getHeight()) {
			return true;
		}
		return false;
	}

}
