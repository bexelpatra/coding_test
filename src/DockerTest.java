
public class DockerTest {

	public static void main(String[] args) {
		// System.out.println("docker test start!!");
		String x = "QR_CREATE_MANAGE_ID".toLowerCase();
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
	}
}
