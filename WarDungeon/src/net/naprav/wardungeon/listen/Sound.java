package net.naprav.wardungeon.listen;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	private Clip clip;

	public Sound(String filepath) {
		File file = new File(filepath);
		try {
			clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
			clip.open(inputStream);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void playSound() {
		if (clip.isActive()) clip.stop();
		
		clip.setFramePosition(0);
		clip.start();
	}

	public void stopSound() {
		clip.stop();
	}
}
