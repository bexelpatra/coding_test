package com.test.ETC;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJWT {
    public static void main(String[] args) throws Exception{


//    	FabricSDKInfo s = new FabricSDKInfo();
//    	MobileDrvLicenseController m = new MobileDrvLicenseController();
    	Map<String,String> map = new HashMap<>();
    	try {
    		System.out.println("first");
    		map.put("try","try");
//			throw new Exception();
		} catch(Exception e){
			map.put("catch","catch");
			System.out.println(e);
		}finally {
			// TODO: handle finally clause
			map.put("finally","finally");
			System.out.println("?");
		}
    	StringBuilder sb = new StringBuilder();
    	for (String key : map.keySet()) {
			sb.append(key)
				.append(" : ")
				.append(map.get(key))
				.append("\n")
				;
		}
    	System.out.println(sb.toString());
    	List<String> list = Collections.emptyList();
    	// override 하지 않으면 에러 발생
//    	list.add("c8c8");
//    	list.stream().forEach((s)->{System.out.println(s);});
    	Calendar.getInstance();
    }
}
