package 문제집.backjoon.단지번호붙이기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class MainV2 {

    static int[][] map;
    static List<Integer> list;
    static int count;
    static int totalCount;

    static int[] dx= {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] v;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/단지번호붙이기/input.txt"));
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        int N = sc.nextInt();
        count=2;
        totalCount=0;

        map = new int[N][N];


        for(int i=0;i<N;i++){
            String input = sc.next();
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        Queue<int[]> queue = new LinkedList<>();


        print();

         v = new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1 && !v[i][j]){
                    bfs(i,j);
                    count++;
                }
            }
        }

        for(int i : list){
            System.out.println(i);
        }
    }

    private static void bfs(int x, int y) {
        // 0 1
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        v[x][y] = true;
        map[x][y]=count;
        int cnt =0;
        cnt++;

        System.out.println("x = " + x);
        System.out.println("y = " + y);

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            // 0 1
            for(int d=0;d<4;d++){
                int nx = poll[0] + dx[d];
                int ny = poll[1] + dy[d];

                if(isOut(nx,ny) || map[nx][ny] != 1 || v[nx][ny]) continue;

                queue.offer(new int[]{nx,ny});
                // logic
                cnt++;
                map[nx][ny] = count;
                v[nx][ny] = true;
            }
        }
        System.out.println("cnt = " + cnt);
    }

    static boolean isOut(int nx,int ny){
        return nx<0 || nx>=map.length || ny<0 || ny>=map.length;
    }

    static void print(){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map.length;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
