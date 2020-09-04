package ie.gmit.dip;

import java.io.*;

public class FileHandler {

	public FileHandler() {

	}

	public String getArrayFromFile(String fName) throws IOException { 

			BufferedReader br;
				br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("./" + fName))));
		
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

			String contentString = stringBuilder.toString();

			return contentString;
	}
			

	public void writeToFile(String railFenceOutput, String fOutName) {

		// Try/catch
		FileWriter fw;
		try {
			fw = new FileWriter(new File(fOutName + ".txt"));

			fw.write(railFenceOutput);

			// \n makes each line appear
			// on a new line instead of one giant line
			fw.close(); // closes and flushed the file writer from memory

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
