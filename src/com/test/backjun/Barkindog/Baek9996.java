package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

//https://www.acmicpc.net/source/60656329
// 앞뒤만 따서 확인해보면 된다.
public class Baek9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), "*");
		String head = st.nextToken();
		String tail = st.nextToken();
		int len = head.length() + tail.length();
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if (input.startsWith(head) && input.endsWith(tail) && len <= input.length()) sb.append("DA\n");
			else sb.append("NE\n");
		}
		
		System.out.print(sb);
        // pattern();
        
    }

    private static void pattern() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String pattern = reader.readLine().replace("*", ".*");
    
        Pattern p = Pattern.compile(pattern);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(p.matcher(reader.readLine()).matches()){
                sb.append("DA");
            }else{
                sb.append("NE");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
