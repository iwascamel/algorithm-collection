package 연습.그래프이론;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * date: 22.07.01
 */

public class Prim {
    static int N;
    static int[][] map;
    static int[] distance;
    static boolean[] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/연습/그래프이론/prim.txt"));

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

        Arrays.fill(distance,Integer.MAX_VALUE);
        visited = new boolean[N];

        distance[0] = 0;
        int res = 0;

        for(int i=0;i<N;i++){
            int min =Integer.MAX_VALUE;
            int cur = 0;
            for(int j=0;j<N;j++){
                if(!visited[j] && min > distance[j]){
                    min = distance[j];
                    cur = j;
                }
            }

            visited[cur] = true;
            res += min;

            for(int j=0;j<N;j++){
                if(!visited[j] && map[cur][j] != 0 && distance[j] > map[cur][j]){
                    distance[j] = map[cur][j];
                }
            }
        }
        System.out.println(res);
    }
}
