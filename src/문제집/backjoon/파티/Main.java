package 문제집.backjoon.파티;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * date: 22.01.02
 * link : https://www.acmicpc.net/problem/1238
 * 풀이 :
 * [
 * 1->2
 * 2->2
 * 3->2
 * 4->2
 *
 * 최단시간 구하기
 * 다익스트라로 각 최단 시간을 구해서 더하기
 *
 * 2에서 다익스트라 구하기
 * 해당 값 각 배열에 더해주기
 * ]
 */

public class Main {

    static int N,M,X;
    static int[] distance;
    static int[][] matrix;
    static boolean[] visited;

    static int[] goToParty;
    static int[] partyToHome;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/파티/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        matrix = new int[N+1][N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            matrix[start][end] = weight;
        }

        goToParty = new int[N+1];
        partyToHome = new int[N+1];
        distance = new int[N+1];

        for(int h=1;h<N+1;h++){
            visited = new boolean[N+1];
            Arrays.fill(distance,INF);

            distance[h] = 0;
            int current=h;

            for(int i=1;i<N+1;i++){
                int min = INF;

                for(int j=1;j<N+1;j++){
                    if(!visited[j] && min > distance[j]){
                        min = distance[j];
                        current = j;
                    }
                }
                visited[current] = true;

                // 시간초과 -> break 넣어주니까 해결
                if(current == X) break;

                for(int j=1;j<N+1;j++){
                    if(!visited[j] && matrix[current][j]!=0 &&
                        distance[j] > min + matrix[current][j]
                    ){
                        distance[j] = min + matrix[current][j];
                    }
                }
            }
            goToParty[h] = distance[X];
        }

        visited = new boolean[N+1];
        Arrays.fill(distance,INF);

        distance[X] = 0;
        int current=X;

        for(int i=1;i<N+1;i++){
            int min = INF;

            for(int j=1;j<N+1;j++){
                if(!visited[j] && min > distance[j]){
                    min = distance[j];
                    current = j;
                }
            }
            visited[current] = true;

            for(int j=1;j<N+1;j++){
                if(!visited[j] && matrix[current][j]!=0 &&
                        distance[j] > min + matrix[current][j]
                ){
                    distance[j] = min + matrix[current][j];
                }
            }
        }

        int result = 0;

        for(int i=1;i<N+1;i++){
            result = Math.max(result, goToParty[i] + distance[i]);
        }
        System.out.println(result);
    }

    private static void print() {
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
