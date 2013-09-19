package net.naprav.wardungeon;

import java.io.*;

import javax.swing.JOptionPane;

public class FileManage {

	private String gamePath;
	private String gameLevelPath;
	private String gameBinPath;

	LoginScreen login;

	/**
	 * This constructory creates the main directories used in this game.
	 */
	public FileManage() {
		gamePath = System.getenv("APPDATA") + "/[WarDungeon]";
		gameLevelPath = System.getenv("APPDATA") + "/[WarDungeon]/level";
		gameBinPath = System.getenv("APPDATA") + "/[WarDungeon]/bin";

		File createDir1 = new File(gamePath);
		File createDir2 = new File(gameLevelPath);
		File createDir3 = new File(gameBinPath);

		if (createDir1.exists() != true && createDir2.exists() != true
				&& createDir3.exists() != true) {
			createDir1.mkdir();
			createDir2.mkdir();
			createDir3.mkdir();
		}

		if (createDir1.exists() == true) {
			System.out.println("First directory created!");
		}

		if (createDir2.exists() == true) {
			System.out.println("First directory created!");
		}

		if (createDir3.exists() == true) {
			System.out.println("Third directory created!");
		}

		File termsOfAgreement = new File(gamePath + "/terms.txt");

		try {
			termsOfAgreement.createNewFile();
		} catch (IOException exc) {
			JOptionPane.showMessageDialog(null, "Cannot create files. :(","Alas, something went wrong!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void writeCredentials(LoginScreen login, String fileName) {
		File credit = new File(fileName);
	}
}
