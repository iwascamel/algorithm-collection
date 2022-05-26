package 문제집.backjoon.아기상어;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * date : 21.08.25
 */

public class Main {

    static int N;
    static int[][] map;
    static Shark shark;
    static Queue<int[]> q;
    static int count;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static Queue<int[]> eatList;

    static boolean[][] v;

    static class Shark{
        int x;
        int y;
        int size;
        int eatAmount;
        public Shark(int x, int y, int size, int eatAmount) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eatAmount = eatAmount;
        }
    }

    static Comparator<int[]> comp = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            int compare3 = Integer.compare(o1[2],o2[2]);
            if(compare3!=0){
                return compare3;
            }else{
                int compareX = Integer.compare(o1[0],o2[0]);
                if(compareX !=0){
                    return compareX;
                }else{
                    return Integer.compare(o1[1],o2[1]);
                }
            }
        }
    };

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/아기상어/input.txt"));

        Scanner sc = new Scanner(System.in);
        int tempX=0;
        int tempY=0;
        N = sc.nextInt();
        map = new int[N][N];
        v = new boolean[N][N];
        count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int loc = sc.nextInt();
                if(loc == 9){
                   tempX = i;
                   tempY = j;
                   map[i][j] = 0;
                }else{
                    map[i][j] = loc;
                }
            }
        }
        shark = new Shark(tempX,tempY,2,0);
        q = new LinkedList<>();
        eatList = new PriorityQueue<>(comp);

        while(true){
//            System.out.println("shark 위치는 x = " + shark.x + "  y = " + shark.y);
//            System.out.println("count = " + count);
            q.offer(new int[]{shark.x,shark.y,0});
            v = new boolean[N][N];
            eatList.clear();
            while(!q.isEmpty()){
                int[] poll = q.poll();
                for(int i=0;i<4;i++){
                    int nx = poll[0] + dx[i];
                    int ny = poll[1] + dy[i];

                    if(!isOut(nx,ny) && !v[nx][ny]  && map[nx][ny] <= shark.size){
                        q.offer(new int[]{nx,ny,poll[2]+1});
                        if(map[nx][ny]!=0 && map[nx][ny] < shark.size){
                            eatList.offer(new int[]{nx,ny,poll[2]+1});
                        }
                        v[nx][ny] = true;
                    }
                }
            }
//            printEatList();
//            System.out.println("====");
            if(eatList.isEmpty()){
                System.out.println(count);
                break;
            }else{
                int[] eat = eatList.poll();
                shark.eatAmount += 1;
                if(shark.eatAmount == shark.size){
                    shark.size++;
                    shark.eatAmount =0;
                }
                count += eat[2];
                map[eat[0]][eat[1]] = 0;
                shark.x = eat[0];
                shark.y = eat[1];
            }
        }

    }

    private static void printEatList() {
        for(int[] a : eatList){
            System.out.println(Arrays.toString(a));
        }
    }

    static boolean isOut(int nx,int ny){
        return nx<0 || nx>=N || ny<0 || ny>=N;
    }
}
