package com.test.ETC;

import java.io.File;

public class regex1 {

	public static void main(String[] args) {
		
		String reg = "drvLcnsePhoto(.*),$";
		String target = "Starting ChromeDriver 113.0.5672.63 (0e1a4471d5ae5bf128b1bd8f4d627c8cbd55f70c-refs/branch-heads/5672@{#912}) on port 9515";
		File file = new File("");
		String reg2 = "감4합2다";
//		System.out.println(reg2.replaceAll("[0-9]", ""));
		System.out.println(target.replaceAll("[^0-9.]", ""));

		
	}
}
