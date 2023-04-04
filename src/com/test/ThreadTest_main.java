package com.test;

public class ThreadTest_main {

	public static void main(String[] args) throws InterruptedException {
		// main daemon
		long start = System.currentTimeMillis();
		Thread[] ts = new ThreadTest_Thread[10000];
		for (int i = 0; i < ts.length; i++) {
			ts[i] = new ThreadTest_Thread(10000);
			ts[i].start();
//			ts[i].join();		
		}

		for (int i = 0; i < ts.length; i++) {
//			System.out.println(i+" : "+ts[i].getState() );
		}
		
		for (int i = 0; i < ts.length; i++) {
			ts[i].join();
		}

		System.out.println("total : "+ThreadTest_Thread.Count);
		System.out.println(System.currentTimeMillis()-start);
	}
}
