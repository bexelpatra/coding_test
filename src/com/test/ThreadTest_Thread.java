package com.test;

public class ThreadTest_Thread extends Thread{

	public static Integer Count=0;
	private int n;
	private int temp;
	private static int temp2;
	public ThreadTest_Thread(int n) {
		this.n =n;
//		temp =0;
//		System.out.println(this.getClass().hashCode());
	}
	@Override
	public void run() {
		for (int i = 0; i < n; i++) {
//				Count+=1;
			temp+=1;
//			temp2+=1;
//			add();
		}
		// TODO Auto-generated method stub
//		Count+=temp;
		add(temp);
		System.out.printf("이 쓰레드에서 %d번을 더했습니다.: %s\n",temp,Thread.currentThread().getName());
//		System.out.println(Count);
	}
	public static synchronized void add(int i) {
		Count+=i;
	}
	
	public static int get() {
		return temp2;
	}
}
