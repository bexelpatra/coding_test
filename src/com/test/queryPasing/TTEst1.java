package com.test.queryPasing;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

public class TTEst1 {
	public static void main(String[] args) throws Exception{
		// getTest1();
		StringBuilder sb = null;
		String line = "<select id=\"cici\"> <!--   -->select* from a </select>";
		String namespace="name";
		String id = "id";
		sb = new StringBuilder();
		sb.append(line, 0, line.indexOf(">")+1);
		sb.append(String.format("/** %s.%s */", namespace,id));
		sb.append(line, line.indexOf(">")+1,line.length()-1);
		line = sb.toString();
		System.out.println(line);

		// System.out.println(Utils.br("-", 50));
		String x = "select /* \r\n"
		+" 주석속 이야기 \r\n"
		+" 2. 이것도 주석 \r\n"
		+"*/ /*3. 미친놈의 주석 */ <!-- 좀 되라 --> from c8c8";

		String x2 = "abc /* */ c8";
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(x2.getBytes())));
		StringBuilder mb = new StringBuilder();
		String rline = "";
		while((rline = reader.readLine())!= null){
			// System.out.println(rline);
			int idx = 0;
			int s = 0;

			while((s= rline.indexOf("/*",idx)) > -1){ // /* 이 있는 줄
				StringBuilder tb = null;
				tb = new StringBuilder(); // 주석만 담자
				int e = rline.indexOf("./", s+1);
				if(e>-1){ // 같은 줄에서 끝이 날때
					tb.append(rline.substring(s, e+1));
					if(rline.length() -1>=e+2){						
						rline = rline.substring(e+1) ; // 닫히고 난 뒤에 다음 줄이 있는지 확인
						idx = e+1;
					}	
				}else{ // 같은 줄에서 주석이 끝나지 않는다.
					tb.append(rline.substring(s, rline.length()-1));
					while((rline = reader.readLine())!= null){
						int innerIdx = rline.indexOf("*/");
						if(innerIdx == -1){ // 그 다음줄에서도 끝나지 않음
							tb.append(rline);
							tb.append(System.lineSeparator());
							continue;
						}
						tb.append(rline.substring(0,innerIdx)); // 닫히는 부분까지 넣었다.
						tb.append(System.lineSeparator());
						if(rline.length() -1>=innerIdx){
							rline = rline.substring(innerIdx+2); // 닫히고 난 뒤에 다음 줄이 있는지 확인
							idx = e+1;
						}
					}
				}
				System.out.println(tb.toString());
				if(rline == null){
					break;
				}
			}
		}
	}

	private static void getTest1() {
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
;