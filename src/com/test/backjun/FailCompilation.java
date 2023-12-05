package com.test.backjun;

public class FailCompilation {
    public static void main(String[] args) {
        // 실패한 문제

        String[] failList = new String[] { "16236", "2206", "10158", "2565", "1309", "11049", "1967", "13164", "2138",
                "10971", "10972", "1057", "2470", "1629" ,"3015","b_4179"};
        String[] failListReason = new String[] { "", "", "", R.A.reason, R.A.reason, R.A.reason, R.C.reason, R.A.reason,
                R.A.reason, "백트래킹, 조합, 순열 다시 연습...", "간단해 보이는데 멀리 돌아가버리고 있다...", "순열 문제에서 생각해볼 만한 것...재귀가 능사는 아니다.",
                "이분탐색 같아서 풀었는데 어떤 점에서 틀린건지 못 찾겠다.", "모듈러 연산에 대해 전혀 몰랐다.","Stack에 대해서..." ,"메모리 초과가 나오는데 아직 이유를 모르겠다."};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < failList.length; i++) {
            sb.append(failList[i])
                    .append(" : ")
                    .append(failListReason[i])
                    .append(System.lineSeparator());
        }
        // 다시 풀고싶은 문제
        String[] doOver = new String[] { "1753", "10837", "1238", "1021", "5397", "10819", "18352", "15683", "3986" };
        String[] doOverReason = new String[] { "", R.B.reason, R.A.reason, R.D.reason, R.E.reason, "문제 푸는 방법이 따로 있는듯",
                "다익스트라 다시 한번 더", "속도가 너무 느리고 코드가 간결하지 못하다", "스택쓰지 않고 바로 풀어보는 방법 연습" };

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
        C("반례가 있는 풀이들을 떠올림"),
        D("떠올린 풀이의 구현이 복잡해서 미뤄둠"),
        E("더 좋은 다른 방법으로 풀고싶음"),
        ;

        private String reason;

        private R(String reason) {
            this.reason = reason;
        }
    }
}