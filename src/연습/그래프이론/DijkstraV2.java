package 연습.그래프이론;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 22.07.01
 * memo: 두번째 연습
 */

 import java.util.*;
 import java.io.*;

public class DijkstraV2 {
    static int N;
    static int[][] map;
    static int[] distance;
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/연습/그래프이론/DijkstraInput.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        distance = new int[N];
        boolean[] visited = new boolean[N];

        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0] = 0;

        for(int i=0;i<N;i++){
            int min = Integer.MAX_VALUE;
            int cur = 0;
            
            for(int j=0;j<N;j++){
                if(!visited[j] && min > distance[j]){
                    min = distance[j];
                    cur = j;
                }
            }
            visited[cur] = true;

            for(int j=0;j<N;j++){
                if(!visited[j] && map[cur][j] != 0 && distance[j] > min + map[cur][j]){
                    distance[j] = min + map[cur][j];
                }
            }
        }
        System.out.println(Arrays.toString(distance));
    }
}
