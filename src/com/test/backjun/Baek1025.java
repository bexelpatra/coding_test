package com.test.backjun;

public class Baek1025 {
    public static void main(String[] args) throws Exception{
        int a =975319753;
        System.out.println(isSqare(a));
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(reader.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        char[][] graph = new char[n][m];
//
//        // graph 생성
//        for (int i = 0; i < n; i++) {
//            String temp = reader.readLine();
//            graph[i] = temp.toCharArray();
//        }
//
//        for (int i = 0; i < n; i++) { // 세로(열)
//            for (int j = 0; j < m; j++) { // 가로(행)
//                search(graph,i,j,n,m);
//            }
//        }
//
//        System.out.println(answer);
    }
    static int answer = -1;
    public static void search(char[][] graph,int x, int y,int n, int m){
        // 등차값을 구하기
        for (int i = -n; i < n; i++) { // 세로(열)
            for (int j = -m; j < m; j++) { // 가로(행)
                if(i ==0 && j==0){
                    continue;
                }
                int tempX = x;
                int tempY = y;
                int num =0;
                while (0<=tempX&& 0<=tempY && tempX < n && tempY < m){
                    num*=10;
                    num+= (int)(graph[tempX][tempY]-'0');
                    int root = (int)Math.sqrt(num);
                    if(root*root == num){
                        answer = Math.max(num,answer);
                    }
//                    if(isSqare(num)){
//                    }
                    tempX+=i;
                    tempY+=j;
                }
            }
        }
    }

    public static boolean isSqare(int n){
        long temp=0;
        while(temp <n/2 || temp*temp <= n){
            if (temp*temp == n) {
                return true;
            }
            temp+=1;
        }
        return false;
    }
    public static int reverse(int n){
        int reverse=0;
        for(int i=10;n>0;){
            reverse*=10;
            reverse+= n%i;
            n/=i;
        }
        return reverse;
    }
}
