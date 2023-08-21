package com.test.backjun;

public class FailCompilation {
    public static void main(String[] args) {
        // 실패한 문제
        String[] failList = new String[] { "16236", "2206", "10158" };
        String[] failListReason = new String[] { "", "", "" };

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < failList.length; i++) {
            sb.append(failList[i])
                    .append(" : ")
                    .append(failListReason[i])
                    .append(System.lineSeparator());
        }
        // 다시 풀고싶은 문제
        String[] doOver = new String[] { "1753", "10837" };
        String[] doOverReason = new String[] { "", "맞긴는 했는데 값을 중간에는 값을 넣으면서 때려맞춘 느낌" };

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < doOver.length; i++) {
            sb2.append(doOver[i])
                    .append(" : ")
                    .append(doOverReason[i])
                    .append(System.lineSeparator());
        }

        System.out.println(sb.toString());
        System.out.println(sb2.toString());
    }
}
