package ie.gmit.dip;

public class KeyHandler {
	//public static final int MIN_KEY_LENGHT = 1;
	//public static final int MAX_KEY_LENGHT = 100; // do i need an offset min/max?
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
	
	/*
	 * This Exception throw an error if the key length is outside the range stated
	 * but the MIN_KEY and MAX_KEY variable up top. The method that calls the
	 * Exception must also must throw the exception method.
	
	private void validateKey(String key) throws Exception {
		if (key == 0 || key.length() > MAX_KEY_LENGHT) {
			throw new Exception("[ERROR} Invalid Cipher Key. Key Lenght must be in the range [" + MIN_KEY_LENGHT
					+ "....." + MAX_KEY_LENGHT + "]");
	*/

}
/*
 * The getters and setters allow for other classes to access and change the
 * private instance variables above. That is: key & offset etc.
 */