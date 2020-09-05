package ie.gmit.dip;

import java.io.IOException;

public class Runner { //Runner class handles the main method and subsequent intilisation of the programme

	public static void main(String[] args) { // Main Method to call new instance of Menu
		Menu m = new Menu();
		try {
			m.start();
		} catch (IOException e) { // exception handling to catch any exceptions thrown by methods throughout the
									// various classes and methods
			e.printStackTrace();
		}
	}

}
