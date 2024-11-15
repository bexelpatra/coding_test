public class TTest33 {
    static int[] dp = new int[121];
    public static void main(String[] args) {
        dp[0] = 0;
        dp[1] = 1;
        int len = dp.length;
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i-1];
        }
    }
    
}
