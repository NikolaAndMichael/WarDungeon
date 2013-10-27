package net.naprav.wardungeon.login;

import java.awt.Desktop;
import java.net.URI;

public class Register {

	final String URL;
	URI URI;
	Desktop desktop;
	
	/**
	 * Constructor for sending the user to register themselves.
	 * @param url
	 */
	public Register(String url) {
		URL = url;
	}
	
	/**
	 * Method for opening the default browser on the user's desktop and sending them to create a Naprav account.
	 */
	public void registerAccount() {
		try {
			desktop = Desktop.getDesktop();
			URI = new URI(URL);
			desktop.browse(URI.resolve(URL));
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
}
