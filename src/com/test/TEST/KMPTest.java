package com.test.TEST;

public class KMPTest {
    public static void main(String[] args) {
        String parent = "bbabaccbaba";
        String pattern = "abaccbaba";
        int[] table = makeTable(pattern);
        int parentLen = parent.length();
        int patternLen = pattern.length();

        int idx = 0;
        for (int i = 0; i < parentLen; i++) {
            while(idx >0 && parent.charAt(i) != pattern.charAt(idx)){
                idx = table[idx -1];
            }
            if(parent.charAt(i) == pattern.charAt(idx)){
                if(idx == patternLen-1){
                    System.out.printf("%d 번째에서 찾았습니다. ~ %d\n",i - idx + 1 , i+1);
                    idx = table[idx];
                }else{
                    idx +=1;
                }
            }
        }
        
    }
    public static int[] makeTable(String pattern){
        int n = pattern.length();
        int[] table = new int[n];
        int idx = 0;
        for (int i = 1; i < n; i++) {
            while(idx >0 && pattern.charAt(i) != pattern.charAt(idx)){
                idx = table[idx-1];
            }
            if(pattern.charAt(i)==pattern.charAt(idx)){
                idx +=1;
                table[i]= idx;
            }
        }
        return table;
    }
}
