package Final;

import java.awt.Component;

import javax.swing.JFrame;

public class PianoFun extends JFrame{
	private static final int WIDTH =  1500;
	private static final int HEIGHT =  1000;
	
	public PianoFun() {
		setSize(WIDTH,HEIGHT);
		PianoAction g = new PianoAction();
		((Component)g).setFocusable(true);
		
		getContentPane().add(g);
		setVisible(true);
	}
public static void main(String[] args) {
	PianoFun play = new PianoFun();
}
}
