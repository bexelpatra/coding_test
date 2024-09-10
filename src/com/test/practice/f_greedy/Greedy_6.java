package com.test.practice.f_greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.test.practice.MyUtil;

public class Greedy_6 {
    public class Route{
        public int intro;
        public int outro;
        public int len;

        public Route(int intro, int outro) {
            this.intro = intro;
            this.outro = outro;
            this.len = outro - intro;
        }

        public int getIntro() { return intro; }public int getOutro() { return outro; }public int getLen() { return len; }
    }
    public int solution(int[][] routes) {
        int answer = 0;
        List<Route> routeList = new ArrayList<>();
        for (int[] route : routes) {
            routeList.add(new Route(route[0],route[1]));
        }
//        routeList = routeList.stream().sorted(Comparator.comparing(Route::getIntro).thenComparing((o1, o2) -> o2.getLen()-o1.getLen())).collect(Collectors.toList());
        routeList = routeList.stream().sorted(Comparator.comparing(Route::getIntro).thenComparing(Route::getLen)).collect(Collectors.toList());
        int point =0;
        for(int i=0;i< routeList.size()-1;i++){
            // 지금부터 해야하는 것들?
            //
        }
        String x = "";
        return answer;
    }

    /**
     * 2021. 9. 26
     * 1. 먼저 진입한 것부터 정렬
     * 2. 카메라의 위치를 움직이면서 개수를 세려고 했음
     *
     * 문제
     * 언제 카메라를 설치해야하는지 그리디하지 못했다.
     * 조건문을 너무 많이 붙여야하는 등 부자연스러웠음
     * @param routes
     * @return
     */
    public int solution2(int[][] routes){
        int answer = 0;
        List<int[]> list = Arrays.stream(routes).sorted((o1, o2) -> o1[0]-o2[0]).collect(Collectors.toList());
        List<Integer> cam = new ArrayList<>();
        int position = list.get(0)[1];

        for (int i = 1; i < list.size(); i++) {

            int[] route = list.get(i);
            int in  = route[0];
            int out = route[1];
            if(in < position){
                if(out>position){
                    position = out;
                }else{
                    cam.add(position);
                }
            }else {
                answer+=1;
                cam.add(position);
                position = out;
            }

        }
        MyUtil.printArray(cam);
        System.out.println();
        System.out.println("answer : "+answer);
        return answer;
    }

    /**
     * https://mishuni.tistory.com/53 참조
     * 나가는 순서대로 오름차순 정렬
     * 먼저 나간 차량을 기준으로 카메라 설치후 다음 차량이 빠져나가는지 확인
     * 못 빠져나가면 카메라 추가
     *
     * 배운점 ?
     * 안되면 다른 기준으로도 정렬해보자
     * 기준점을 바꿔서 생각해보자자
    * @param routes
     * @return
     */
    public int solution3(int[][] routes) {

        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int cnt = 0;

        int min = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (min < route[0]) {
                min = route[1];
                ++cnt;
            }
        }
        return cnt;
    }

  
}
