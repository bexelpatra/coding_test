package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 재귀문제였지만 재귀를 깔끔하게 사용하지 못했다.
 * 
 * 정돈된 내용을 보고 다시 재귀로 풀어보자
 */
public class Baek17478 {
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");

        open(0);
        System.out.println(sb.toString());
    }

    static String[] q = new String[] { "\"재귀함수가 뭔가요?\"\n", "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n" };
    static String[] a = new String[] { "\"재귀함수가 뭔가요?\"\n",
            "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n",
            "라고 답변하였지.\n"
    };
    static String tab = "____";

    public static void open(int now) {
        if (n == now) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < now; j++) {
                    sb.append(tab);
                }
                sb.append(a[i]);
            }
            close(now);
            return;
        }
        for (int i = 0; i < q.length; i++) {
            for (int j = 0; j < now; j++) {
                sb.append(tab);
            }
            sb.append(q[i]);
        }
        int next = now + 1;
        open(next);
    }

    public static void close(int now) {
        if (now == 0) {
            return;
        }
        int next = now - 1;
        for (int i = 0; i < next; i++) {
            sb.append(tab);
        }
        sb.append("라고 답변하였지.\n");
        close(next);
    }
}
