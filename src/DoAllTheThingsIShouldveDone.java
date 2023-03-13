import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoAllTheThingsIShouldveDone {

	// 파일입력하면 파일에서 원하는 내용을 추출해준다.
	public static void main(String[] args) throws Exception {

		System.out.println("start");
		for (String filename : args) {
			System.out.println(filename);
			extracted(filename);
		}
		System.out.println("end");
	}

	private static void extracted(String filename) throws IOException {
		System.out.println("enter how many lines you gonna input");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		String[] searchWords = new String[N];
		for (int i = 0; i < N; i++) {
			searchWords[i] = converter(input.readLine());
			System.out.println(searchWords[i]);
		}
		
		FileInputStream file = new FileInputStream(new File(filename));
		BufferedReader reader = new BufferedReader(new InputStreamReader(file));
		
		reader.lines()
		.filter((s)->{
			return s.startsWith(("## Input data : "));
//			return true;
		})
		.filter((s)->{
			boolean temp = false;
			for (String string : searchWords) {
				if(s.contains(string)) {
					temp=true;
					break;
				};
			}
			return temp;
		})
		.map((s)->{
			return s.split(":")[1];
		})
		.forEach((s)->{
			System.out.println(s);
		})
		;

	}
	public static String converter(String drvlcNm) {
		Local local = Local.valueOfLocal(drvlcNm.substring(0,2));
		if(local != null) {
			drvlcNm = local.getNumber() + drvlcNm.substring(2);
		}
		drvlcNm = drvlcNm.replaceAll("[^0-9]", "");		
		return drvlcNm;
		
	}
	public static enum Local{
		SEOUL("서울",11),
		BUSAN("부산",12),
		GYEONGGI("경기",13),
		GANGWON("강원",14),
		CHUNGBUK("충북",15),
		CHUNGNAM("충남",16),
		JEONBUK("전북",17),
		JEONAM("전남",18),
		GYEINGBUK("경북",19),
		GYEONGNAM("경남",20),
		JEJU("제주",21),
		DAEGU("대구",22),
		INCHEON("인천",23),
		
		DAEJEON("대전",25),
		ULSAN("울산",26),


		;
		
		private String name;
		private int number;
		
		Local(String name, int i) {
			// TODO Auto-generated constructor stub
			this.name = name;
			this.number = i;
		}
		public String getName() {
			return name;
		}
		public int getNumber() {
			return number;
		}
		public static Local valueOfLocal(String name) {
			for (Local lo : Local.values()) {
				if(lo.getName().equals(name)) {
					return lo;
				}
			}
			return null;
		}
	}
}
