package ie.gmit.dip;

import java.io.*;
import java.util.*;

public class FileHandler {
	//Delete this variable
	private InputHandler inputHandler;
	// should create a char array with text to be encrypted

	public FileHandler() {
		//Delete this
		inputHandler = new InputHandler();
	}
	
	//Change this to: public String getStringFromFile
	public void getArrayFromFile(String fName) throws IOException { // I've just thrown exception to allow me to run
		
		//Put a try/catch around this biatch!
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
		
		
		//Delete this as we don't want our file handler being directly coupled to the input handler
		//Plus this inputHandler object is different from the one we are using in Menu so the value of userText won't be the same 
		inputHandler.setUserText(stringBuilder.toString());
		
		//Return the stringBuilder
		//return stringBuilder.ToString();

	}

	public void writeToFile(String railFenceOutput, String fOutName) throws IOException {

		//Try/catch
		FileWriter fw = new FileWriter(new File(fOutName + ".txt"));
		fw.write(railFenceOutput);

		// \n makes each line appear
		// on a new line instead of one giant line
		fw.close(); // closes and flushed the file writer from memory
	}

}
