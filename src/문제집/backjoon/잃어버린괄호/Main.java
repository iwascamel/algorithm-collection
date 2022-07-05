package 문제집.backjoon.잃어버린괄호;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * date: 22.07.05
 */

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/잃어버린괄호/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sp1 = br.readLine().split("-");

        int sum = 0;
        for(int i=0;i< sp1.length;i++){
            String[] sp2 = sp1[i].split("[+]");

            int temp = 0;
            for(String s : sp2){
                temp += Integer.parseInt(s);
            }
            if(i==0){
                sum += temp;
            }else{
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
