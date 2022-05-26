package 문제집.backjoon.스타트택시;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * date: 22.04.23
 *
 * https://www.acmicpc.net/board/view/58022
 */

public class MainV2 {
    static int N,M,fuel;
    static int[][] map;
    static int cx,cy;
    static PriorityQueue<int[]> pq;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static boolean negativeFlag;
    static Map<Point,Point> hashMap;
    static boolean isArrive;

    static boolean[][] checkPerson;

    static class Point{
        int x,y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/스타트택시/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        hashMap = new HashMap<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine()," ");
        cx = Integer.parseInt(st.nextToken()) -1;
        cy = Integer.parseInt(st.nextToken()) -1;

        int cnt = 2;
        checkPerson = new boolean[N][N];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;

            map[x][y] =cnt++;
            hashMap.put(new Point(x,y),new Point(x1,y1));
        }

        Comparator<int[]> comp = (o1,o2)->{
            int c1 = o1[2];
            int c2 = o2[2];

            int x1 = o1[0];
            int x2 = o2[0];

            int y1 = o1[1];
            int y2 = o2[1];
            if(c1==c2){
                if(x1==x2){
                    return Integer.compare(y1,y2);
                }else{
                    return Integer.compare(x1,x2);
                }
            }else{
                return Integer.compare(c1,c2);
            }
        };

        negativeFlag = false;
        pq = new PriorityQueue<>(comp);
        while(true){
            pickPerson();
            if(pq.isEmpty()){
                break;
            }
            isArrive = false;
            int[] poll = pq.poll();
            pq.clear();
            int x = poll[0];
            int y = poll[1];
            int distance = poll[2];

            checkPerson[x][y] = true;

            fuel -= distance;

            if(fuel <= 0){
                break;
            }
            cx = x;
            cy = y;

            goToDestination(hashMap.get(new Point(x,y)));
            if(negativeFlag || !isArrive){
                break;
            }
        }

        if(!check() || !isArrive || negativeFlag){
            System.out.println(-1);
        }else{
            System.out.println(fuel);
        }
    }

    private static boolean check() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] > 1 && !checkPerson[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    private static void goToDestination(Point destination) {
        visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{cx,cy,0});
        visited[cx][cy] = true;

        int desX = destination.x;
        int desY = destination.y;

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int cnt = poll[2];

            if(desX == x && desY == y){
                isArrive = true;
                if(fuel - cnt >= 0){
                    cx = x;
                    cy = y;
                    fuel += cnt;
                }else{
                    negativeFlag = true;
                }
                break;
            }

            for(int d=0;d<4;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(isOut(nx,ny) || visited[nx][ny] || map[nx][ny] == 1 ) continue;
    //                if(map[nx][ny] >1 && map[nx][ny] != map[desX][desY]) continue;

                queue.offer(new int[]{nx,ny,cnt+1});
                visited[nx][ny] = true;
            }
        }
    }

    private static void pickPerson() {
        visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{cx,cy,0});
        visited[cx][cy] = true;
        if(map[cx][cy] > 1 && !checkPerson[cx][cy]){
            pq.offer(new int[]{cx,cy,0});
            return ;
        }

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            int x = poll[0];
            int y = poll[1];
            int cnt = poll[2];

            for(int d=0;d<4;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(isOut(nx,ny)) continue;
                if(visited[nx][ny] || map[nx][ny] == 1) continue;

                if(map[nx][ny] > 1 && !checkPerson[nx][ny]){
                    pq.offer(new int[]{nx,ny,cnt+1});
                }

                queue.offer(new int[]{nx,ny,cnt+1});
                visited[nx][ny] = true;
            }
        }
    }

    static boolean isOut(int nx,int ny){
        return nx<0 || ny<0 || nx>=N || ny>=N;
    }

    private static void print() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
