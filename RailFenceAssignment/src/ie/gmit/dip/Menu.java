package ie.gmit.dip;

import java.io.*;
import java.util.Scanner;

public class Menu {
	private Scanner s;
	private boolean keepRunning = true; //Keeps the menu visible until user decides to close application
	private KeyHandler keyHolder; // Creates variable keyHolder as an object of the keyHandler class
	
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
			case 2 -> enterKey();
			case 3 -> encrypt();
			case 4 -> decrypt();
			case 5 -> displayRailFence();
			case 6 -> quit();
			default -> System.out.println("[ERROR] Invalid Input!");
			//default ensure any value outside 1-6 is displayed to the user as invalid
			}
		}
	}

	private void selectFile() {
		System.out.println("Choose File or URL");
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(s.next()))));
	
		//String plainText = s.next(System.in);
		
		return;
	}

	private void displayRailFence() {
		System.out.println("railfence displayed");
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
		System.out.println("2) Enter RailFence Key");
		System.out.println("3) Encrypt");
		System.out.println("4) Decrypt");
		System.out.println("5) Display RailFence");
		System.out.println("6) Quit");
		System.out.println("Select an Option [1 - 5]>");

	}
}
/*
 * the menu output was put down here to clean up the start method. that way the
 * start method only deals with taking in inputs. the showOptions method deals
 * with printing out the menu.
 */
