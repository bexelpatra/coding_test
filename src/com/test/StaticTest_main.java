package com.test;

import java.util.HashSet;
import java.util.Set;

public class StaticTest_main {
	public static void main(String[] args) {
		int n = 10000;
		StaticTest_Class[] list = new StaticTest_Class[n];
		Set<Object> s = new HashSet<>();
		for(int i =0; i< list.length;i++) {
			list[i] = new StaticTest_Class();
			s.add(StaticTest_Class.staticField.toString());
		}
		System.out.println(StaticTest_Class.staticField.hashCode());
		System.out.println(s.size());
		
	}
}