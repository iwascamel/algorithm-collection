package 문제집.backjoon.올림픽;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * date: 22.07.06
 */

public class Main {
    static int N,K;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/올림픽/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][4];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int index = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            arr[i][0] = gold;
            arr[i][1] = silver;
            arr[i][2] = bronze;
            arr[i][3] = index;
        }

        Arrays.sort(arr, (o1, o2) -> {
            int g1 = o1[0];
            int g2 = o2[0];

            int s1 = o1[1];
            int s2 = o2[1];

            int b1 = o1[2];
            int b2 = o2[2];

            if(g1==g2){
                if(s1==s2){
                    return Integer.compare(b2,b1);
                }else{
                    return Integer.compare(s2,s1);
                }
            }else{
                return Integer.compare(g2,g1);
            }
        });

        Map<Integer,Integer> map = new HashMap<>();
        int grade = 1;
        int stack = 0;
        map.put(arr[0][3],1);

        for(int i=1;i<N;i++){
            int gold = arr[i][0];
            int silver = arr[i][1];
            int bronze = arr[i][2];

            int bg = arr[i-1][0];
            int bs = arr[i-1][1];
            int bb = arr[i-1][2];

            if(gold == bg && silver == bs && bronze == bb){
                map.put(arr[i][3],grade);
                stack++;
            }else{
                grade += stack + 1;
                stack = 0;
                map.put(arr[i][3],grade);
            }
        }
        System.out.println(map);
        System.out.println(map.get(K));
    }
}
