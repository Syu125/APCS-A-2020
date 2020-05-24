package Final;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import sun.audio.AudioStream;
import sun.audio.AudioPlayer;
import core.main.Main;

public class Key {
	private String key;
	private AudioStream audio;
	
	public Key(String key) {
		this.key = key;
		try {
			audio = new AudioStream(new FileInputStream(new File("src/Final/G/"+key+".wav")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void play() {
		AudioPlayer.player.start(audio);
	}
	public String getKey() {
		return key;
	}
}
