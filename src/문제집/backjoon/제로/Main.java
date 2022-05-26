package 문제집.backjoon.제로;

import java.util.Scanner;
import java.util.Stack;

/**
 * date: 22.05.23
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++){
            int input = sc.nextInt();
            if(input == 0){
                stack.pop();
            }else{
                stack.push(input);
            }
        }
        int sum = 0;
        for(int s : stack){
            sum += s;
        }
        System.out.println(sum);
    }
}
