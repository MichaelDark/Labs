package ua.nure.temnokhud.task5;

import java.io.IOException;

public class MyInStream extends java.io.InputStream {
	private int counter = 0;
	private final String SEPARATOR = System.lineSeparator();

	public int read() throws IOException {
		if (counter == 0) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
			return SEPARATOR.charAt(counter++);
		}
		else if (counter < SEPARATOR.length()) {
			return SEPARATOR.charAt(counter++);
		}
		return -1;
	}

}

