package ua.nure.temnokhud.task5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

import static java.lang.System.out;

public class Part2 {
    public static final byte[] LINE_SEPARATOR = System.lineSeparator().getBytes(StandardCharsets.UTF_8);

	public static void main(String[] args) throws Exception {
		Thread[] threads = new Thread[10];

		for (int i = 0; i < 10; i++) {
			position[i] = i * (20 + LINE_SEPARATOR.length);
			threads[i] = new Thread(new Worker(i));
			threads[i].start();
		}
		for (int i = 0; i < 10; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
			}
		}
		try {
			file.seek(0);
			int out = file.read();
			while (out != -1) {
				System.out.print((char)out);
				out = file.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static RandomAccessFile file;
	private static int position[] = new int[10];

	static {
		try {
			file = new RandomAccessFile("task52.txt", "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static synchronized void addNumberToFile(int number) throws IOException {
		file.seek(position[number]);
		if (position[number] - (number) * (20 + LINE_SEPARATOR.length) < 20) {
			Part2.file.write(String.valueOf(number).getBytes(StandardCharsets.UTF_8));
            position[number] = position[number] + 1;
		} else {
			Part2.file.write(LINE_SEPARATOR);
            position[number] = position[number] + LINE_SEPARATOR.length;
		}
	}
}

class Worker implements Runnable {
	private int number;

	public Worker(int number) {
		this.number = number;
	}

	public void run() {
		try {
			for (int i = 0; i < 20 + 1; i++) {
				Part2.addNumberToFile(number);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

