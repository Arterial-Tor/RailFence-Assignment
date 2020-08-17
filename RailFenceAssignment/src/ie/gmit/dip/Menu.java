package ie.gmit.dip;

import java.io.*;
import java.util.Scanner;

public class Menu {
	private Scanner s;
	private boolean keepRunning = true; //Keeps the menu visible until user decides to close application
	private KeyHandler keyHolder; // Creates variable keyHolder as an object of the keyHandler class
	private InputHandler userText; // Creates variable userText as an object of the InputHanlder class
	
	
	public Menu() { // constructor to initialise s
		s = new Scanner(System.in); // Initialises new scanner as which can be called throughout the menu
		keyHolder = new KeyHandler(); // initialises new instance of keyHanlder
	}

	public void start() { // method that take inputs from user
		while (keepRunning) {
			showMenu(); // calls showOptions method to display menu
			int userchoice = Integer.parseInt(s.next()); // blocking method, it waits until an input is passed in

			switch (userchoice) {
			case 1 -> selectFile();
			case 2 -> textInput();
			case 3 -> enterKey();
			case 4 -> encrypt();
			case 5 -> decrypt();
			case 6 -> displayRailFence();
			case 7 -> quit();
			default -> System.out.println("[ERROR] Invalid Input!");
			//default ensure any value outside 1-7 is displayed to the user as invalid
			}
		}
	}

	private void textInput() { //takes text directly from user for encryption
			System.out.println("Enter the plaintext for encryption");
			Scanner inn = new Scanner(System.in);
			userText = inn.next();
		return;
	}

	private void selectFile() {
		System.out.println("Choose File or URL");
		System.out.println("Enter the plaintext for encryption");
		Scanner fname = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(s.next()))));
	
		//String plainText = s.next(System.in);
		
		return;
	}

	private void displayRailFence() {
		System.out.println("railfence displayed");
		//printArray();
		
		return;
	}

	private void decrypt() {
		System.out.println("Decrypted!");
		return;
	}

	private void encrypt() {
		System.out.println("Encrypted!");
		return;
	}

	private void enterKey() {
		/*
		 * keyHolder variable calls setKey and setOffset to take the users input and
		 * assignment them to the private key & offset variables in the KeyHandler Class
		 */
		System.out.println("******** Please Enter RailFence Key! ********");
		keyHolder.setKey(Integer.parseInt(s.next()));

		System.out.println("******** Please Enter RailFence Offset! ********");
		keyHolder.setOffset(Integer.parseInt(s.next()));
		
		//call validateKey()
		
		return;
	}

	private void quit() {
		System.out.println("[INFO] Shutdown Successful");
		keepRunning = false; //terminates while loop in Menu() method. Terminates program.
	}

	private void showMenu() { // This method that displays the menu options to the user
		System.out.println("");
		System.out.println("######################################");
		System.out.println("       File Encyrption App v1.0");
		System.out.println("######################################");
		System.out.println("1) Select File or URL");
		System.out.println("2) Input Plain Text");
		System.out.println("3) Enter RailFence Key");
		System.out.println("4) Encrypt");
		System.out.println("5) Decrypt");
		System.out.println("6) Display RailFence");
		System.out.println("7) Quit");
		System.out.println("Select an Option [1 - 7]>");

	}
}
/*
 * the menu output was put down here to clean up the start method. that way the
 * start method only deals with taking in inputs. the showOptions method deals
 * with printing out the menu.
 */
