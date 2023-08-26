package com.test.backjun;

public class FailCompilation {
    public static void main(String[] args) {
        // 실패한 문제
        String[] failList = new String[] { "16236", "2206", "10158", "2565", "1309" };
        String[] failListReason = new String[] { "", "", "", R.A.reason, R.A.reason };

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < failList.length; i++) {
            sb.append(failList[i])
                    .append(" : ")
                    .append(failListReason[i])
                    .append(System.lineSeparator());
        }
        // 다시 풀고싶은 문제
        String[] doOver = new String[] { "1753", "10837" };
        String[] doOverReason = new String[] { "", R.B.reason };

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

    public enum R {
        A("풀이를 생각하지 못함"),
        B("논리보다는 임의로 코드를 수정하며 답을 맞춤"),
        ;

        private String reason;

        private R(String reason) {
            this.reason = reason;
        }
    }
}