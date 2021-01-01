package ie.gmit.dip;

import java.io.*;
import java.util.Scanner;

public class Menu {
	private Scanner s; // create class variable for scanner. will be used throughout class
	private boolean keepRunning = true; // Keeps the menu visible until user decides to close application
	private KeyHandler keyHolder; // Creates variable keyHolder as an object of the keyHandler class
	private InputHandler inputHandler; // Creates variable inputHandler as an object of the InputHandler class

	public Menu() { // constructor to initialise class variables
		s = new Scanner(System.in); // Initialises new scanner s which can be called throughout the menu
		keyHolder = new KeyHandler(); // initialises new instance of keyHandler
		inputHandler = new InputHandler(); // initialises new instance of inputHandler

	}

	public void start() throws IOException { // Start() called by runner prints menu and takes input from user
		while (keepRunning) { // This will ensure the menu stays visible to the user until the keepRunning =
								// False
			showMenu(); // calls showOptions method to display menu

			switch (Integer.parseInt(s.next())) { // Switch statement that will take user inputs from the terminal via
													// s.next()
			case 1 -> selectFile(); // Enter a value from 1-6 to call one of the attached methods
			case 2 -> textInput();
			case 3 -> enterKey();
			case 4 -> encrypt();
			case 5 -> decrypt();
			case 6 -> quit();
			default -> System.out.println("****** [ERROR] Invalid Input! ******");
			// default ensures any value outside 1-6 is displayed to the user as invalid
			}
		}
	}

	private void textInput() { // takes text directly from entered by the user to store for encryption
		System.out.println("****** Enter the plaintext for encryption ******");
		inputHandler.setUserText(s.next()); // passes user plain test into file handler to store for
											// encryption/decryption

		return;
	}

	private void selectFile() throws IOException { // allows used to input filepath that is to be passed into the
													// Railfence cipher
		System.out.println("************** Choose File to import ***************");
		System.out.println("****Enter the filepath for encryption/decryption****");
		FileHandler fH = new FileHandler(); // Initialise local instance of filehandler, allows the user to pass file to
											// filehandler class

		String fileText = fH.getArrayFromFile(s.next()); // local variable fileText is created to consume string return
															// requirement. s.next is used to call scanner, allow user
															// to input text.
		inputHandler.setUserText(fileText);// fileText passed to getArrayFromFile() Method in FileHandler class to store
											// text present in file

		return;
	}

	private void encrypt() throws IOException { // encrypt method will pass the required key, offset, and plain text to
												// the railfence class
		RailFence rf = new RailFence(); // creates new instance of RailFence
		String encryptText = rf.encryptText(keyHolder.getKey(), keyHolder.getOffset(),
				inputHandler.getCharArrayFromInput()); // the creating of the encrypt txt variables allow the method to
														// gather the required information before passing it into the
														// railfence
		FileHandler fH = new FileHandler(); // creates new instance of FileHandler
		System.out.println("************* Enter the file output name *************");
		System.out.println("** [INFO] File type will be generated automatically **");
		String fOutName = s.next(); // asks user to input the desired output file name
		fH.writeToFile(encryptText, fOutName); // encrypted text, along with the out file name are passed to the
												// filewriter to create new file containing encrypted text
		System.out.println("************* Encryption Completed *************");
		return;
	}

	private void decrypt() throws IOException { // decrypt method will pass the required key, offset, and encrypted text
												// to the railfence class
		/*
		 * This method functions nearly identical to the encrypt method. Instead of
		 * passing information the encryption method in the railfence class this methods
		 * passes text to the decryption method.
		 */
		RailFence rf = new RailFence();
		String decryptText = rf.decryptText(keyHolder.getKey(), keyHolder.getOffset(),
				inputHandler.getCharArrayFromInput());
		FileHandler fH = new FileHandler();
		System.out.println("************* Enter the file output name *************");
		System.out.println("** [INFO] File type will be generated automatically **");
		String fOutName = s.next();
		fH.writeToFile(decryptText, fOutName);
		System.out.println("************* Dencryption Completed *************");

		return;
	}

	private void enterKey() {
		/*
		 * keyHolder variable calls setKey and setOffset to take the users input and
		 * assignment them to the private key & offset variables in the KeyHandler Class
		 */
		do {
			System.out.println("******** Please Enter RailFence Key! ********");
			System.out.println("Key Lenght must be in the range greater than 0");
			keyHolder.setKey(Integer.parseInt(s.next())); // tell the railfence how many rows there should be
		} while (keyHolder.getKey() < 1); // do/while loop ensure that user enters a key greater than 1

		do {

			System.out.println("******** Please Enter RailFence Offset! ********");
			System.out.println("Offset Lenght must be in the range greater than the key");
			keyHolder.setOffset(Integer.parseInt(s.next())); // tells the railfence which row to start encryption
		} while (keyHolder.getOffset() >= keyHolder.getKey());// do/while loop ensure that user doesn't enter a offset
																// greater than the key value

		return;
	}

	private void quit() { // shuts down programme
		System.out.println("[INFO] Shutdown Successful");
		keepRunning = false; // terminates while loop in Menu() method. Terminates program.
	}

	private void showMenu() { // This method that displays the menu options to the user
		System.out.println("");
		System.out.println("######################################");
		System.out.println("    RailFence Encryptor 3000 v1.0");
		System.out.println("######################################");
		System.out.println("1) Select File");
		System.out.println("2) Input Plain Text");
		System.out.println("3) Enter RailFence Key");
		System.out.println("4) Encrypt");
		System.out.println("5) Decrypt");
		System.out.println("6) Quit");
		System.out.println("Select an Option [1 - 6]>");

	}
}
