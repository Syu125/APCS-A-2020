package Final;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class GameFrame extends JPanel implements ActionListener {
	private SpringLayout springLayout;
	private JButton record;
	private JButton clear;
	private JButton play;
	
	private boolean recording;
	private boolean canClear;
	private boolean playAll;

	public GameFrame(PianoFun controller) {
		this.setSize(800, 500);
		this.springLayout = new SpringLayout();
		this.record = new JButton();
		this.clear = new JButton();
		this.play = new JButton();

		panelSetUp();
		layoutSetUp();
		listenerSetUp();
	}


	public void panelSetUp() {
		this.setLayout(springLayout);
		this.add(record);
		this.add(clear);
		this.add(play);
		this.setBackground(Color.BLACK);
		this.setBounds(50, 50, 500, 300);

		record.setPreferredSize(new Dimension(300,50));
		record.setFont(new Font("Serif", Font.PLAIN, 30));
		record.setBackground(Color.WHITE);
		record.setBorderPainted(false);
		record.setText("RECORD");
		
		clear.setPreferredSize(new Dimension(300,50));
		clear.setFont(new Font("Serif", Font.PLAIN, 30));
		clear.setBackground(Color.WHITE);
		clear.setBorderPainted(false);
		clear.setText("CLEAR");
		
		play.setPreferredSize(new Dimension(300,50));
		play.setFont(new Font("Serif", Font.PLAIN, 30));
		play.setBackground(Color.WHITE);
		play.setBorderPainted(false);
		play.setText("PLAY");
		
		recording = false;
		canClear = false;
		playAll = false;
		this.setVisible(true);

	}

	public void layoutSetUp() {
		springLayout.putConstraint(SpringLayout.NORTH, record, 50, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, record, 50, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, clear, 80, SpringLayout.NORTH, record);
		springLayout.putConstraint(SpringLayout.WEST, clear, 50, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, play, 80, SpringLayout.NORTH, clear);
		springLayout.putConstraint(SpringLayout.WEST, play, 50, SpringLayout.WEST, this);
	}

	public void listenerSetUp() {
		record.addActionListener(this);
		clear.addActionListener(this);
		play.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(record)) {
			if(recording) {
				recording = false;
				record.setForeground(Color.BLACK);
				record.setText("RECORD");
			}
			else {
				recording = true;
				record.setForeground(Color.RED);
				record.setText("RECORDING");
			}
				
		}
		if(e.getSource().equals(clear)) {
			canClear = true;
		}
		if(e.getSource().equals(play)) {
			playAll = true;
		}
	}
	public boolean isRecording() {
		return recording;
	}
	public boolean canClear() {
		return canClear;
	}
	public boolean playAll() {
		return playAll;
	}
	public void stopClear() {
		canClear =  false;
	}
	public void donePlayAll() {
		playAll = false;
	}
}
