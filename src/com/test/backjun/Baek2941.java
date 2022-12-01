package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2941 {
    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 10; i++) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            sol(reader);
        }
    }

    private static void sol(BufferedReader reader) throws IOException {
        char[] now = reader.readLine().toCharArray();
        int total = now.length;
        int answer = 0;
        for (int i = 1; i < now.length; i++) {
            if(now[i] == '='){
                if(now[i-1]=='c'||now[i-1]=='s'){
                    answer+=1;
                }else if(now[i-1]=='z'){
                    if(i-2>=0&&now[i-2]=='d'){
                        answer+=2;
                    }else{
                        answer+=1;
                    }
                }
            }else if(now[i] == '-'){
                if(now[i-1]=='c'||now[i-1]=='d'){
                    answer+=1;
                }
            }else if(now[i] == 'j'){
                if(now[i-1]=='l'||now[i-1]=='n'){
                    answer+=1;
                }
            }
        }
        System.out.println(total-answer);
    }
}
