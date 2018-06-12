package ua.nure.temnokhud.task5;

import java.io.InputStream;

public class Part1 {
	public static void main(String[] args) {
		InputStream inCache = System.in;
		System.setIn(new MyInStream());
		Spam.main(null);
		System.setIn(inCache);
	}
}