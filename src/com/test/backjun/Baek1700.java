package com.test.backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek1700 {

    public static void main(String[] args) throws Exception{
        sol1();
    }
    public static void solMine()throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] order = new int[k];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < order.length; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] used = new boolean[101];
        int using =0;
        int answer = 0;

        for (int i = 0; i < k; i++) {
            int temp = order[i];
            if (used[temp]){
                continue;
            }
            if (using<n){
                using+=1;
                used[temp] = true;
                continue;
            }
            // 다 채우고 나서는? 다음번에 쓰이나 췤
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < k; j++) {
                if(used[order[j]] && !list.contains(order[j])){
                    list.add(order[j]);
                }
            }

            if (n!= list.size()){ // 이것의 의미를 잘 모르겠네...
                for (int j = 0; j < used.length; j++) {
                    if(used[j] && !list.contains(j)){
                        used[j] = false;
                        break;
                    }
                }
            }else{ // 다 사용된다 -> 마지막에 사용되는 친구를 제거
                int rm = list.get(list.size()-1);
                used[rm] = false;
            }
            used[temp] = true;
            answer+=1;
        }
        System.out.println(answer);
    }
    //https://steady-coding.tistory.com/55
    public static void sol1() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] order = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] use = new boolean[101];
        int put = 0;
        int ans = 0;
        for (int i = 0; i < K; i++) {
            int temp = order[i];

            if (!use[temp]) { // 콘센트가 꽂혀있지 않은 경우
                if (put < N) { // 콘센트를 꽂을 공간이 있는 경우
                    use[temp] = true;
                    put++;
                } else { // 콘센트를 꽂을 공간이 없는 경우
                    ArrayList<Integer> arrList = new ArrayList<>();
                    for (int j = i; j < K; j++) { // 현재 꽂혀 있는 콘센트가 나중에도 사용되는지 확인.
                        if (use[order[j]] && !arrList.contains(order[j])) {
                            arrList.add(order[j]);
                        }
                    }

                    if (arrList.size() != N) { // 나중에도 사용되는 콘센트가 구멍의 개수보다 작을 경우.
                        for (int j = 0; j < use.length; j++) {
                            if (use[j] && !arrList.contains(j)) { // 그 콘센트를 제거.
                                use[j] = false;
                                break;
                            }
                        }
                    } else { // 현재 꽂혀 있는 모든 콘센트가 나중에도 사용될 경우
                        int remove = arrList.get(arrList.size() - 1); // 가장 마지막에 사용될 콘센트를 제거.
                        use[remove] = false;
                    }

                    use[temp] = true;
                    ans++;
                }
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
