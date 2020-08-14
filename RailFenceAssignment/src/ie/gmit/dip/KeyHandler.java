package ie.gmit.dip;

public class KeyHandler {
	private int key;
	private int offset;
	// Two new variable created to hold the RailFence key and offset.

	public int getKey() {
		return this.key; // getKey will allow other class method to access the newly assigned private key
							// variable.
	}

	public void setKey(int key) {
		this.key = key; // this.key takes the input from user and assigns it to the private key
						// variable.
	}

	public int getOffset() {
		return this.offset; // getOffset will allow other class method to access the newly assigned private
							// offset variable.
	}

	public void setOffset(int offset) {
		this.offset = offset; // this.offset takes the input from user and assigns it to the private offset
								// variable.
	}

}
/*
 * The getters and setters allow for other classes to access and change the
 * private instance variables above. That is: key & offset etc.
 */