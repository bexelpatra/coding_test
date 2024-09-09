package com.test.HackkerRank.climbing_the_leaderboard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
        List<Integer> result = new ArrayList<>();
        
        List<Integer> noDup = new LinkedList<>();
        noDup.add(ranked.get(0));
        
        int idx = 0;
        for (int i = 1; i < ranked.size(); i++) {
            if(!Objects.equals(noDup.get(idx), ranked.get(i))){
                idx+=1;
                noDup.add(ranked.get(i));
            }
        }
        for (Integer now : player) {
            int rank = bi(noDup,now);
            result.add(rank);
        }
        return result;
    }

    public static int bi(List<Integer> list, int n){ // 역순 이분 탐색
        int lo = 0;
        int hi = list.size();

        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(list.get(mid) > n){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(4);
        list.add(2);
        list.add(0);
        Result.climbingLeaderboard(list, list);
        System.out.println(Result.bi(list, 4));
        if(11==11){
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
