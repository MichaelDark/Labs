package ua.nure.temnokhud.task5;

import java.io.InputStream;

public class Part1 {
	public static void main(String[] args) {
	    boolean showDemo = true;
	    if(showDemo) {
            InputStream mockIn = System.in;
            System.setIn(new ThreeSecondInputStream());
            Spam.main(null);
            System.setIn(mockIn);
        } else {
            Spam.main(null);
        }
	}
}