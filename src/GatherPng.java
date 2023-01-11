import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class GatherPng {
	static String to = "D:\\제비\\참고자료\\모바일운전면허_인수인계\\1. 시퀀스\\시퀀스이미지통합\\";
	public static void main(String[] args) throws Exception{
		System.out.println("파일 정리");
		File rootFile = new File("D:\\제비\\참고자료\\모바일운전면허_인수인계\\1. 시퀀스");
		for(File inner1: rootFile.listFiles((s)->{return s.isDirectory() && s.getName().startsWith("[");})) {
			move(inner1);
		}
		System.out.println();
	}
	public static void move(File file) throws FileNotFoundException, IOException {
		//(s)->{return s.getName().toLowerCase().endsWith(".png");})
		for(File inner1: file.listFiles()) {
			if(inner1.isDirectory()) {
				move(inner1);
			}else {
				File moveTo = new File(to+inner1.getName());
				Files.copy(new FileInputStream(inner1), moveTo.toPath(),StandardCopyOption.REPLACE_EXISTING );
				if(inner1.getName().toLowerCase().endsWith(".png")) {
				}
			}
		}
	}
}
