package net.naprav.wardungeon.login;

import java.awt.Desktop;
import java.net.URI;

public class Register {

	final String URL;
	URI URI;
	Desktop desktop;
	
	public Register(String url) {
		URL = url;
	}
	
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
