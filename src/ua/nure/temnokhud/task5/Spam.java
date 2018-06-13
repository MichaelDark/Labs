package ua.nure.temnokhud.task5;

import java.util.Scanner;

import static java.lang.System.out;

public class Spam {

	public static void main(String[] args) {
		String[] messages = new String[] { "Pupa", "Lupa" };
		int[] times = new int[] { 111, 333 };
		Spam spam = new Spam(messages, times);
		Scanner scan = new Scanner(System.in);
		while (!scan.hasNextLine());
		spam.interruptAll();
		scan.close();
	}

	private Thread[] threads;

	public Spam(String[] messages, int[] times) {
		threads = new Thread[messages.length];
		for (int i = 0; i < messages.length; ++i) {
			threads[i] = new Thread(new Worker(messages[i], times[i]));
			threads[i].start();
		}
	}

	public void interruptAll() {
		for (int i = 0; i < threads.length; ++i) {
			threads[i].interrupt();
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
				out.println(message);
			}
		}
	}
}
