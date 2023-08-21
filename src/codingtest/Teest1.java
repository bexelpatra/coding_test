package codingtest;

public class Teest1 {
    public static void main(String[] args) {
        int m = 7;
        int n = 7;
        System.out.println(m - 1);
        System.out.println(m * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(String.format("%d %d", i, j));
            }
        }
    }
}
