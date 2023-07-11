import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

public class DockerTest {

	public static void main(String[] args) {
		// System.out.println("docker test start!!");
		String x = "MRHST_BHF_MANAGE_ID".toLowerCase();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < x.length(); i++) {
			if (x.charAt(i) == '_') {
				i += 1;
				sb.append(String.valueOf(x.charAt(i)).toUpperCase());
				continue;
			}
			sb.append(x.charAt(i));
		}
		System.out.println(sb.toString());

		LocalDate now = LocalDate.now();
		LocalDate d = LocalDate.of(2023, 4, 8);

		System.out.println(now.getDayOfYear() - d.getDayOfYear());
		// String uuid = UUID.randomUUID().toString();
		// String uuid = UUID.nameUUIDFromBytes("123".getBytes()).toString();
		// System.out.println(uuid);
		String test = "20230711161316039824";
		// System.out.println(Long.parseLong(test));
		String temp = "";
		BigDecimal big = new BigDecimal(test);
		System.out.println(big.remainder(BigDecimal.valueOf(1000000)).longValueExact());
		System.out.println(big.longValueExact());
		for (int i = 0; i < test.length(); i++) {
			try {
				temp = temp + 1;
				System.out.println(Long.parseLong(temp));

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(i);
			}
		}
	}
}
