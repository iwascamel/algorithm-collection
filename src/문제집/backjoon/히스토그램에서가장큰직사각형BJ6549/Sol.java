package 문제집.backjoon.히스토그램에서가장큰직사각형BJ6549;

/*
link: https://loosie.tistory.com/305
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Sol {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/히스토그램에서가장큰직사각형BJ6549/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n =  Integer.parseInt(st.nextToken());
        arr = new int[n+2];
        for(int i=1; i<n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int ans =0;
        for(int i=1; i<n+2; i++) {
            System.out.println("i = " + i);
            while(!stack.isEmpty()) {
                System.out.println("stack = " + stack);
                int top = stack.peek();
                if(arr[top] <= arr[i]) break;
                stack.pop();
                System.out.println("stack.peek() = " + stack.peek());
                System.out.println(i-stack.peek()-1);
                ans = Math.max(ans, arr[top]*(i-stack.peek()-1));
                System.out.println("--------");
            }
            stack.push(i);
        }
        System.out.println(ans);
    }
}
