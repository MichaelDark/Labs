package ua.nure.temnokhud.task5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class Part2 {

	public static RandomAccessFile file;
	
	static {
		try {
			file = new RandomAccessFile("part2.txt", "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static synchronized void addNumberToFile(int number) throws IOException {
		file.seek(position[number]);
		if (position[number] - (number) * (20 + System.lineSeparator().length()) < 20) {
			Part2.file.write(StandardCharsets.UTF_8.encode(String.valueOf(number)).get());
		} else {
			Part2.file.write(StandardCharsets.UTF_8.encode(System.lineSeparator()).get());
		}
		position[number] = position[number] + 1;
	}

	private static int position[] = new int[10];

	public static void main(String[] args) {
		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; ++i) {
			position[i] = i * (20 + System.lineSeparator().length());
			threads[i] = new Thread(new Worker(i));
			threads[i].start();
		}
		for (int i = 0; i < 10; ++i) {
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
}

class Worker implements Runnable {
	private int number;

	public Worker(int number) {
		this.number = number;
	}

	public void run() {
		try {
			for (int i = 0; i < 20 + System.lineSeparator().length(); ++i) {
				Part2.addNumberToFile(number);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

