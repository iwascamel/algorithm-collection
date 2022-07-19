package 문제집.backjoon.괄호의값BJ2504;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * date: 22.07.18
 */

public class Main {
    static String iv;
    static int N;
    static Map<Integer,Integer> map;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/괄호의값BJ2504/input.txt"));

        Scanner sc = new Scanner(System.in);
        iv = sc.next();
        N = iv.length();

        Stack<Integer> stack = new Stack<>();
        map = new HashMap<>();
        boolean flag = true;

        for(int i=0;i<N;i++){
            if(iv.charAt(i) == '(' || iv.charAt(i) == '['){
                stack.push(i);
            }else if(iv.charAt(i) == ')'){
                if(stack.isEmpty() || iv.charAt(stack.peek()) != '('){
                    flag = false;
                    break;
                }
                map.put(stack.pop(),i);
            }else if(iv.charAt(i) == ']'){
                if(stack.isEmpty() || iv.charAt(stack.peek()) != '['){
                    flag = false;
                    break;
                }
                map.put(stack.pop(),i);
            }
        }

        if(flag){

        }else{
            System.out.println(0);
        }

    }

    private static int getLength(int start, int end) {
        List<Integer> list = new ArrayList<>();
        return 1;

    }
}
