package com.test;

import java.util.HashSet;
import java.util.Set;

public class StaticTest_main {
	public static void main(String[] args) {
		int n = 10;
		StaticTest_Class[] list = new StaticTest_Class[n];
		Set<Object> s = new HashSet<>();
		for(int i =0; i< list.length;i++) {
			list[i] = new StaticTest_Class();
			s.add(StaticTest_Class.staticField);			
			System.out.println(System.identityHashCode(StaticTest_Class.staticField));
			System.out.println();
		}
		list[0] = null;
		System.out.println("  --");
		System.out.println(System.identityHashCode(list));
		System.out.println(System.identityHashCode(list[0]));
		System.out.println(System.identityHashCode(list[1]));
		
	}
}