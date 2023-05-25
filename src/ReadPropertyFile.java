import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ReadPropertyFile {

	public void load() throws Exception{
		Properties properties = new Properties();
		properties.load(new BufferedInputStream(new FileInputStream(new File("src/singo3.properties"))));
		
		System.out.println("\t\tchecking your properties file\n");
		for (Object ob : properties.keySet()) {
			System.out.println("\t\t" + ob + " : \t "+ new String(properties.getProperty(ob.toString()).getBytes("ISO-8859-1"), "utf-8"));
			if(ob.equals("from")) {
				List<String> s = Arrays.asList(properties.get(ob).toString().split(","));
				System.out.println(s.size());
			}
		}	
	}
	public static void main(String[] args) {
		ReadPropertyFile a = new ReadPropertyFile();
		try {
			a.load();			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
