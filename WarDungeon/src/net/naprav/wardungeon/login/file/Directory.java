package net.naprav.wardungeon.login.file;

import java.io.File;

public class Directory {

	File createDir;
	File createVersionHistory;
	File createBin;
	File createScreenShots;
	File createSaves;

	String user;
	Server server;

	public Directory() {
		user = System.getProperty("user.home");
		server = new Server();

		createDir = new File(user + "\\AppData\\Roaming\\[WarDungeon]");
		createVersionHistory = new File(user + "\\AppData\\Roaming\\[WarDungeon]\\version_history");
		createBin = new File(user + "\\AppData\\Roaming\\[WarDungeon]\\bin");
		createScreenShots = new File(user + "\\AppData\\Roaming\\[WarDungeon]\\screen_shots");
		createSaves = new File(user + "\\AppData\\Roaming\\[WarDungeon]\\saves");
	}

	public void createDirectories() {
		if (!server.checkIsUpToDate() || !createDir.exists() || !createVersionHistory.exists() || !createBin.exists() || !createScreenShots.exists() || !createSaves.exists()) {
			System.out.println("Player is not up to date: adding up all files...");
			System.out.println(server.upToDate);
			
			server.tickUser();
			
			createDir.mkdir();
			createVersionHistory.mkdir();
			createBin.mkdir();
			createScreenShots.mkdir();
			createSaves.mkdir();
			
			server.setIsUpToDate(true);
		} else {
			System.out.println("Player's up to date!");
		}
	}
}
