package 문제집.backjoon.벽부수고이동하기4;

import java.io.*;
import java.util.*;

/**
 * date: 22.04.07
 * memo : 그냥 bfs 돌리면 시간초과
 * link : https://devowen.com/253
 */

public class MainV2 {
    static int N,M;
    static int[][] map;
    static int[][] countMap;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int[][] resultMap;
    static Map<Integer,Integer> hash;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/벽부수고이동하기4/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        countMap = new int[N][M];
        resultMap = new int[N][M];
        hash = new HashMap<>();
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }
        for(int i=0;i<N;i++){
            countMap[i] = map[i].clone();
        }

        hash.put(0,0);
        hash.put(1,0);

        int cnt =2;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    int amount = dfs(i, j, cnt);
                    hash.put(cnt++,amount);
                }
            }
        }
//        System.out.println(hash);
//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                System.out.print(countMap[i][j] + " ");
//            }
//            System.out.println();
//        }
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 1){
                    int n = countDirs(i, j);
                    resultMap[i][j] = (n+1)%10;
                    sb.append(resultMap[i][j]);
                }else{
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int countDirs(int x, int y) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for(int d=0;d<4;d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(isOut(nx,ny) || map[nx][ny] == 1 || set.contains(map[nx][ny])) continue;

            set.add(countMap[nx][ny]);
            res += hash.get(countMap[nx][ny]);
        }

        return res;
    }

    private static void print() {
        for(int a=0;a<N;a++){
            for(int b=0;b<M;b++){
                System.out.print(countMap[a][b] + " ");
            }
            System.out.println();
        }
    }

    static int dfs(int i, int j, int num) {
        int cnt = 1;
        visited[i][j] = true;
        countMap[i][j] = num;

        for (int d = 0; d < 4; d++) {
            int nr = i + dx[d];
            int nc = j + dy[d];

            if ( isOut(nr,nc)|| visited[nr][nc] || map[nr][nc] == 1) {
                continue;
            }

            cnt += dfs(nr, nc, num);
        }

        return cnt;
    }

    private static int set(int x, int y,int cnt) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][M];
        int amount =0 ;

        queue.offer(new int[]{x,y});
        countMap[x][y] = cnt;
        amount++;
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            int x1 = poll[0];
            int y1 = poll[1];

            for(int d=0;d<4;d++){
                int nx = x1 + dx[d];
                int ny = y1 + dy[d];

                if(isOut(nx,ny) || visited[nx][ny] || map[nx][ny] != 0 ) continue;

                queue.offer(new int[]{nx,ny});
                visited[nx][ny] = true;
                countMap[nx][ny] = cnt;
                amount++;
            }
        }
        return amount;
    }
    static boolean isOut(int nx,int ny){
        return nx<0 || ny<0 || nx>=N || ny>=M;
    }
}
