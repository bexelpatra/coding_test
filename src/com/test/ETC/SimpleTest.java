package com.test.ETC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleTest {

	public static void main(String[] args) {
//		List<Integer> list = new ArrayList<>();
//		list.add(0);
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		System.out.println(list.size());
//		list.remove(0);
//		System.out.println(list.size());
		System.out.println(String.format("%-3d,%2d",10,100));
		
		Map<String,String> map = new HashMap<>();
		map.put("a", "kim");
		map.put("b", "lee");
		map.put("c", "park");
		map.put("d", "choi");
		
		List<Map<String, String>> a = Arrays.asList(map);
		

	 }
}
