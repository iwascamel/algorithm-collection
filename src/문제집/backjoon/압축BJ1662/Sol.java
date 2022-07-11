package 문제집.backjoon.압축BJ1662;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/*
https://sohee-dev.tistory.com/114
 */

public class Sol {
    static int[] rightIdxs = new int[51];
    static String[] input;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/문제집/backjoon/압축BJ1662/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        input = br.readLine().split("");

        for(int i=0; i< input.length; i++) {
            String value = input[i];
            if(value.equals("(")) stack.add(i); // ( 의 위치
            if(value.equals(")")) rightIdxs[stack.pop()] = i; // rightIdxs 배열 [짝궁 '(' 괄호]번째에 ')'의 위치를 할당한다.
        }

        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(rightIdxs));

        System.out.println(getLength(0, input.length));
    }

    private static int getLength(int start, int end) {
        int len = 0;
        for(int i=start; i< end; i++) {
            if(input[i].equals("(")) {
                len += Integer.parseInt(input[i-1]) * getLength(i+1, rightIdxs[i]) -1 ; // -1은 '(' 앞에 있는 문자 길이(1)를 빼는 것!
                i = rightIdxs[i];
            } else {
                len++;
            }
        }
        return len;
    }
}