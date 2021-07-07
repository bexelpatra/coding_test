package com.test.practice.g_dynamic_programming;

public class DynamicProgramming_2 {
    int answer = Integer.MIN_VALUE;
    // 실패작... 위에서부터 아래로 내려가면서 재귀하려고 했음
    public int solution(int[][] triangle) {
        dfs(triangle,0,0,0,"");
        System.out.println("answer : "+ answer);
        return answer;
    }
    public void dfs(int[][] triangle,int layer,int index,int sum,String x){
        System.out.println(x);
        if(layer >= triangle.length-1) {
            answer = Math.max(sum,answer);
            return;
        }
        int maxLen = triangle[layer].length-1;
        layer+=1;
        dfs(triangle,layer,index,sum +triangle[layer][index],sum+""+triangle[layer][index]);
        if(maxLen > index+1){
            dfs(triangle,layer,index+1,sum +triangle[layer][index+1],sum+""+triangle[layer][index+1]);
        }
    }

    // 아래서부터 인접한  두개의 수에서 큰 수를 위에있는 층의 숫자와 더한다.
    public int solution2(int[][] triangle) {

        System.out.println("answer : "+ answer);
        for(int i = triangle.length-1;i>=1;i--){
            int[] upperLayer = triangle[i-1];
            int[] downLayer = triangle[i];
            for(int j=0;j<downLayer.length-1;j++){
                int a = Math.max(downLayer[j],downLayer[j+1]);
                upperLayer[j]+=a;
            }
        }
        System.out.println(triangle[0][0]);
        return answer;
    }
}
