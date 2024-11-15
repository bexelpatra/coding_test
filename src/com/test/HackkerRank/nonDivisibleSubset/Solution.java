package com.test.HackkerRank.nonDivisibleSubset;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;


public class Solution {
    class Result {
    
        /*
         * Complete the 'nonDivisibleSubset' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER k
         *  2. INTEGER_ARRAY s
         */
    
        public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
            int len = s.size();
            boolean[][] map = new boolean[len][len];
            s = s.stream().map((integer) -> {
                return integer%k;
            }).sorted().collect(Collectors.toList());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len-1; i++) {
                for (int j = i+1; j < len; j++) {
                    map[i][j] = (s.get(i)% k+s.get(j)% k) % k != 0;
                }
            }
            int max = 0;
            for (int i = 0; i < len; i++) {
                boolean[] line = map[i];
                for (int j = i+1; j < len; j++) {
                    if(line[j]){
                        for (int idx = j+1; idx < len; idx++) {
                            if(!map[j][idx]){
                                sb.append(String.format("[%d %d] \n",j,idx));
                                for (int ii = 0; ii < len; ii++) {
                                    sb.append(Arrays.toString(map[ii]));
                                }
                                sb.append("\n");
                                line[idx] = false ;
                            }
                        }
                    }
                }
            }
            for (int ii = 0; ii < len; ii++) {
                sb.append(Arrays.toString(map[ii]));
            }
            sb.append("\n");
            for (int i = 0; i < len; i++) {
                int count = 0;
                for (int j = i; j < len; j++) {
                    if(map[i][j]){
                        count+=1;
                    }
                }
                max = Math.max(count, max);
                count=0;
            }
            
            // System.out.println(sb.toString());
            
            return max+1;
        }
        //https://gaegosoo.tistory.com/62
        public static int nonDivisibleSubset2(int k, List<Integer> s) {
            int []cnt = new int[k];
            for(int i=0;i<s.size();i++){
                cnt[s.get(i)%k]++;
            }
            System.out.println(Arrays.toString(cnt));
            int ans = 0;
            if(cnt[0]>0) ans +=1;
            if(k%2==0 && cnt[k/2] >0) ans +=1;
            for(int i=1;i<=(k-1)/2;i++){
                ans += (cnt[i]>cnt[k-i])? cnt[i]: cnt[k-i];
            }
            return ans;
        }
    }
    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream(new File("d:/hackrank.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.nonDivisibleSubset2(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
