package ie.gmit.dip;

public class InputHandler {
	private String userText;
	public boolean hasUserText = false;

	public String getUserText() {
		return userText;
	}

	public void setUserText(String userText) {
		this.userText = userText;
		hasUserText = true;
	}

}
