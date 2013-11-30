package net.naprav.wardungeon.login;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.naprav.wardungeon.WarDungeon;

public class LoginGame {

	public static String username;
	
	/**
	 * Method for attempting login into the game.
	 * 
	 * @param username
	 * @param passcode
	 * @param frame
	 */
	public void attemptLogin(String user, String passcode, JFrame frame) {
		username = user;
		
		if (username.equals("") || passcode.equals("")) {
			JOptionPane.showMessageDialog(null, "Put in your credentials!", "Hey you!", JOptionPane.ERROR_MESSAGE);
		} else {
			System.out.println(username);
			System.out.println(passcode);
			frame.dispose();
			
			try {
				Thread.sleep(700);
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
			
			WarDungeon dungeon = new WarDungeon();
			dungeon.begin();
			dungeon.requestFocus();
		}
	}
	
	public static String getUsername() {
		if (username == null) {
			username = "Legit Name. :P";
		} 
			
		return username;
	}
}
