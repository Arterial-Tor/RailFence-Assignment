package ie.gmit.dip;

import java.io.*;

public class FileHandler {
	private String fileName;
	
	//should create a char array with text to be encrypted
	
	
	FileWriter fw = new FileWriter(new File( fileName + " " + "Encrypted.txt"));

	//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("./in.txt"))));
	//String line = null
}
	//need to put in a method to input file name into reader fnam
	
	/*while ((line = br.readLine()) != null); {
		fw.write(cipher.encrypt(line) + "\n"); 
		// \n makes each line appear on a new line instead of one giant line
	
	}

	br.close(); // Ensure you flush and close all streams we write to
	fw.flush();
	fw.close();
}s	*/