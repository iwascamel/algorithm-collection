package 문제집.backjoon.치즈;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * date : 21.09.24
 * type : bfs
 * mistake : 문제를 잘못보고, 밖에 있는 영역만 지우게 했어야 했는데, 안쪽 영역도 같이 지웠음
 */

public class Main {

    static int N,M;
    static int[][] map;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static List<Integer> list;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/치즈/input.txt"));

        Scanner sc = new Scanner(System.in);

        list = new ArrayList<>();
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N+2][M+2];

        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                map[i][j] = sc.nextInt();
            }
        }
        int time = 0 ;
        while(!mapIsZero()){
            list.add(countCheese());
            markAir();
            removeMark();
            time++;
            clearMap();
        }
        Collections.sort(list);
        System.out.println(time);
        System.out.println(list.get(0));
    }

    private static void clearMap() {
        for(int i=0;i<=N+1;i++){
            for(int j=0;j<=M+1;j++){
                if(map[i][j] == 3) map[i][j]=0;
            }
        }
    }

    private static Integer countCheese() {
        int res = 0;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                if(map[i][j] == 1) res++;
            }
        }
        return res;
    }

    private static void removeMark() {
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                if(map[i][j] == 2){
                    map[i][j] = 0;
                }
            }
        }
    }

    static void print(){
        for(int i=0;i<N+2;i++){
            for(int j=0;j<M+2;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void markAir() {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0,0});

        while(!queue.isEmpty()){
            int[] a = queue.poll();

            for(int d=0;d<4;d++){
                int nx = a[0]+dx[d];
                int ny = a[1]+dy[d];

                if(isOut(nx,ny)) continue;

                if(map[nx][ny]==0){
                    queue.offer(new int[]{nx,ny});
                    map[nx][ny] = 3;
                }else if(map[nx][ny]==1){
                    map[nx][ny]=2;
                }
            }
        }
    }

    static boolean isOut(int nx,int ny){
        return nx<0 || ny <0 || nx>= N+2 || ny >= M+2;
    }

    private static boolean mapIsZero() {
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                if(map[i][j] != 0 ) return false;
            }
        }
        return true;
    }
}
