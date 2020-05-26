package Final;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Intro extends JPanel implements ActionListener {
	private SpringLayout springLayout;
	private JLabel title;
	private JLabel instructions;
	private JButton b;
	private JLabel image;
	private boolean run = false;

	public Intro(PianoFun controller) {
		super();
		this.setSize(1500, 1000);
		this.springLayout = new SpringLayout();
		this.title = new JLabel("Piano Fun");
		this.b = new JButton("Play");
		this.image = new JLabel();
		this.instructions = new JLabel("This is an interactive program that allows you to record your own piano pieces and play them back", JLabel.CENTER);
		
		panelSetUp();
		layoutSetUp();
		listenerSetUp();
	}
	public boolean getGo() {
		//System.out.println();
		return run;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(b)) {
			run = true;
		}
	}
	public void panelSetUp() {
		ImageIcon imageIcon = new ImageIcon("src/Final/demo.PNG"); // load the image to a imageIcon
		Image pic = imageIcon.getImage(); // transform it 
		Image newimg = pic.getScaledInstance((int)(getWidth()*0.8),  (int)(getHeight()*0.5),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
	
		this.setLayout(springLayout);	
		this.add(title);
		this.add(b);
		this.add(instructions);
		this.add(image);
		
		b.setPreferredSize(new Dimension(getWidth()/5, getHeight()/10));
		b.setBackground(Color.WHITE);
		b.setFont(new Font("Serif", Font.PLAIN, 40));
		b.setFocusPainted(false);
		title.setFont(new Font("Serif", Font.PLAIN, 50));
		title.setSize(getWidth()/10, getHeight()/10);
		instructions.setFont(new Font("Serif", Font.PLAIN, 30));
		instructions.setSize(getWidth()-getWidth()/8, getHeight()/10);
		image.setIcon(imageIcon);
	}
	public void layoutSetUp() {
		springLayout.putConstraint(SpringLayout.NORTH, b, 20, SpringLayout.SOUTH, title);
		springLayout.putConstraint(SpringLayout.WEST, title, getWidth()/2-title.getWidth()/2, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.WEST, instructions, getWidth()/2-instructions.getWidth()/2+50, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, instructions, 50, SpringLayout.SOUTH, title);
		springLayout.putConstraint(SpringLayout.NORTH, image, 80, SpringLayout.SOUTH, instructions);
		springLayout.putConstraint(SpringLayout.WEST, image, getWidth()/10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, b, 80, SpringLayout.SOUTH, image);
		springLayout.putConstraint(SpringLayout.WEST, b, getWidth()/5*2, SpringLayout.WEST, this);
	}

	public void listenerSetUp() {
		b.addActionListener(this);

	}

}
