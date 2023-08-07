package codingtest;

public class Teest1 {
    public static void main(String[] args) {
        int n = 6;
        int m = 6;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(String.format("%d %d", i, j));
            }
        }
    }
}
