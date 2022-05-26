package 문제집.backjoon.압축;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * date : 21.10.22
 * memo : 메모리 초과
 * link : https://codeung.tistory.com/256
 */

public class MainRetry {

    static int result;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/압축/input.txt"));

        Scanner sc= new Scanner(System.in);
        result = 0;

        String[] in = sc.next().split("");

        Stack<String> stack = new Stack<>();

        for(int i=0;i<in.length;i++){
            if(in[i].equals(")")){

            }else{

            }
        }

    }
}
