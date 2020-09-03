package ie.gmit.dip;

public class RailFence {
	private char[][] matrix = null;

	public String encryptText(int key, int offset, char[] TextToBeEncrypted) { // changed Charr array name from
																				// TextToBeEncrypted.
		int col = TextToBeEncrypted.length - 1;// column length is the size of char array.

		matrix = new char[key][col];// we create a matrix of a of col * row size

		boolean checkDown = false; // check whether it is moving downward or upward, True = Downwards, False =
									// Upwards

		for (int i = 0; i < col - 1; i++) { // matrix visiting row in order to put the character of plaintext in

			if (offset == 0 || offset == key - 1)
				checkDown = !checkDown;

			matrix[offset][i] = TextToBeEncrypted[i];

			if (checkDown) {

				offset++;
			} else
				offset--;
		}

		// visiting the matrix in usual order to get ciphertext
		/*
		 * for (int i = 0; i < key; i++) { for (int k = 0; k < col; k++) {
		 * System.out.print(matrix[i][k] + "  "); } System.out.println(); }
		 */
		String encryptedText = "";

		System.out.println("----------------------");
		for (int i = 0; i < key; i++) {
			for (int k = 0; k < col; k++) {
				if (matrix[i][k] != 0)
					encryptedText = encryptedText + matrix[i][k];
			}

		}
		return encryptedText;
	}

	public String decryptText(int key, char[] textToBeDecrypted) { // textToBeEncrypted in as a place holdeer?

		boolean checkDown = false;
		int row = 0;
		int col = textToBeDecrypted.length;
		matrix = new char[key][col];// we create a matrix of a of col * row size

		// first of all mark the rails position by * in the matrix
		for (int i = 0; i < col; i++) {
			if (row == 0 || row == key - 1)
				checkDown = !checkDown;

			matrix[row][i] = '*'; // hashes the the character within the rail fence to hide them

			if (checkDown)
				row++;
			else
				row--;
		}

		// now the methods enters the character of ciphertext in the matrix position
		// that
		// have *
		int index = 0; // will count out the number of the encrypted txt

		for (int i = 0; i < key; i++) {

			for (int k = 0; k < col; k++) {

				if (matrix[i][k] == '*' && index < col) {
					matrix[i][k] = textToBeDecrypted[index++];
				}
			}
		}

		// visit each character in rails order as character are put in the encryption
		// function

		String decryptedText = "";

		checkDown = false; // reset checkDown
		row = 0; // reset row to 0
		for (int i = 0; i < col - 1; i++) { // matrix visiting row in order to put the character of ciphertext in

			if (row == 0 || row == key - 1)
				checkDown = !checkDown;

			decryptedText += matrix[row][i]; // adds each letter to the string decryptedText

			if (checkDown) {

				row++;
			} else
				row--;
		}

		return decryptedText;
	}

}

//*******Encryption and decryption methods originally taken from : https://ghimireshankarpost.blogspot.com/2017/04/rail-fence-cipher-java-implementation.html****
// modified accordingly
