package ie.gmit.dip;

public class RailFence {
	private char[][] matrix = null;
	private int offset;

	private RailFence(int key, int offset, int col) {
		matrix = new char[key][col];
	}

	private String encryptText(String s, int key) {
		return null;

	/*public static void encryptFile(String str, int rails) {
	 
	 //this should call on char array created in fileHandler

		boolean checkdown = false; // check whether it is moving downward or upward
		int j = 0;
		int row = rails; // no of row is the no of rails entered by user
		int col = str.length(); // column length is the size of string
		char[][] a = new char[row][col];
		// we create a matrix of a of row *col size

		for (int i = 0; i < col; i++) { // matrix visitin in rails order and putting the character of plaintext

			if (j == 0 || j == row - 1)
				checkdown = !checkdown;
			a[j][i] = str.charAt(i);
			if (checkdown) {

				j++;
			} else
				j--;
		}

		// visiting the matrix in usual order to get ciphertext
		for (int i = 0; i < row; i++) {
			for (int k = 0; k < col; k++) {
				System.out.print(a[i][k] + "  ");
			}
			System.out.println();
		}
		String en = "";

		System.out.println("----------------------");
		for (int i = 0; i < row; i++) {
			for (int k = 0; k < col; k++) {
				if (a[i][k] != 0)
					en = en + a[i][k];

			}

		}
		System.out.println(en);// printing the ciphertext
		
	// filewrite shout create encrypted file here.

//*******Taken from : https://ghimireshankarpost.blogspot.com/2017/04/rail-fence-cipher-java-implementation.html****
*/
	}

	private String decryptText(String , int key) {
		return null;

	/*public static void decryption(String str, int rails) {

		boolean checkdown = false;
		int j = 0;
		int row = rails;
		int col = str.length();
		char[][] a = new char[row][col];

		// first of all mark the rails position by * in the matrix
		for (int i = 0; i < col; i++) {
			if (j == 0 || j == row - 1)
				checkdown = !checkdown;

			a[j][i] = '*';
			if (checkdown)
				j++;
			else
				j--;

		}

		// now enter the character of cipheetext in the matrix positon that have *
		// symbol
		int index = 0;

		for (int i = 0; i < row; i++) {
			for (int k = 0; k < col; k++) {

				if (a[i][k] == '*' && index < str.length()) {
					a[i][k] = str.charAt(index++);

				}

			}

		}

		// visit each character in rails order as character are put in the encryption
		// function
		for (int i = 0; i < row; i++) {
			for (int k = 0; k < col; k++) {
				System.out.print(a[i][k] + "\t");
			}
			System.out.println();
		}

		checkdown = false;
		String s = "";
		j = 0;

		for (int i = 0; i < col; i++) {
			if (j == 0 || j == row - 1)
				checkdown = !checkdown;

			s += a[j][i];

			if (checkdown)
				j++;
			else
				j--;

		}

		System.out.print(s);// print the plaintext that was decrypted by rail fence cipher
	// filewriter should created decrypted file here
	}

	public String setKey(String key) {
		return null;

	}*/

}

/*
 * [2]*********************** TRAVERSING ARRAYS ***********************
 * //Traversing a data structure means visiting each element in it. Some //data
 * structures are linear like arrays, some are hierarchical like //trees and
 * other are a network like a graph...
 * 
 * System.out.println("**** Traverse the Array ***"); printArray(worksheet);
 * System.out.println("\n");
 * 
 * // Loop diagonally down through the array. The diagonal value on each row
 * //is at worksheet[row][row], i.e.[0,0],[1,1],[2,2]...
 * System.out.println("**** Move Diagonally Through Array  ****"); for (int row
 * = 0; row < worksheet.length; row++) { System.out.print(worksheet[row][row]
 * +","); } System.out.println("\n"); }
 */
 
