package ie.gmit.dip;

public class InputHandler {
	private String userText; // creates a private class variable that will be user to store text that will be
								// passed to railfence.

	public String getUserText() { // methods will call getUserTest to acquire text passed in by user of file.
		return userText;
	}

	public void setUserText(String userText) { // this will set userText to what ever is passed in by user
		this.userText = userText;
	}

	public char[] getCharArrayFromInput() { // when call by other class methods, text stored in userText will be passed
											// into a Char array in either the railfence class encrypt or decrypt
											// methods
		userText.toCharArray();
		return userText.toCharArray();

	}
}
