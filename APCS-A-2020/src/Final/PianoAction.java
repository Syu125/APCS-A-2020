package Final;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

public class PianoAction extends Canvas implements KeyListener, Runnable{
	private Key[]whiteKeys;
	private Key[]blackKeys;
	private Key[]pianoKeys;
	
	private int whiteCount;
	private int gap;
	
	private Scanner scanner;
	private BufferedImage back;
	private final String [] keyboard = {"a"};

public PianoAction() {
	setBackground(Color.WHITE);
	whiteKeys = new Key[7];
	blackKeys = new Key[5];
	pianoKeys = new Key[12];
	whiteCount = 0;
	gap = getWidth()/14;

	try {
		scanner = new Scanner(new File("src/Final/G/PianoWhiteKeys.txt"));
		for(Key k: whiteKeys) {
			k =  new Key(scanner.next());
		}
		scanner = new Scanner(new File("src/Final/G/PianoBlackKeys.txt"));
		for(Key k: blackKeys) {
			k =  new Key(scanner.next());
		}
		scanner = new Scanner(new File("src/Final/G/PianoKeys.txt"));
		for(int i = 0; i < pianoKeys.length;  i++) {
			pianoKeys[i] =  new Key(scanner.next());
		}
	}catch(IOException e) {
		//e.printStackTrace();
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
	
	prev.setColor(Color.WHITE);
	/*for(int i = 0; i < whiteKeys.length; i++) {
		prev.setColor(Color.BLACK);
		prev.drawRect(i*getWidth()/7, (int)(getHeight()*0.5), getWidth()/7, (int)(getHeight()*0.5));
	}
	for (int i = 0; i < blackKeys.length; i++) {
		prev.fillRect(getWidth()/11 + i*getWidth()/7, (int)(getHeight()*0.5), getWidth()/9, (int)(getHeight()*0.4));
	}*/
	prev.setColor(Color.BLACK);
	for (int i = 0; i < pianoKeys.length; i++) {
		if(pianoKeys[i].getKey().length()==1) {
			if(i !=0 && i!= pianoKeys.length-1 && pianoKeys[i-1].getKey().length()==1)
				prev.drawRect(i*getWidth()/7, (int)(getHeight()*0.5), getWidth()/7, (int)(getHeight()*0.5));
			else
				prev.drawRect(i*getWidth()/7, (int)(getHeight()*0.5), getWidth()/7, (int)(getHeight()*0.5));
			whiteCount++;
		}else if(pianoKeys[i].getKey().length()==2){
		
					prev.fillRect(i*getWidth()/14,(int)(getHeight()*0.5), getWidth()/9, (int)(getHeight()*0.4));

		
		}
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
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void run() {
	// TODO Auto-generated method stub
	try {
		while(true) {
			Thread.currentThread().sleep(5);
			repaint();
		}
	} catch(Exception e) {
		//e.printStackTrace();
	}
}
}
