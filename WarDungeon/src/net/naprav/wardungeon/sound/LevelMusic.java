package net.naprav.wardungeon.sound;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public abstract class LevelMusic {

	protected Clip clip;

	public LevelMusic(String filepath) throws Exception {
		File file = new File(filepath);
		AudioInputStream stream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(stream);
	}

	public abstract void playMusic();

	public abstract void stopMusic();
}
