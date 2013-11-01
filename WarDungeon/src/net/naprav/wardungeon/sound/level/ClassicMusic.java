package net.naprav.wardungeon.sound.level;

import net.naprav.wardungeon.sound.LevelMusic;

public class ClassicMusic extends LevelMusic {

	public ClassicMusic(String filepath) throws Exception {
		super(filepath);
	}

	public void playMusic() {
		clip.setFramePosition(0);
		clip.loop(10000000);
	}

	public void stopMusic() {
		if (clip.isActive()) clip.stop();
	}
}
