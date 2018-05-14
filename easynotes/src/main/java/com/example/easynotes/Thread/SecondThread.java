package com.example.easynotes.Thread;

public class SecondThread implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Thong diep tu Thread thu hai: " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				System.err.println(ie.toString());
			}
		}

	}

}
