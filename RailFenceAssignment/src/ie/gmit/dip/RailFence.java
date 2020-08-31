package ie.gmit.dip;

public class RailFence {
	private char[][] matrix = null;
	private int offset;

	// private void keyCheck() { //checks to see if key and offset have been entered
	// and are correct
	/*
	 * This Exception throw an error if the key length is outside the range stated
	 * but the MIN_KEY and MAX_KEY variable up top. The method that calls the
	 * Exception must also must throw the exception method.
	 * 
	 * private void validateKey(String key) throws Exception { //checkBounds(key);
	 * if (key == null || key.length() < MIN_KEY_LENGHT || key.length() >
	 * MAX_KEY_LENGHT) { throw new
	 * Exception("[ERROR} Invalid Cipher Key. Key Length must be in the range [" +
	 * MIN_KEY_LENGHT + "....." + MAX_KEY_LENGHT + "]");
	 */

	public void encryptText(int key, int offset, char[] textToRailFence) { //changed Charr array name from TextToBeEncrypted.
		int col = textToRailFence.length; // column length is the size of char array.
		matrix = new char[key][col];// we create a matrix of a of col * row size

		boolean checkDown = false; // check whether it is moving downward or upward, True = Downwards, False =
									// Upwards

		for (int i = 0; i < col; i++) { // matrix visiting row in order to put the character of plaintext in

			if (offset == 0 || offset == key - 1)
				checkDown = !checkDown;

			matrix[offset][i] = textToRailFence[i];

			if (checkDown) {

				offset++;
			} else
				offset--;
		}

		// visiting the matrix in usual order to get ciphertext
		for (int i = 0; i < col; i++) {
			for (int k = 0; k < col; k++) {
				System.out.print(matrix[i][k] + "  ");
			}
			System.out.println();
		}
		String encryptedText = "";

		System.out.println("----------------------");
		for (int i = 0; i < col; i++) {
			for (int k = 0; k < key; k++) {
				if (matrix[i][k] != 0)
					encryptedText = encryptedText + matrix[i][k];

			}

		}
		System.out.println(encryptedText);
	}
	// filewrite should create encrypted file here.

//*******Taken from : https://ghimireshankarpost.blogspot.com/2017/04/rail-fence-cipher-java-implementation.html****

	/*
	 * private String decryptText(String , int key) { return null; /* Note that the
	 * distance between the characters on each row can be computed as d = 2 * (k –
	 * row) – 2, where k is the size of the key and row is the array index of a row
	 * in the range [0…k – 1]. It is possible to implement the Rail Fence cipher
	 * without a 2D array using this equivalence.
	 */

	public void decryptText(int key, char[] textToBeEncrypted) { // textToBeEncrypted in as a place holdeer?

		boolean checkdown = false;
		int j = 0;
		int row = key;
		int col = textToBeEncrypted.length;
		matrix = new char[key][col];// we create a matrix of a of col * row size

		// first of all mark the rails position by * in the matrix
		for (int i = 0; i < col; i++) {
			if (j == 0 || j == row - 1)
				checkdown = !checkdown;

			matrix[j][i] = '*'; // hashes the the character withing the rail fence to hide them

			if (checkdown)
				j++;
			else
				j--;
		}

		// now the methods enters the character of cipheetext in the matrix positon that
		// have *
		int index = 0; // will count out the number of the encyrpted txt

		for (int i = 0; i < row; i++) {

			for (int k = 0; k < col; k++) {

				if (matrix[i][k] == '*' && index < textToBeEncrypted.length) { // hashes the the character withing the
																				// rail fence to hide them
					matrix[i][k] = textToBeEncrypted[index++]; // Error here dus to .charAt
				}
			}
		}

		// visit each character in rails order as character are put in the encryption
		// function for (int i = 0; i < row; i++) { for (int k = 0; k < col; k++) {
		System.out.print(matrix[i][k] + "\t");
		System.out.println();

		checkdown = false;

		String s = "";
		j = 0;

		for (int i = 0; i < col; i++) {
			if (j == 0 || j == row - 1) {
				checkdown = !checkdown;

				s += matrix[j][i];

				if (checkdown)
					j++;
				else
					j--;
			}
		}
	}

	System.out.print(s);// print the plaintext that was decrypted by rail fence
	cipher // filewriter should created decrypted file here }

	public String setKey(String key) {
		return null;

	}
}
