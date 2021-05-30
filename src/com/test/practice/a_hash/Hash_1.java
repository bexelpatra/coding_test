package com.test.practice.a_hash;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Hash_1 {
    /*
        프로그래머스 완주하지 못한 선수
        문제 설명
        수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
        마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

        제한사항
        마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
        completion의 길이는 participant의 길이보다 1 작습니다.
        참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
        참가자 중에는 동명이인이 있을 수 있습니다.
     */

//    String[] p = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
//    String[] c = new String[]{"josipa", "filipa", "marina", "nikola"};

    public String solution1(String[] participant, String[] completion) {
        /*

            평소 사용하던 방식으로 작성
            collection을 만들고 반복문을 사용함

         */
        List<String> p = new ArrayList<>();
        List<String> c = new ArrayList<>();
//        List<String> p = new ArrayList<>(Arrays.asList(participant));
//        List<String> c = new ArrayList<>(Arrays.asList(completion));

        Map<String,Integer> count = new HashMap<>();
        for (String s : participant) {
            if(count.containsKey(s)) count.put(s,count.get(s)+1);
            else count.put(s,1);
        }
        for (String s : completion) {
            if(count.containsKey(s)) {
                if(count.get(s)==1){
                    count.remove(s);
                }else if(count.get(s) > 1){
                    count.put(s,count.get(s)-1);
                }
            }
        }

        for (String s : count.keySet()) {
            return s;
        }
        return "";
    }
    public String solution2(String[] participant, String[] completion) {
        /*
            stream을 이용한 방법
            프로그래머스에서 다른 사람이 푼 풀이를 공부했다.
         */
        List<String> p = new ArrayList<>(Arrays.asList(participant));

        Map<String,Long> pMap = p.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        // 위 아래는 동일한 작동을 하지만 완전히 같지는 않다.
        // 위의 코드는 singleton 패턴으로 메모리가 절약된다.
        // 아래 코드는 매번 객체를 생성
//        Map<String,Long> stringIntegerMap = p.stream().collect(Collectors.groupingBy(s -> s,Collectors.counting()));

        for (String name : completion) {
            Long value = pMap.get(name) -1l;

            if(value == 0l){
                pMap.remove(name);
            }else {
                pMap.put(name,value);
            }
        }

        return pMap.keySet().iterator().next();
    }

    public String solution3(String[] participant, String[] completion) {
        /*
            hash를 이용한 풀이
         */
        int participantHash = 0;
        int completionHash = 0;

        Map<Integer,String> integerMap = new HashMap<>();

        for (String participantName : participant) {
            int hashedName = participantName.hashCode();
            participantHash += hashedName;
            if(!integerMap.containsKey(hashedName)){
                integerMap.put(hashedName,participantName);
            }
        }

        for (String completionName : completion) {
            completionHash += completionName.hashCode();
        }

        participantHash -= completionHash;

        return integerMap.getOrDefault(participantHash,"");
    }
}
