package net.naprav.wardungeon.sound;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {

	private Clip clip;
	
	public Music(String filepath) {
		File file = new File(filepath);
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(stream);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public void playMusic() {
		int loops = 10000000;
		
		clip.setFramePosition(0);
		clip.loop(loops);
	}
	
	public void stopMusic() {
		if (clip.isActive()) clip.stop();
	}
}
