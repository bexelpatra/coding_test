package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Baek16236_copy {
    static int move = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        getResultBySort(reader);

    }

    // failed...
    // 가장 가까운 다음 물고기를 찾아가는 방식
    // 가는 길의 정보가 투명하게 처리되지 않아 문제가 발생하는듯
    private static void getResultBySort(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());

        List<int[]> list = new ArrayList<>();
        int[][] map = new int[n][n];
        int[] shark = new int[2];
        int moveCount = 0;
        int sharkSize = 2;
        int eatCount = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                int now = Integer.parseInt(st.nextToken());
                map[i][j] = now;
                if (now == 9) {
                    shark[0] = i;
                    shark[1] = j;
                    now = 0;

                } else if (now != 0) {
                    list.add(new int[] { i, j });
                }
            }
        }
        int[] now = shark;
        while (list.size() > 0) {
            int idx = 0;
            int[] next = null;
            while (idx < list.size()) {
                next = list.get(idx);
                if (map[next[0]][next[1]] < sharkSize) {
                    eatCount += 1;
                    if (eatCount == sharkSize) {
                        eatCount = 0;
                        sharkSize += 1;
                    }
                    break;
                }
                idx += 1;
            }
            if (idx == list.size()) {
                idx -= 1;
            }
            list.remove(idx);
            Comparator<int[]> a = getComparator(next[0], next[1]);
            list.sort(a);
            int diffX = now[0] - next[0] >= 0 ? now[0] - next[0] : (now[0] - next[0]) * -1;
            int diffY = now[1] - next[1] >= 0 ? now[1] - next[1] : (now[1] - next[1]) * -1;
            now = next;
            moveCount += (diffX + diffY);
        }
        System.out.println(moveCount);
    }

    public static Comparator<int[]> getComparator(int a, int b) {
        return (x, y) -> {
            int d1 = pow(x[0] - a, 2) + pow(x[1] - b, 2);
            int d2 = pow(y[0] - a, 2) + pow(y[1] - b, 2);
            return d1 - d2;
        };
    }

    public static int pow(int src, int time) {
        for (int i = 0; i < time; i++) {
            src *= src;
        }
        return src;
    }
}
