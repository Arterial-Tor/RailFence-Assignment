package ie.gmit.dip;

public class RailFence {
	private char[][] matrix = null; // creates an uninitialised 2D char array called matrix

	public String encryptText(int key, int offset, char[] TextToBeEncrypted) {
		
		//this method will generate a railfence array, pass in userText and encrypt it
		 

		int col = TextToBeEncrypted.length - 1; // column length is the size of char array. -1 is used to account for
												// array starting at 0

		matrix = new char[key][col];// we create a 2D array called matrix of row * col size

		boolean checkDown = false; // check whether it is traversing the array downward or upward through the
									// railfence array, True = Downwards, False =
									// Upwards

		for (int i = 0; i < col - 1; i++) { // this for loop will traverse matrix array diagonally in order to put the
											// character of plaintext in

			if (offset == 0 || offset == key - 1)
				/*
				 * This if loop ensures the programme doesn't encounter an array out of bound
				 * error. this will ensure checkDown is changed accordingly, making the
				 * programme traverse either up or downwards
				 */
				checkDown = !checkDown;
			matrix[offset][i] = TextToBeEncrypted[i]; // inputs character at index i of TextToBeEncrypted[] in to matrix
														// array and position

			if (checkDown) { // if checkDown is true, offset will increase. If false offset will decrease.

				offset++; // increments offset to move downward
			} else
				offset--; // decrements offset to move upward
		}

		String encryptedText = ""; // local variable created to store encrypted text
		/*
		 * Here the 2D array will be traversed in a left to right, top to bottom fashion
		 * and pass the characters into encryptedText string
		 */
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
		/*
		 * the decrypt method act in a very similar way to the encrypt. the main
		 * difference exist in the information placed into the 2D array. the method will
		 * first traverse the array in the same fashion as the encrypt method, an place
		 * and Asterix (*) in the position where text should be placed.
		 */
		boolean checkDown = false;
		int rowOffset = offset; // local variable rowOffset created so that the offset and be adjusted without
								// affecting original offset variable
		int col = textToBeDecrypted.length; // assigns the length of testToBeencrypted array to col
		matrix = new char[key][col]; // we create a 2D array called matrix of row * col size

		for (int i = 0; i < col; i++) { // this for loop work in the same way as the encrypt method. traversing the
										// array diagonally.
			if (rowOffset == 0 || rowOffset == key - 1)
				checkDown = !checkDown;

			matrix[rowOffset][i] = '*'; // hashes the the character at position [rowOffset][i] within the rail fence to
										// hide them and allow for placing text back in correct order

			if (checkDown)
				rowOffset++;
			else
				rowOffset--;
		}

		int index = 0; // index will count out the number of the encrypted text as it moves through
						// matrix

		/*
		 * the for loop below traverses the array from left to right, and from top to
		 * bottom. Using the if loop, characters a portion index of textToBeDecrypted
		 * will be placed anywhere there is an asterix. this in theory should positon
		 * the text back in the original position it was place when being encrypted.
		 */
		for (int i = 0; i < key; i++) {

			for (int k = 0; k < col; k++) {

				if (matrix[i][k] == '*' && index < col) {
					matrix[i][k] = textToBeDecrypted[index++];
				}
			}
		}

		String decryptedText = ""; // Similar to the encrypt method above, this local variable will store the
									// decrypted text
		System.out.println("----------Decrypting Text------------");
		System.out.println();
		System.out.println("----------Please Wait....------------");

		checkDown = false; // resets checkDown to ensure the array is traversed in the correct direction
		rowOffset = offset; // resets rowOffset to offset value

		/*
		 * This for loop will traverse the array in a diagonally fashion. identical to
		 * the encrypt method. as a result returning the decrypted text to the
		 * decryptedText String
		 */
		for (int i = 0; i < col - 1; i++) {

			if (rowOffset == 0 || rowOffset == key - 1)
				checkDown = !checkDown;

			decryptedText += matrix[rowOffset][i]; // adds each letter to the string decryptedText at appropriate
													// postions

			if (checkDown) { // controls whether the the for loop will traverse the array upwards or
								// downwards

				rowOffset++;
			} else
				rowOffset--;
		}

		return decryptedText;
	}

}

//*******Encryption and decryption methods originally taken from : https://ghimireshankarpost.blogspot.com/2017/04/rail-fence-cipher-java-implementation.html****
// modified accordingly
