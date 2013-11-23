package net.naprav.wardungeon.sound;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {

	private static Clip clip;
	private static File file;

	public static void playTitleMusic() {
		file = new File("res/noise/music/menu.wav");

		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(stream);
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		int loops = 10000000;

		clip.setFramePosition(0);
		clip.loop(loops);
	}

	public static void stopTitleMusic() {
		clip.close();
	}
}
