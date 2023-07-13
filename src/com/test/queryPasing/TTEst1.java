package com.test.queryPasing;

public class TTEst1 {
	public static void main(String[] args) {
		String toSplit = "a is not null and c8='ac8' and c9!='c9c9s' and com = 123 and code <!cdata[>=]>3";
		System.out.println(toSplit.replaceAll("and", "\n"));
		System.out.println(toSplit.replaceAll("^<!cdata^[>=<]+>$", "\n"));

		String[] test = toSplit.split("and");
		for (String string : test) {
			System.out.println(string);
			String temp = string.trim().split("[^a-z1-9]+")[0];
			System.out.println(temp);
		}
	}
}
