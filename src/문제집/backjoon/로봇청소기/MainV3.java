package 문제집.backjoon.로봇청소기;

import java.io.*;
import java.util.*;

/**
 * date: 22.04.11
 * memo : 4991번
 */

public class MainV3 {
    static int N,M;
    static char[][] map;

    static class Info{
        int x;
        int y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static List<Info> stars;
    static int[] temp;
    static int cx;
    static int cy;
    static int cn;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int[][] distance;
    static int cur;
    static int answer;
    static int[] startToStars;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/로봇청소기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st= new StringTokenizer(br.readLine(), " ");

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            stars = new ArrayList<>();
            cn = 0;

            if(N==0 || M ==0) break;

            map = new char[N][M];

            for(int i=0;i<N;i++){
                String s= br.readLine();
                for(int j=0;j<M;j++){
                    char c = s.charAt(j);
                    map[i][j] = c;

                    if(c=='o'){
                        cx = i;
                        cy = j;
                    }else if(c=='*'){
                        stars.add(new Info(i,j));
                        cn++;
                    }
                }
            }
            temp = new int[cn];
            distance = new int[cn][cn];
            startToStars = new int[cn];

            for(int i=0;i<cn;i++){
                for(int j=0;j<cn;j++){
                    distance[i][j] = -1;
                }
            }

            for(int i=0;i<cn;i++){
                Info info1 = stars.get(i);
                for(int j=i;j<cn;j++){
                    if(j==i) continue;
                    Info info2 = stars.get(j);

                    distance[i][j] = bfs(info1.x,info1.y,info2.x,info2.y);
                    distance[j][i] = distance[i][j];
                }
                startToStars[i] = bfs(cx,cy,info1.x,info1.y);
            }

            answer = Integer.MAX_VALUE;
            per(0,0);

            if(answer==0){
                sb.append(-1);
            }else{
                sb.append(answer);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void printDistance() {
        for(int i=0;i<cn;i++){
            for(int j=0;j<cn;j++){
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int bfs(int sx, int sy, int x, int y) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        queue.offer(new int[]{sx,sy,0});
        boolean[][] visited = new boolean[N][M];
        visited[sx][sy] = true;

        int answer = 0;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int x1 = poll[0];
            int y1 = poll[1];
            int cnt = poll[2];

            if(x1 == x && y1 == y){
                answer = cnt;
                break;
            }

            for(int d=0;d<4;d++){
                int nx = x1 + dx[d];
                int ny = y1 + dy[d];

                if(isOut(nx,ny) || visited[nx][ny] || map[nx][ny] == 'x') continue;

                queue.offer(new int[]{nx,ny,cnt+1});
                visited[nx][ny] = true;
            }
        }
        return answer;
    }

    static boolean isOut(int nx, int ny){
        return nx<0 || ny<0 || nx>=N || ny>=M;
    }

    private static void per(int cnt,int flag) {
        if(cnt==cn){
            int res = 0;
            res += startToStars[temp[0]];

            for(int i=0;i<cn-1;i++){
                int start = temp[i];
                int end = temp[i+1];

                if(distance[start][end]==0){
                    answer = -1;
                    return ;
                }
                res += distance[start][end];
            }
            answer = Math.min(answer,res);
            return ;
        }

        for(int i=0;i<cn;i++){
            if( (flag & 1 << i) != 0) continue;
            temp[cnt] = i;
            per(cnt+1, flag | 1 << i);
        }
    }

    private static void print() {
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(map[i][j] +  "  ");
            }
            System.out.println();
        }
    }
}
