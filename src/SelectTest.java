import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectTest {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("d:/temp.txt")));
        // readByChar(reader);
        String c = "";
        StringBuffer sb = new StringBuffer();
        while ((c = reader.readLine()) != null) {
            sb.append(c);
        }

        String result = sb.toString()
                .replaceAll("\t+", "") // 들여쓰기 제거
                .replaceAll("\\s+", " ") // 띄어쓰기 하나로 줄이기
                // .replaceAll("<!--(\\s)?([a-zA-Z]*)?(\\s)?-->", "") // 띄어쓰기 하나로 줄이기
                .replaceAll("<!--[^>](.*?)-->", "") // 띄어쓰기 하나로 줄이기
                .replaceAll("/\\*()+\\*/", "");
        System.out.println(result);
        System.out.println("/* c8 내가 사라져줄것같아? */".replaceAll("/\\*()+\\*/", ""));

    }

    private static void readByChar(BufferedReader reader) throws IOException {
        int c = -1;
        StringBuffer sb = new StringBuffer();
        while ((c = reader.read()) > -1) {
            char now = (char) c;
            sb.append(now);
        }
        String query = sb.toString().replace("\t", "").replace("  ", " ").replace("\n", "");
        System.out.println(query);
    }
}
