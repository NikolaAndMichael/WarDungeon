package net.naprav.wardungeon.gui;

public class MessageWindow extends GUI_Scheme {

	public static int height;
	public static int width;

	public MessageWindow() {
		System.out.println("Message window is working just fine.");
	}

	public void sendDeathMessage(String message) {
		this.sendMessage(message);
	}

	public void sendMessage(String message) {
		System.out.println(message);
	}
}