package com.example.easynotes.Thread;

public class ThreadFramgia extends Thread {
	@Override
	public void run(){
		for(int x=1;x<=3;x++){
			System.out.println(x+" Thread name: "+Thread.currentThread().getName());
		}
	}

}
