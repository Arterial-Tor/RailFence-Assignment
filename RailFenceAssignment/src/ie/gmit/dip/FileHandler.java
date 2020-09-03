package ie.gmit.dip;

import java.io.*;
import java.util.*;

public class FileHandler {
	private InputHandler inputHandler;
	// should create a char array with text to be encrypted

	public FileHandler() {
		inputHandler = new InputHandler();
	}

	public void getArrayFromFile(String fName) throws IOException { // I've just thrown exception to allow me to run
																		// the programme
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("./" + fName))));
		StringBuilder stringBuilder = new StringBuilder();
		String fileContents = null;
		String ls = System.getProperty("line.separator");
		while ((fileContents = br.readLine()) != null) {
			stringBuilder.append(fileContents);
			stringBuilder.append(ls);
		}
		// delete the last new line separator
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		br.close();// closes the buffer reader and releases system resource back to
		// program
		//String contentString = stringBuilder.toString();

		inputHandler.setUserText(stringBuilder.toString());

	}

	public void writeToFile(String railFenceOutput, String fOutName) throws IOException {

		FileWriter fw = new FileWriter(new File(fOutName + ".txt"));
		fw.write(railFenceOutput);

		// \n makes each line appear
		// on a new line instead of one giant line
		fw.close(); // closes and flushed the file writer from memory
	}

}