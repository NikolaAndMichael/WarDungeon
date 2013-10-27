package net.naprav.wardungeon.login.file;

public class Server {

	public boolean upToDate;

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
