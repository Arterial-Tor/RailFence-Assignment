package ie.gmit.dip;

import java.io.IOException;

public class Runner {

	public static void main(String[] args) {
		Menu m = new Menu();
		try {
			m.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
