package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11404 {
    /**
     * @param args
     * @throws IOException
     * @throws NumberFormatException
     */
    static int INF = 987654321;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int[][] map = new int[n+1][n+1];
        StringTokenizer st;
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], INF);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b],c);
        }

        for (int stop = 1; stop < n+1; stop++) {
            for (int from = 1; from < n+1; from++) {
                for (int to = 1; to < n+1; to++) {
                    if(from == to) continue;
                    if(map[from][stop] !=INF && map[stop][to]!=INF){
                        map[from][to] = Math.min(map[from][stop] + map[stop][to],map[from][to]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                sb.append(map[i][j] == INF ? 0:map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
