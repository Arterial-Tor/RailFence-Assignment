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

		String encryptedText = "";

		System.out.println("----------Encrypting Text------------");
		System.out.println();
		System.out.println("----------Please Wait....------------");
		for (int i = 0; i < key; i++) {
			for (int k = 0; k < col; k++) {
				if (matrix[i][k] != 0)
					encryptedText = encryptedText + matrix[i][k];
			}

		}
		return encryptedText;
	}

	public String decryptText(int key, int offset, char[] textToBeDecrypted) {

		boolean checkDown = false;
		int rowOffset = offset;
		int col = textToBeDecrypted.length;
		matrix = new char[key][col];// we create a matrix of a of col * row size

		// first of all mark the rails position by * in the matrix
		for (int i = 0; i < col; i++) {
			if (rowOffset == 0 || rowOffset == key - 1)
				checkDown = !checkDown;

			matrix[rowOffset][i] = '*'; // hashes the the character within the rail fence to hide them

			if (checkDown)
				rowOffset++;
			else
				rowOffset--;
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
		System.out.println("----------Decrypting Text------------");
		System.out.println();
		System.out.println("----------Please Wait....------------");

		checkDown = false; // reset checkDown
		rowOffset = offset; // reset rowOffset to offset value
		for (int i = 0; i < col - 1; i++) { // matrix visiting row in order to put the character of ciphertext in

			if (rowOffset == 0 || rowOffset == key - 1)
				checkDown = !checkDown;

			decryptedText += matrix[rowOffset][i]; // adds each letter to the string decryptedText

			if (checkDown) {

				rowOffset++;
			} else
				rowOffset--;
		}

		return decryptedText;
	}

}

//*******Encryption and decryption methods originally taken from : https://ghimireshankarpost.blogspot.com/2017/04/rail-fence-cipher-java-implementation.html****
// modified accordingly
