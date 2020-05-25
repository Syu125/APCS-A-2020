package Final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Intro extends JPanel implements ActionListener {
	private JButton b;
	private boolean go = false;

	public Intro() {
		b = new JButton();
		b.setText("hi");
		b.addActionListener(this);
		this.add(b);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(b)) {
			System.out.println("perf");
			go = true;
		}
	}

	public boolean getGo() {
		//System.out.println();
		return go;
	}

}
