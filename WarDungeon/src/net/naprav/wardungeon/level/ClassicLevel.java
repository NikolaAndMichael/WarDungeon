package net.naprav.wardungeon.level;

public class ClassicLevel extends LevelTemplate {

	public ClassicLevel(String pathway) {
		super(pathway);
	}
	
	public static ClassicLevel level = new ClassicLevel("/level/classic_level.png");
}
