package 문제집.backjoon.K번째수;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/K번째수/input.txt"));

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        int start = 1;
        int end = K;

        while(start < end){
            int middle = (start+end)/2;

            int count = 0;

            for(int i=1;i<=N;i++){
                count += Math.min(middle/i,N);
            }

            if(count >= K){
                end = middle;
            }else{
                start = middle+1;
            }
        }
        System.out.println(start);
    }
}
