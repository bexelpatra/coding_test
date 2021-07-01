package com.test.practice.z_test;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
//    [[1, 4], [3, 4], [3, 10]]
    public int[] solution(int[][] v) {
        int[] answer = {};
        int commax = 0;
        int commay = 0;
        Map<Integer, Long> x = Arrays.stream(v).map(ints -> ints[0]).collect(Collectors.groupingBy(Integer::intValue,Collectors.counting()));
        Map<Integer, Long> y = Arrays.stream(v).map(ints -> ints[1]).collect(Collectors.groupingBy(Integer::intValue,Collectors.counting()));

        commax = (x.keySet().stream().filter(integer -> x.get(integer) !=2l).findFirst().orElse(0));
        commay = (y.keySet().stream().filter(integer -> y.get(integer) !=2l).findFirst().orElse(0));
        answer = new int[]{commax,commay};

        System.out.println(String.format("[%d,%d]",commax,commay));
        return answer;
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Long> p = Arrays.stream(participant).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        for (String s : completion) {
            if(p.get(s)-1==0){
                p.remove(s);
            }else if(p.get(s)-1>=1){
                p.put(s,p.get(s)-1);
            }
        }
        for (String s : p.keySet()) {
            return s;
        }
        return answer;
    }
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        List<String> stringList = Arrays.stream(phone_book).sorted(Comparator.comparing(Function.identity(),String::compareTo)).collect(Collectors.toList());

        for(int i=0;i<phone_book.length-1;i++){
            String start = stringList.get(i);
            int len = start.length();
            String xxx = stringList.get(phone_book.length);
            for(int j=i+1;j<phone_book.length;j++){
                String now = stringList.get(j);
                if(len >= now.length()){
                    i=j-1;
                    break;
                }else {
                    len = now.length();
                }
                if(now.startsWith(start)){
                    return false;
                }
            }
        }
        return true;
    }

    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String,Long> stringLongMap = Arrays.stream(clothes).map(strings -> strings[1]).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        int x = 1;
        for (String s : stringLongMap.keySet()) {
            x*=(stringLongMap.get(s)+1);
        }
        x-=1;
        return x;
    }

    public int[] solution(String[] genres, int[] plays) {
        List<Song> songs = new ArrayList<>();
        Map<String,Integer> map = new ConcurrentHashMap<>();
        for(int i=0;i<genres.length;i++){
            String gen = genres[i];
            int play = plays[i];
            songs.add(new Song(i,gen,play));
            if(map.get(gen)!=null){
                map.put(gen,map.get(gen)+play);
            }else {
                map.put(gen,play);
            }
        }

//        Map<String,List<Song>> songs1 = songs.stream()
//                .sorted(Comparator.comparing(Song::getGenre,(o1, o2) -> map.get(o2)-map.get(o1)).thenComparing(Song::getPlay).reversed().thenComparing(Song::getId))
//                .collect(Collectors.groupingBy(Song::getGenre));
        List<Song> songs1 = songs.stream()
                .sorted(Comparator.comparing(Song::getGenre,(o1, o2) -> map.get(o1)-map.get(o2)).thenComparing(Song::getPlay).reversed().thenComparing(Song::getId))
                .collect(Collectors.toList());
        // 장르별로 2개씩
        Map<String,Integer> gen = new ConcurrentHashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (Song song : songs1) {
            if(gen.getOrDefault(song.genre,0) < 2){
                gen.put(song.genre,gen.getOrDefault(song.genre,0)+1);
                ans.add(song.id);
            }
        }

//        for (String s : songs1.keySet()) {
//            List<Song> songs2 = songs1.get(s);
//            songs2.stream().sorted(Comparator.comparing(Song::getPlay,(o1, o2) -> o2-o1).thenComparing((o1, o2) -> o1.id-o2.id)).limit(2).forEach(song -> ans.add(song.id));
//        }
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }

    class Song {
        public int id;
        public String genre;
        public int play;
        public int total;

        public int getId() { return id; }public String getGenre() { return genre; }public int getPlay() { return play; }public int getTotal() { return total; }

        public Song(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Deque<Integer> deque = new ArrayDeque<>();

        for (int progress : progresses) {
            deque.add(progress);
        }
        List<Job> jobs = new ArrayList<>();
        for(int i=0;i<progresses.length;i++){
            int progress = progresses[i];
            int speed = speeds[i];
            jobs.add(new Job(progress,speed));
        }
        int now = jobs.get(0).rest;
        int count = 1;
        List<Integer> integers = new ArrayList<>();

        for(int i=1;i<jobs.size();i++){
        Job j = jobs.get(i);
            if(now < j.rest){
                now = j.rest;
                integers.add(count);
                count=0;
            }
            count++;
        }
        integers.add(count);
        answer = new int[integers.size()];
        for(int i=0;i<integers.size();i++){
            answer[i] = integers.get(i);
        };
        return answer;
    }
    class Job{
        public int p;
        public int s;
        public int rest;

        public Job(int p, int s) {
            this.p = p;
            this.s = s;
            this.rest = cal(p,s);

        }
        private int cal(int p,int s){
            int day = 0;
            while(p<100){
                p+= s*day;
                day++;
            }
            return day;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> order = Arrays.stream(priorities).boxed().sorted((o1, o2) -> o2-o1).collect(Collectors.toList());
        Deque<Printer> printers = new ArrayDeque<>();
        for(int i=0;i<priorities.length;i++){
            printers.add(new Printer(i,priorities[i]));
        }
        int count = 0;
        while(!printers.isEmpty()){
            int x= printers.peek().priority;
            if(printers.peek().priority ==order.get(0)){
                count++;
                order.remove(0);
                Printer printer = printers.poll();
                if(printer.location == location) {
                    System.out.println(count);
                    return count;
                }
            }else{
                printers.add(printers.poll());
            }
        }
        return answer;
    }
    class Printer{
        public int location;
        public int priority;

        public Printer(int location, int priority) { this.location = location;this.priority = priority; }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Deque<Integer> bridge = new ArrayDeque();
            int bridgeWeight = 0;
            for(int i=0;i<truck_weights.length;i++){
                int now = truck_weights[i];
                // 처음 비어있을때
                // 1. 무게만큼 채워넣는다.
                // 2. 무게가 다 차면 다리 길이만큼 0을 밀어넣는다.
                // 3. 다리 길이만큼 차면 한개씩 빼낸다.
                // 4. 다시 무게만큼 채워넣는다.
                while(true){
                    if(bridge.isEmpty()){
                        bridge.add(now);
                        answer++;
                        bridgeWeight+=now;
                        break;
                    }
                    else if(bridge.size()<bridge_length){
                        if(bridgeWeight+now <= weight){
                            bridge.add(now);
                            answer++;
                            bridgeWeight+=now;
                            break;
                        }else {
                            bridge.add(0);
                            answer++;
                        }
                    }
                    if(bridge.size() == bridge_length){
                        bridgeWeight -= bridge.pollFirst();
                    }
                }
            }
            // 대체 이 코드로 하면 왜 다리길이를 제외한 것 만큼만 더해지는 것이지?...
        return answer+bridge_length;
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0;i<prices.length-1;i++){
            int now = prices[i];
            for(int j=i+1;j<prices.length;j++){
                if(now <= prices[j]){
                    answer[i]++;
                }else {
                    answer[i] = j-i;
                    break;
                }
            }
        }

        return answer;
        // stack을 이용한 풀이
//        Stack<Integer> beginIdxs = new Stack<>();
//        int i=0;
//        int[] terms = new int[prices.length];
//
//        beginIdxs.push(i);
//        for (i=1; i<prices.length; i++) {
//            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
//                int beginIdx = beginIdxs.pop();
//                terms[beginIdx] = i - beginIdx;
//            }
//            beginIdxs.push(i);
//        }
//        while (!beginIdxs.empty()) {
//            int beginIdx = beginIdxs.pop();
//            terms[beginIdx] = i - beginIdx - 1;
//        }
//
//        return terms;
    }
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        List<Integer> integers =Arrays.stream(commands)
                .map(ints -> {
                    return Arrays.stream(array)
                            .skip(ints[0]-1)
                            .limit(ints[1]-ints[0]+1)
                            .sorted()
                            .toArray()[ints[2]-1];
                })
                .collect(Collectors.toList());

        for(int i=0;i<integers.size();i++){
            answer[i] = integers.get(i);
        }
        return answer;
    }
}
