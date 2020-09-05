package ie.gmit.dip;

import java.io.*;

public class FileHandler { // FileHandler class deals with reading in files to string and outputting string
							// to file

	public String getArrayFromFile(String fName) throws IOException {
		/*
		 * ^getArrayFromFile methods handles reading in text from a file source and
		 * creating a string that will be passed into the input handler class by the
		 * SelectFile method in the menu class
		 */
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("./" + fName))));
		/*
		 * ^file path entered by user is used to locate file and read the text lin by
		 * line into a buffered reader br
		 */

		StringBuilder stringBuilder = new StringBuilder();
		/*
		 * ^A new instance of string builder is created. string // builder will allow
		 * the program to systematically build a // string line by line
		 */
		String fileContents = null; // this creates the local variable file contents which will be used to pass each
									// line read by buffered reader to sting builder

		String ls = System.getProperty("line.separator"); // a new instance of ls will create a new line within string
															// builder each time it is called

		while ((fileContents = br.readLine()) != null) {
			/*
			 * ^as the buffered reader reads in lines of text it will assign // each to
			 * fileContents as long as there is a line of text // present
			 */
			stringBuilder.append(fileContents);
			/*
			 * ^Here the line of text assigned to filecontents is appended to string //
			 * builder before fileContents is reassigned a new line of text by the //
			 * buffered reader
			 */
			stringBuilder.append(ls); // a new line separator is added to ensure that the string wont get print
										// entirely on a single line
		}

		stringBuilder.deleteCharAt(stringBuilder.length() - 1); // This will delete the last new line separator
		br.close();// closes the buffer reader and releases system resource back to
		// program

		String contentString = stringBuilder.toString(); // contents of string builder are assigned to contentString

		return contentString; // contentString returned to selectFile method in menu class
	}

	public void writeToFile(String railFenceOutput, String fOutName) { // This method will write text returned from both
																		// encrypt and decrypt method to file outline by
																		// user

		FileWriter fw; // creates and new instance on Filewriter
		try {
			fw = new FileWriter(new File(fOutName + ".txt")); // creates a new file with filename specified by user

			fw.write(railFenceOutput); // writes the contents of railfence to file

			fw.close(); // closes and flushes the file writer from memory, releasing resources back to
						// program

		} catch (IOException e) {
			e.printStackTrace();
			/*
			 * Basic exception handling will print stackTrace if and error occurs within
			 * this try catch loop
			 */
		}
	}
}
