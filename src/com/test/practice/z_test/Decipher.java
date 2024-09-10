package com.test.practice.z_test;

// import org.junit.Test;

public class Decipher {
    public int solution(String s) {
        int answer = 1;
        char[] chars = s.toCharArray();
        for(int i=0; i< s.length();i++){
            for(int j=s.length()-1; j>i;j--){
                if(chars[i]== chars[j]){

                }else {
                    break;
                }
            }
        }

        return answer;
    }

    public int solution2(String s) {
        int answer = 1;
        char[] chars = s.toCharArray();
        int initPalindromeLen =0;
        // 1. 회문의 중심을 찾는다.
        // 1-1. 이때 회문 중심의 길이는 2 또는 3이다.
        // 2. 중심부에서 왼쪽, 오른쪽으로 한칸씩 확인하면서 확장
        for(int i=0; i< s.length()-1;i++){
            // 시작 회문의 길이가 3인 경우 ex) aba
            int left = 0;
            int right = 0;
            if(i+2 <= s.length()-1&&chars[i]==chars[i+2]){
                left = i;
                right = i+2;
                initPalindromeLen = 3;
                initPalindromeLen = check(initPalindromeLen,chars,left,right);

            }
            answer = Math.max(answer,initPalindromeLen);

            // 시작 회문의 길이가 2인 경우 ex) aa
            if(chars[i] ==chars[i+1]){
                left = i;
                right = i+1;
                initPalindromeLen = 2;
                initPalindromeLen = check(initPalindromeLen,chars,left,right);

            }
            answer = Math.max(answer,initPalindromeLen);
        }
        System.out.println(s +":"+answer);
        return answer;
    }

    // 회문의 길이 찾기
    private int check(int initPalindromeLen, char[] chars, int left, int right){

        while(left-1>=0 && right+1<=chars.length-1 && chars[left] == chars[right]){
            left-=1;
            right+=1;
            if(chars[left] == chars[right]){
                initPalindromeLen+=2;
            }else {
                break;
            }
        }

        return initPalindromeLen;
    }

    public String solution3(String s) {
//        int answer = 1;
        String answer = String.valueOf(s.charAt(0));
        String palindrome = "";
        char[] chars = s.toCharArray();
        int initPalindromeLen =0;
        // 1. 회문의 중심을 찾는다.
        // 1-1. 이때 회문 중심의 길이는 2 또는 3이다.
        // 2. 중심부에서 왼쪽, 오른쪽으로 한칸씩 확인하면서 확장
        for(int i=0; i< s.length()-1;i++){
            // 시작 회문의 길이가 3인 경우 ex) aba
            int left = 0;
            int right = 0;
            if(i+2 <= s.length()-1&&chars[i]==chars[i+2]){
                left = i;
                right = i+2;
                initPalindromeLen = 3;
                palindrome = s.substring(left,right+1);
                initPalindromeLen = check(initPalindromeLen,chars,left,right);
                palindrome = check2(palindrome,chars,left,right);

            }
            if(answer.length() < palindrome.length()) answer = palindrome;

            // 시작 회문의 길이가 2인 경우 ex) aa
            if(chars[i] ==chars[i+1]){
                left = i;
                right = i+1;
                initPalindromeLen = 2;
                palindrome = s.substring(left,right+1);
                palindrome = check2(palindrome,chars,left,right);

            }
            if(answer.length() < palindrome.length()) answer = palindrome;
        }
        System.out.println(s +":"+answer);
        return answer;
    }

    // 회문의 길이 찾기
    private String check2(String initPalindromeLen, char[] chars, int left, int right){

        while(left-1>=0 && right+1<=chars.length-1 && chars[left] == chars[right]){
            left-=1;
            right+=1;
            if(chars[left] == chars[right]){
                initPalindromeLen = chars[left]+initPalindromeLen+chars[right];
            }else {
                break;
            }
        }

        return initPalindromeLen;
    }

    // @Test
    // public void test(){
    //     solution3("aba");
    //     solution3("토마토맛수프맛프수");
    //     solution3("xabay");
    //     solution3("abcdee");
    //     solution3("aa");
    //     solution3("a");
    //     solution3("ae");
    //     solution3("aaee");
    //     solution3("aaa");
    //     solution3("aaae");
    //     solution3("aaaee");
    //     solution3("aaaeeee");
    //     solution3("aaaa");
    //     solution3("aaaaaㅁㄴㅇㄻㄴ아리러릏eeeeeeekㅐㅇ9ㄻ9ㄴㄴㄴㄴ");
    // }
}
