package Final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Intro extends JPanel implements ActionListener {
	private JButton b;
	private boolean run = false;

	public Intro() {
		b = new JButton();
		b.setText("hi");
		b.addActionListener(this);
		this.add(b);
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

	

}
