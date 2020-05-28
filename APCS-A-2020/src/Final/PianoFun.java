package Final;

import java.awt.Component;

import javax.sound.midi.Synthesizer;
import javax.swing.JFrame;

public class PianoFun extends JFrame implements Runnable {
	private static final int WIDTH = 1500;
	private static final int HEIGHT = 1000;

	private PianoAction g;
	private GameFrame gf;
	private Intro i;
	private volatile boolean go = false;
	private volatile boolean b = false;
	

	public PianoFun() {
		setSize(WIDTH, HEIGHT);
		addIntro();

	}

	public static void main(String[] args) {
		PianoFun play = new PianoFun();

	}

	public void startPlay() {
		g = new PianoAction();
		gf = new GameFrame(this);
		add(gf);
		((Component) g).setFocusable(true);
		getContentPane().add(g);
		setVisible(true);
		new Thread(this).start();

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				g.closeWriter();
			}
		});
	}

	public void addIntro() {
		i = new Intro(this);
		add(i);
		setVisible(true);
		// go = i.getGo();
		while (!go) {
			go = i.getGo();
			if (i.getGo()) {
				remove(i);
				startPlay();
				break;
			}

		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try {
			while (true) {
				Thread.currentThread().sleep(5);
				g.canRecord(gf.isRecording());
				b = gf.canClear();
				if (b) {
					g.canClear();
					gf.stopClear();
				}
				b = gf.playAll();
				if(b) {
					g.playAll();
					gf.donePlayAll();
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}
}
