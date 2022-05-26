package 문제집.backjoon.도로와신호등;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/도로와신호등/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int[][] map = new int[L+1][2];

        for(int i=0; i<N; i++) {
            String[] input2 = br.readLine().split(" ");
            map[Integer.parseInt(input2[0])][0] = Integer.parseInt(input2[1]);
            map[Integer.parseInt(input2[0])][1] = Integer.parseInt(input2[2]);
        }

        int t = 1;
        for(int i=1; i<=L; i++) {
            if(map[i][0]!=0) {
                int x = t%(map[i][0]+map[i][1]);
                if(x>=0 && x<=map[i][0]) {
                    t+=(map[i][0]-x);
                }
            }
            t++;
        }
        System.out.println(t-1);
    }
}
