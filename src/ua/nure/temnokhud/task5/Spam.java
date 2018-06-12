package ua.nure.temnokhud.task5;

import java.util.Scanner;

public class Spam {

	public static void main(String[] args) {
		String[] messages = new String[] { "@@@", "bbbbbbb" };
		int[] times = new int[] { 333, 222 };
		Spam spam = new Spam(messages, times);
		Scanner scan = new Scanner(System.in);
		while (!scan.hasNextLine());
		spam.interruptAll();
		scan.close();
	}

	public void interruptAll() {
		for (int i = 0; i < threads.length; ++i) {
			threads[i].interrupt();
		}
	}

	private Thread[] threads;

	public Spam(String[] messages, int[] times) {
		threads = new Thread[messages.length];
		for (int i = 0; i < messages.length; ++i) {
			threads[i] = new Thread(new Worker(messages[i], times[i]));
			threads[i].start();
		}
	}

	private class Worker implements Runnable {
		String message;
		int time;

		Worker(String message, int time) {
			this.message = message;
			this.time = time;
		}

		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				System.out.println(message);
			}
		}
	}
}
