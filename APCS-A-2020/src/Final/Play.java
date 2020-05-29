package Final;

import java.awt.Canvas;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Play {
	private ArrayList <Key> keys;
	private Key [] origin;
	
	public Play() {

	}

	public Play(Key[] notes, Key [] orig) {
		keys = new ArrayList<>();
		origin =  new Key[orig.length];
		for (int i = 0; i < notes.length; i++) {
			keys.add(notes[i]);
		}	
		for (int i = 0; i < orig.length; i++) {
			origin[i] = orig[i];
		}
	}

	public void playAllNotes() throws InterruptedException {
		for (Key key : keys) {
			for(Key k: origin) {
				if(key.getKey().equals(k.getKey())) {
					k.play();
					TimeUnit.MILLISECONDS.sleep(200);
			}

		}
	}
	}

	public void playAllNotes(Key[] notes) throws InterruptedException {
		for (Key key : notes) {
			key.play();
			TimeUnit.MILLISECONDS.sleep(200);

		}
	}
	public void addNote(Key note) {
		keys.add(note);
	}
	

}
