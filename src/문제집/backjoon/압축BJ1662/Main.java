package 문제집.backjoon.압축BJ1662;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * date: 22.07.10
 */

public class Main {
    static int N;
    static String input;
    static Map<Integer,Integer> map;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/압축BJ1662/input.txt"));

        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        N = input.length();

        Stack<Integer> stack = new Stack<>();
        map = new HashMap<>();

        for(int i=0;i<N;i++){
            char c = input.charAt(i);
            if( c == '('){
                stack.push(i);
            }else if ( c== ')'){
                map.put(stack.pop(),i);
            }
        }
        System.out.println(map);

        System.out.println(getLength(0,N));

    }

    private static int getLength(int start, int end) {
        int len = 0;

        for(int i=start;i<end;i++){
            if(input.charAt(i) == '('){
                len += Integer.parseInt(String.valueOf(input.charAt(i-1))) * (getLength(i+1, map.get(i)))-1;
                i = map.get(i);
            }else{
                len++;
            }
        }
        return len;
    }

}
