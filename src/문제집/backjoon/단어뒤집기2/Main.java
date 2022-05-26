package 문제집.backjoon.단어뒤집기2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
21.08.21
문제 유형 : 구현 / 문자열
문제 난이도 : 하
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/단어뒤집기2/input.txt"));

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int N = s.length();
        StringBuilder sb = new StringBuilder();

        int index=0;

        while(index<N){
            // tag 일 때
            if(s.charAt(index) == '<'){
                int temp = index;
                for(int i=index+1;i<N;i++){
                    if(s.charAt(i) == '>'){
                        index = i;
                        break;
                    }
                }
                for(int i=temp;i<=index;i++){
                    sb.append(s.charAt(i));
                }
                index++;
                // tag 가 아닐 때
            }else {
                int temp = index;
                // index 찾아내기
                for(int i=temp;i<N;i++){
                    if(i==N-1 || s.charAt(i+1) == '<' || s.charAt(i) == ' ' || s.charAt(i+1) ==' '){
                        index = i;
                        break;
                    }
                }
                // 단어 뒤집기
                for(int i =index; i>=temp ; i--){
                    sb.append(s.charAt(i));
                }
                index++;
            }
        }
        System.out.println(sb);
    }
}
