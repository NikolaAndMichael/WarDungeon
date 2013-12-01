package net.naprav.wardungeon.login.file;

public class Server {

	public boolean upToDate;
	
	public static String credits = "\"WarDungeon\" is a game created by one Nikola \"Gumptastic\" Grgic";
	public static String credits_2 = "for Naprav Specifications in 2013. His major inspiration comes from";
	public static String credits_3 = "a game called \"Hammerwatch\" ©Jochum Skoglund and Niklas Myrberg";
	public static String credits_4 = "2013, with a bit more from \"Realm of the Mad God\" ©Wild Shadow ";
	public static String credits_5 = "Studios. He hates endings to games and has vowedto releasing a new";
	public static String credits_6 = "level every 2 weeks, until the final release of the game comes around.";
	public static String credits_7 = "Though he is a bit noobish in game creation, he is eagerly open to";
	public static String credits_8 = "learning more to help the entertainment of the public. :)";

	/**
	 * Main constructor for the server.
	 */
	public Server() {

	}

	/**
	 * Setting if the user is up to date.
	 * 
	 * @param toDate
	 */
	public void setIsUpToDate(boolean toDate) {
		upToDate = toDate;
	}

	/**
	 * Checking to see if the user if up to date or not.
	 * 
	 * @return
	 */
	public boolean checkIsUpToDate() {
		return upToDate;
	}

	/**
	 * Gets files from the server for the user.
	 */
	public void getFiles() {

	}

	/**
	 * Updates the user's directories and files.
	 */
	public void tickUser() {

	}
}
