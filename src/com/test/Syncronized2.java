package com.test;

public class Syncronized2 {
	public static void main(String[] args) {
		MyThread1[] mts = new MyThread1[5];
		for (int i=0; i<mts.length; i++) {
			mts[i] = new MyThread1();	
			mts[i].start();
		}
	}
}

class MyThread1 extends Thread {
	public static int number = 0;
	public static Object lock = new Object(); 
	
	@Override
	public void run() {
		synchronized(lock) {
			for (int i=0; i<5; i++) {
				number = number + 1;;
				System.out.print(i);
			}
			System.out.println(":" + number + "-" + this.getName());
		}
	}
}