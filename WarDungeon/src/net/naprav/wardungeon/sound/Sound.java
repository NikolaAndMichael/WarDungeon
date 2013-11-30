package net.naprav.wardungeon.sound;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	private static Clip clip;
	private static File file;
	
	public static void pushButtonSound() {
		file = new File("res/noise/sound/select.wav");
		
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(stream);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		if (clip.isActive()) clip.stop();
		
		clip.setFramePosition(0);
		clip.start();
	}
	
	public static void powerUp() {
		file = new File("res/noise/sound/powerup.wav");
		
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(stream);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		if (clip.isActive()) clip.stop();
		
		clip.setFramePosition(0);
		clip.start();
	}
	
	public static void pickUp() {
		file = new File("res/noise/sound/pickup.wav");
		
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(stream);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		if (clip.isActive()) clip.stop();
		
		clip.setFramePosition(0);
		clip.start();
	}
}
