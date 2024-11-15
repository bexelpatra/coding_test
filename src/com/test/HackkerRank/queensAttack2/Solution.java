package com.test.HackkerRank.queensAttack2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//https://real-012.tistory.com/183
public class Solution {
    class Result {
    
        /*
         * Complete the 'queensAttack' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. INTEGER k
         *  3. INTEGER r_q
         *  4. INTEGER c_q
         *  5. 2D_INTEGER_ARRAY obstacles
         */
    
        public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
            int count = 0;
            int[] number = new int[8];
            number[0] = n-r_q;
            number[1] = r_q-1;
            number[2] = n - c_q;
            number[3] = c_q-1;
            int longer = 0;
            int shotter = 0;
            if(r_q>c_q){
                longer = r_q;
                shotter = c_q;
            }else{
                longer = c_q;
                shotter = r_q;
            }
            // number[4] = n-l2r;
            for (int i = 0; i < obstacles.size(); i++) {
                int nowY = obstacles.get(i).get(0);
                int nowX = obstacles.get(i).get(1);
                // y 동일선 상방
                if(nowY > r_q && nowX == c_q){
                    int v = nowY - r_q -1;
                    number[0] = Math.min(number[0], v);
                    // y 동일선 하방
                }else if(nowY < r_q && nowX ==c_q){
                    int v = r_q - nowY -1;
                    number[1] = Math.min(number[1], v);
                    // x 동일선 우측
                }else if(nowY == r_q && nowX >c_q){
                    int v = nowX - c_q -1;
                    number[2] = Math.min(number[2], v);
                }
                // x 동일선 좌측
                else if(nowY == r_q && nowX < c_q){
                    int v = c_q- nowX -1;
                    number[3] = Math.min(number[2], v);
                // 1사
                }else if(nowY > r_q && nowX > c_q){
                    if(nowY - r_q == nowX-c_q){
                        number[4] = Math.min(nowY- r_q -1,number[4]);
                    }
                // 2사
                }else if(nowY < r_q && nowX > c_q){
                    if(nowY - r_q == nowX-c_q){
                        number[5] = Math.min(number[5],nowX- c_q -1);
                    }
                // 3사
                }else if(nowY < r_q && nowX < c_q){
                    if(nowY - r_q == nowX-c_q){
                        number[6] = Math.min(number[6],Math.abs(nowY-r_q) -1);
                    }
                // 4사
                }else if(nowY >r_q && nowX < c_q){
                    if(nowY - r_q == nowX-c_q){
                        number[7] = Math.min(number[7],Math.abs(nowY- r_q) -1);
                    }
                }

            }
            return count;
            
        }
        
    
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
