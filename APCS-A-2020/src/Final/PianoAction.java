package Final;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PianoAction extends Canvas implements KeyListener, Runnable{
	private WhiteKey[] whiteKeys;
	private BlackKey[] blackKeys;
	private Key[] pianoKeys;

	private volatile boolean paRecording;

	private String key;

	private int whiteCount;
	private int gap;

	private Scanner scanner;
	private FileWriter fileWriter;
	private BufferedImage back;
	private final String[] keyboard = { "A", "W", "S", "D", "R", "F", "T", "G", "H", "U", "J", "I", "K" };

	private final boolean[] keyColor = new boolean[13];

	public PianoAction() {
		setBackground(Color.WHITE);
		whiteKeys = new WhiteKey[8];
		blackKeys = new BlackKey[5];
		pianoKeys = new Key[13];

		paRecording = false;

		whiteCount = 0;
		gap = getWidth() / 15;
		key = "";

		for (int i = 0; i < keyColor.length; i++) {
			keyColor[i] = false;
		}

		try {
			fileWriter = new FileWriter("src/Final/MusicSheet.txt");

			scanner = new Scanner(new File("src/Final/G/PianoKeys.txt"));
			for (int i = 0; i < pianoKeys.length; i++) {
				pianoKeys[i] = new Key(scanner.next());
			}
		} catch (IOException e) {
			// e.printStackTrace();
		}
		this.addKeyListener(this);
		new Thread(this).start();
		setVisible(true);

	}

	public void update(Graphics window) {
		paint(window);
	}

	public void canRecord(boolean b) {
		paRecording = b;
	}

	public void canClear() {

		try {
			fileWriter = new FileWriter("src/Final/MusicSheet.txt", false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void playAll() {
		try {
			String s = "";
			scanner = new Scanner(new File("src/Final/MusicSheet.txt"));
			while(scanner.hasNext()) {
				s = scanner.next();
				for (Key key : pianoKeys) {
					if(key.getKey().equals(s)) {
						key.play();
						TimeUnit.MILLISECONDS.sleep(200);
					}
				}
			}
		} catch (FileNotFoundException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void paint(Graphics window) {
		Graphics2D twoDGraph = (Graphics2D) window;
		if (back == null)
			back = (BufferedImage) (createImage(getWidth(), getHeight()));

		Graphics prev = back.createGraphics();

		int increment = 0;

		prev.setColor(Color.BLACK);
		prev.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		for (int i = 0; i < pianoKeys.length; i++) {
			prev.setColor(Color.BLACK);
			if (pianoKeys[i].getKey().length() == 1) {
				if (i != 0 && i != pianoKeys.length - 1 && pianoKeys[i - 1].getKey().length() == 1) {
					if (keyColor[i]) {
						prev.setColor(Color.GRAY);
						increment += getWidth() / 15;
						prev.fillRect(increment, (int) (getHeight() * 0.5), (int) (getWidth() / 7.5),
								(int) (getHeight() * 0.5));
					} else {
						increment += getWidth() / 15;
						prev.setColor(Color.WHITE);
						prev.fillRect(increment, (int) (getHeight() * 0.5), (int) (getWidth() / 7.5),
								(int) (getHeight() * 0.5));
						prev.setColor(Color.BLACK);
						prev.drawRect(increment, (int) (getHeight() * 0.5), (int) (getWidth() / 7.5),
								(int) (getHeight() * 0.5));
						prev.drawString(keyboard[i], increment + getWidth() / 15, (int) (getHeight()) - 10);
					}
				} else {
					if (keyColor[i]) {
						prev.setColor(Color.GRAY);
						prev.fillRect(increment, (int) (getHeight() * 0.5), (int) (getWidth() / 7.5),
								(int) (getHeight() * 0.5));
					} else {
						prev.setColor(Color.BLACK);
						prev.setColor(Color.WHITE);
						prev.fillRect(increment, (int) (getHeight() * 0.5), (int) (getWidth() / 7.5),
								(int) (getHeight() * 0.5));
						prev.setColor(Color.BLACK);
						prev.drawRect(increment, (int) (getHeight() * 0.5), (int) (getWidth() / 7.5),
								(int) (getHeight() * 0.5));
						prev.drawString(keyboard[i], increment + getWidth() / 15, (int) (getHeight()) - 10);
					}

					whiteCount++;
				}
			}
			increment += getWidth() / 15;

		}
		increment = 0;
		for (int i = 0; i < pianoKeys.length; i++) {
			if (pianoKeys[i].getKey().length() == 1 && i != 0 && i != pianoKeys.length - 1
					&& pianoKeys[i - 1].getKey().length() == 1) {
				increment += getWidth() / 15;
			}

			if (pianoKeys[i].getKey().length() == 2) {
				if (keyColor[i]) {
					prev.setColor(Color.GRAY);
					prev.fillRect(increment + 25, (int) (getHeight() * 0.5), getWidth() / 10,
							(int) (getHeight() * 0.4));
				} else {
					prev.setColor(Color.BLACK);
					prev.fillRect(increment + 25, (int) (getHeight() * 0.5), getWidth() / 10,
							(int) (getHeight() * 0.4));
					prev.setColor(Color.WHITE);
					prev.drawString(keyboard[i], increment + getWidth() / 15, (int) (getHeight() * 0.9) - 10);
				}
			}
			increment += getWidth() / 15;
		}
		twoDGraph.drawImage(back, null, 0, 0);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case (KeyEvent.VK_A):
			keyColor[0] = true;
			pianoKeys[0].play();
			writeToFile(pianoKeys[0].getKey());
			break;
		case (KeyEvent.VK_W):
			keyColor[1] = true;
			pianoKeys[1].play();
			writeToFile(pianoKeys[1].getKey());
			break;
		case (KeyEvent.VK_S):
			keyColor[2] = true;
			pianoKeys[2].play();
			writeToFile(pianoKeys[2].getKey());
			break;
		case (KeyEvent.VK_D):
			keyColor[3] = true;
			pianoKeys[3].play();
			writeToFile(pianoKeys[3].getKey());
			break;
		case (KeyEvent.VK_R):
			keyColor[4] = true;
			pianoKeys[4].play();
			writeToFile(pianoKeys[4].getKey());
			break;
		case (KeyEvent.VK_F):
			keyColor[5] = true;
			pianoKeys[5].play();
			writeToFile(pianoKeys[5].getKey());
			break;
		case (KeyEvent.VK_T):
			keyColor[6] = true;
			pianoKeys[6].play();
			writeToFile(pianoKeys[6].getKey());
			break;
		case (KeyEvent.VK_G):
			keyColor[7] = true;
			pianoKeys[7].play();
			writeToFile(pianoKeys[7].getKey());
			break;
		case (KeyEvent.VK_H):
			keyColor[8] = true;
			pianoKeys[8].play();
			writeToFile(pianoKeys[8].getKey());
			break;
		case (KeyEvent.VK_U):
			keyColor[9] = true;
			pianoKeys[9].play();
			writeToFile(pianoKeys[9].getKey());
			break;
		case (KeyEvent.VK_J):
			keyColor[10] = true;
			pianoKeys[10].play();
			writeToFile(pianoKeys[10].getKey());
			break;
		case (KeyEvent.VK_I):
			keyColor[11] = true;
			pianoKeys[11].play();
			writeToFile(pianoKeys[11].getKey());
			break;
		case (KeyEvent.VK_K):
			keyColor[12] = true;
			pianoKeys[12].play();
			writeToFile(pianoKeys[12].getKey());
			break;

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case (KeyEvent.VK_A):
			keyColor[0] = false;
			break;
		case (KeyEvent.VK_W):
			keyColor[1] = false;
			break;
		case (KeyEvent.VK_S):
			keyColor[2] = false;
			break;
		case (KeyEvent.VK_D):
			keyColor[3] = false;
			break;
		case (KeyEvent.VK_R):
			keyColor[4] = false;
			break;
		case (KeyEvent.VK_F):
			keyColor[5] = false;
			break;
		case (KeyEvent.VK_T):
			keyColor[6] = false;
			break;
		case (KeyEvent.VK_G):
			keyColor[7] = false;
			break;
		case (KeyEvent.VK_H):
			keyColor[8] = false;
			break;
		case (KeyEvent.VK_U):
			keyColor[9] = false;
			break;
		case (KeyEvent.VK_J):
			keyColor[10] = false;
			break;
		case (KeyEvent.VK_I):
			keyColor[11] = false;
			break;
		case (KeyEvent.VK_K):
			keyColor[12] = false;
			break;

		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				Thread.currentThread().sleep(5);
				repaint();
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public void writeToFile(String s) {
		try {
			if (paRecording) {
				fileWriter = new FileWriter("src/Final/MusicSheet.txt", true);
				fileWriter.write(s + "\n");

			}
			fileWriter.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void closeWriter() {
		try {
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
