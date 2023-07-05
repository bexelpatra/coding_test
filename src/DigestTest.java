import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DigestTest {
    public static void main(String[] args) {
        String plain = "00";
        String result = getDigest(plain);
        System.out.println(result);
        ZonedDateTime dt = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(dt.format(DateTimeFormatter.ofPattern("YYYYMMdd HHmmssSS")));

    }

    public static String getDigest(String plain) {
        String SHA = "";
        try {
            MessageDigest sh = MessageDigest.getInstance("SHA-256");

            sh.update(plain.getBytes());
            String temp = String.valueOf(Math.random());
            // System.out.println(temp);
            // sh.update("0".getBytes());
            byte byteData[] = sh.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            SHA = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // e.printStackTrace();
            SHA = null;
        }
        return SHA;
    }
}
