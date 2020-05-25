package Final;

import java.awt.Component;

import javax.sound.midi.Synthesizer;
import javax.swing.JFrame;

public class PianoFun extends JFrame{
	private static final int WIDTH =  1500;
	private static final int HEIGHT =  1000;
	
	private Intro i;
	private boolean go = false;
	
	public PianoFun() {
		setSize(WIDTH,HEIGHT);
		addIntro();
		
		

	}
public static void main(String[] args) {
	PianoFun play = new PianoFun();
	
}
public void startPlay() {
	PianoAction g = new PianoAction();
	((Component)g).setFocusable(true);
	
	getContentPane().add(g);
	setVisible(true);
	this.addWindowListener(new java.awt.event.WindowAdapter() {
		@Override
	    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			g.closeWriter();
		}
	});
}
public void addIntro() {
	i = new Intro();
	add(i);
	setVisible(true);
	go = i.getGo();
	while(!go) {
		go = i.getGo();
		if(i.getGo()) {
			remove(i);
			startPlay();
			break;
		}

	}
	
}
}
