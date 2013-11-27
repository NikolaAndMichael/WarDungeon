package net.naprav.wardungeon.login.file;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Directory {

	File createDir;
	File createVersionHistory;
	File createBin;
	File createScreenShots;
	File createSaves;

	String user;
	Server server;

	/**
	 * Main constructor for setting up the directories on the user's computer.
	 */
	public Directory() {
		user = System.getProperty("user.home");
		server = new Server();

		createDir = new File(user + "\\AppData\\Roaming\\[WarDungeon]");
		createVersionHistory = new File(user + "\\AppData\\Roaming\\[WarDungeon]\\version_history");
		createBin = new File(user + "\\AppData\\Roaming\\[WarDungeon]\\bin");
		createScreenShots = new File(user + "\\AppData\\Roaming\\[WarDungeon]\\screen_shots");
		createSaves = new File(user + "\\AppData\\Roaming\\[WarDungeon]\\saves");
	}

	/**
	 * Method for creating the directories and checking if the user is up to date.
	 */
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

	public static String getTime() {
		Date current = new Date();
		Locale locale = new Locale("en", "US");

		DateFormat formatTime = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
		String date = formatTime.format(current);

		return date;
	}
}
