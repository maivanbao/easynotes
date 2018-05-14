package com.example.easynotes.Thread;

public class FirstThread implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Thong diep tu Thread dau tien: " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				System.err.println(ie.toString());
			}
		}
	}
}
