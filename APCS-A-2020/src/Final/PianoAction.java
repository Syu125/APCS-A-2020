package Final;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

public class PianoAction extends Canvas implements KeyListener, Runnable {
	private Key[] whiteKeys;
	private Key[] blackKeys;
	private Key[] pianoKeys;

	private int whiteCount;
	private int gap;

	private Scanner scanner;
	private FileWriter fileWriter;
	private BufferedImage back;
	private final String[] keyboard = { "a" };

	public PianoAction() {
		setBackground(Color.WHITE);
		whiteKeys = new Key[8];
		blackKeys = new Key[5];
		pianoKeys = new Key[13];
		whiteCount = 0;
		gap = getWidth() / 15;

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

	public void paint(Graphics window) {
		Graphics2D twoDGraph = (Graphics2D) window;
		if (back == null)
			back = (BufferedImage) (createImage(getWidth(), getHeight()));

		Graphics prev = back.createGraphics();

		int increment = 0;

		prev.setColor(Color.WHITE);
		/*
		 * for(int i = 0; i < whiteKeys.length; i++) { prev.setColor(Color.BLACK);
		 * prev.drawRect(i*getWidth()/7, (int)(getHeight()*0.5), getWidth()/7,
		 * (int)(getHeight()*0.5)); } for (int i = 0; i < blackKeys.length; i++) {
		 * prev.fillRect(getWidth()/11 + i*getWidth()/7, (int)(getHeight()*0.5),
		 * getWidth()/9, (int)(getHeight()*0.4)); }
		 */
		prev.setColor(Color.BLACK);
		/*
		 * for (int i = 0; i < pianoKeys.length; i++) {
		 * if(pianoKeys[i].getKey().length()==1) { if(i !=0 && i!= pianoKeys.length-1 &&
		 * pianoKeys[i-1].getKey().length()==1) prev.drawRect(whiteCount*getWidth()/7,
		 * (int)(getHeight()*0.5), getWidth()/7, (int)(getHeight()*0.5)); else
		 * prev.drawRect(whiteCount*getWidth()/7, (int)(getHeight()*0.5), getWidth()/7,
		 * (int)(getHeight()*0.5)); whiteCount++; }else
		 * if(pianoKeys[i].getKey().length()==2){ if(i%2==0)
		 * prev.fillRect((i+1)*getWidth()/13,(int)(getHeight()*0.5), getWidth()/9,
		 * (int)(getHeight()*0.4)); else
		 * prev.fillRect((i+2)*getWidth()/13,(int)(getHeight()*0.5), getWidth()/9,
		 * (int)(getHeight()*0.4));
		 * 
		 * 
		 * } }
		 */
		for (int i = 0; i < pianoKeys.length; i++) {
			if (pianoKeys[i].getKey().length() == 1) {
				if (i != 0 && i != pianoKeys.length - 1 && pianoKeys[i - 1].getKey().length() == 1) {
					increment += getWidth() / 15;
					prev.drawRect(increment, (int) (getHeight() * 0.5), (int)(getWidth() / 7.5), (int) (getHeight() * 0.5));
				} else {
					prev.drawRect(increment, (int) (getHeight() * 0.5), (int)(getWidth() / 7.5),
							(int) (getHeight() * 0.5));
					whiteCount++;
				}
			} else if (pianoKeys[i].getKey().length() == 2) {

					prev.fillRect(increment+25, (int) (getHeight() * 0.5), getWidth() / 10,
							(int) (getHeight() * 0.4));

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
		switch(e.getKeyCode()) {
		case(KeyEvent.VK_A):
			pianoKeys[0].play();
			writeToFile(pianoKeys[0].getKey());
			break;
		case(KeyEvent.VK_W):
			pianoKeys[1].play();
		writeToFile(pianoKeys[1].getKey());
			break;
		case(KeyEvent.VK_S):
			pianoKeys[2].play();
		writeToFile(pianoKeys[2].getKey());
			break;
		case(KeyEvent.VK_D):
			pianoKeys[3].play();
		writeToFile(pianoKeys[3].getKey());
			break;
		case(KeyEvent.VK_R):
			pianoKeys[4].play();
		writeToFile(pianoKeys[4].getKey());
			break;
		case(KeyEvent.VK_F):
			pianoKeys[5].play();
		writeToFile(pianoKeys[5].getKey());
			break;
		case(KeyEvent.VK_T):
			pianoKeys[6].play();
		writeToFile(pianoKeys[6].getKey());
			break;
		case(KeyEvent.VK_G):
			pianoKeys[7].play();
		writeToFile(pianoKeys[7].getKey());
			break;
		case(KeyEvent.VK_H):
			pianoKeys[8].play();
		writeToFile(pianoKeys[8].getKey());
			break;
		case(KeyEvent.VK_U):
			pianoKeys[9].play();
		writeToFile(pianoKeys[9].getKey());
			break;
		case(KeyEvent.VK_J):
			pianoKeys[10].play();
		writeToFile(pianoKeys[10].getKey());
			break;
		case(KeyEvent.VK_I):
			pianoKeys[11].play();
		writeToFile(pianoKeys[11].getKey());
			break;
		case(KeyEvent.VK_K):
			pianoKeys[12].play();
		writeToFile(pianoKeys[12].getKey());
			break;
		
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

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
			fileWriter.write(s+"\n");
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
