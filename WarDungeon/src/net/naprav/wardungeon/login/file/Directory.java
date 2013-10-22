package net.naprav.wardungeon.login.file;

import java.io.File;

public class Directory {

	File createDir;
	File createVersionHistory;
	File createBin;
	File createScreenShots;

	String user;

	public Directory() {
		user = System.getProperty("user.home");
		
		createDir = new File(user + "\\AppData\\Roaming\\[WarDungeon]");
		createVersionHistory = new File(user + "\\AppData\\Roaming\\[WarDungeon]\\version_history");
		createBin = new File(user + "\\AppData\\Roaming\\[WarDungeon]\\bin");
		createScreenShots = new File(user + "\\AppData\\Roaming\\[WarDungeon]\\screen_shots");
	}

	public void createDirectories() {
		// Adjust code for potential modding API in future.
		createDir.mkdir();
		createVersionHistory.mkdir();
		createBin.mkdir();
		createScreenShots.mkdir();
	}
}
