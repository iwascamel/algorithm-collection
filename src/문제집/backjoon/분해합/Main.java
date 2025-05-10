package 문제집.backjoon.분해합;

import java.io.*;

/**
 * 25.05.07
 */

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/분해합/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int target = Integer.parseInt(s);
        int result = 0;

        for(int i=0; i<target; i++){
            int current = i;
            int sum = 0;

            while (current != 0){
                sum += current % 10;
                current /= 10;
            }

            if(i + sum == target){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
