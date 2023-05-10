package com.test;

import java.io.File;

public class regex1 {

	public static void main(String[] args) {
		
		String reg = "drvLcnsePhoto(.*),$";
		File file = new File("");
		String reg2 = "감4합2다";
		System.out.println(reg2.replaceAll("[0-9]", ""));

		
	}
}
