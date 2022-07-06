package 문제집.backjoon.균형잡힌세상;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * date: 22.07.06
 */

public class Main {
    static final String NO = "no";
    static final String YES = "yes";
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/균형잡힌세상/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        out: while(true){
            String input = br.readLine();

            if(input.length() == 1){
                break;
            }
            int N = input.length();

            Stack<Character> stack = new Stack<>();

            for(int i=0;i<N;i++){
                char c = input.charAt(i);

                if(c=='(' || c == '['){
                    stack.push(c);
                }else if(c==')'){
                    if(stack.isEmpty() || stack.peek() != '('){
                        System.out.println(NO);
                        continue out;
                    }else if(!stack.isEmpty() && stack.peek() != '('){
                        System.out.println(NO);
                        continue out;
                    }
                    stack.pop();
                }else if(c==']'){
                    if(stack.isEmpty() || stack.peek() != '['){
                        System.out.println(NO);
                        continue out;
                    }else if(!stack.isEmpty() && stack.peek() != '['){
                        System.out.println(NO);
                        continue out;
                    }
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                System.out.println(YES);
            }else{
                System.out.println(NO);
            }
        }
    }
}
