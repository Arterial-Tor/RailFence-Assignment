package ie.gmit.dip;

import java.io.*;

public class FileHandler {

	// should create a char array with text to be encrypted

	public FileHandler() {
	}

	public char[] getArrayFromFile(String fName) throws IOException { // I've just thrown exception to allow me to run
																		// the programme
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fName))));
		String fileContents;

		while ((fileContents = br.readLine()) != null);

		char[] textToRailFence = new char[fileContents.length()]; // CONOR - not sure how to assign array size. I feel
																	// like im making the array the size of the first
																	// line
		textToRailFence = fileContents.toCharArray(); // CONOR - a bit stuck here. Is this correct?

		return textToRailFence; //Change this Variable from textToBeEncrypted to textToRailFence

		// br.close(); // closes the buffer reader and releases system resource back to
		// program

	}

	/*
	 * CONOR - I feel like the encrypt method should call this filewriter to give me
	 * my encypted txt file.
	 * 
	 */

	public void writeToFile(String railFenceOutput) throws IOException {

		// CONOR - added this for either encryoted txt or decrytped txt to call on, what
		// you think?

		// I also like to be able to type out the output file name

		// FileWriter fw = new FileWriter(new File(fOutName));

		// fw.write(cipher.encrypt(fileContents) + "\n");

		// \n makes each line appear
		// on a new line instead of one giant line
	}

	/*
	 * br.close(); // Ensure you flush and close all streams we write to fw.flush();
	 * fw.close();
	 */

}