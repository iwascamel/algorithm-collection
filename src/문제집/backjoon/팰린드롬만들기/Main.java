package 문제집.backjoon.팰린드롬만들기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * date : 21.09.04
 * backjoon 1213번
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/팰린드롬만들기/input.txt"));

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        char[] charList = input.toCharArray();

        Arrays.sort(charList);

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int N = input.length();

        // 짝수일 때
        if(N%2==0){
            for(int i=0;i<N;i=i+2){
                sb1.append(charList[i]);
            }
            for(int i=1;i<N;i=i+2){
                sb2.append(charList[i]);
            }
            if(!sb1.toString().equals(sb2.toString())){
                System.out.println("I'm Sorry Hansoo");
            }else{
                String reverse = sb2.reverse().toString();
                System.out.println(sb1 + reverse);
            }
        }else{
            // 홀수일 때
            /**
             * todo : middle 값 설정하기
             */
            char middle = 0;

            for(int i=0;i<N-1;i=i+2){
                char c1 = charList[i];
                char c2 = charList[i+1];

                if(c1==c2){
                    sb1.append(c1);
                    sb2.append(c2);
                }else{
                    middle=c1;
                    i-=1;
                }
            }
            if(!sb1.toString().equals(sb2.toString())){
                System.out.println("I'm Sorry Hansoo");
            }else{
                System.out.println(sb1 + String.valueOf(middle) + sb2.reverse());
            }

        }
    }
}
