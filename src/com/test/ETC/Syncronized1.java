package com.test.ETC;

public class Syncronized1 {
	public static void main(String[] args) {
		SyncDisplay sd = new SyncDisplay();
		MyThread[] mts = new MyThread[5];
		for (int i=0; i<mts.length; i++) {
			mts[i] = new MyThread(sd, Integer.toString(i));	
			mts[i].start();
		}
	}
}

class SyncDisplay {
	synchronized void display(String s) {
		for (int i=0; i<5; i++) {
			System.out.print(s);
		}
		System.out.println("");
	}
}

class MyThread extends Thread {
	SyncDisplay sd;
	String s = "";
	
	public MyThread(SyncDisplay sd, String s) {
		this.sd = sd;
		this.s = s;
	}
	
	@Override
	public void run() {
		sd.display(s);
	}
}