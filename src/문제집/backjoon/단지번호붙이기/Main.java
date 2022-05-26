package 문제집.backjoon.단지번호붙이기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static List<Integer> list;
    static int count;
    static int totalCount;

    static int[] dx= {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/단지번호붙이기/input.txt"));
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        int N = sc.nextInt();
        count=0;
        totalCount=0;

        map = new int[N][N];

        for(int i=0;i<N;i++){
            String input = sc.next();
            for(int j=0;j<N;j++){
                map[i][j] = input.charAt(j)-'0';
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1){
                    dfs(i,j);
                    list.add(count);
                    totalCount++;
                    count=0;
                }
            }
        }
        System.out.println(totalCount);

        Collections.sort(list);

        for(int i : list){
            System.out.println(i);
        }
    }

    private static void dfs(int x, int y) {
        if(isOut(x,y) || map[x][y] != 1){
            return ;
        }
        map[x][y]=7;
        count++;

        for(int i=0;i<4;i++){
            int nx= x+dx[i];
            int ny = y+dy[i];

            dfs(nx,ny);
        }
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
