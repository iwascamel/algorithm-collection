package 문제집.backjoon.경사로;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int N,L;
    static int[][] map;
    static boolean[][] visited;
    static int result;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/백준51제/구현/경사로/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j] = sc.nextInt();
            }
        }

        LOOP: for(int i=0;i<N;i++){
            for(int j=0;j<N-1;j++){
                if(Math.abs(map[i][j] - map[i][j+1]) > 1) continue LOOP;

                if(map[i][j] - map[i][j+1] == 1){
                    if(LStraightIsPossible(i,j+1,1)){
                        for(int k=j+1;k<j+1+L;k++){
                            visited[i][k] = true;
                        }
                    }else{
                        continue LOOP;
                    }
                }else if(map[i][j+1] - map[i][j] == 1){
                    if(!LReverseIsPossible(i,j,1)) continue LOOP;
                }
            }
            System.out.println("i = " + i);
            result++;
        }
        printVisited();
        visited = new boolean[N][N];
        LOOP: for(int j=0;j<N;j++){
            for(int i=0;i<N-1;i++){
                if(Math.abs(map[i][j] - map[i+1][j]) > 1) continue LOOP;

                if(map[i][j] - map[i+1][j] == 1){
                    if(LStraightIsPossible(i+1,j,-1)){
                        for(int k=i+1;k<i+1+L;k++){
                            visited[k][j] = true;
                        }
                    }else{
                        continue LOOP;
                    }
                }else if(map[i+1][j] - map[i][j] == 1){
                    if(!LReverseIsPossible(i,j,-1)) continue LOOP;
                }
            }
            System.out.println("j = " + j);
            result++;
        }
        System.out.println(result);
    }

    private static void printVisited() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean LStraightIsPossible(int row, int col, int dir){
        int init = map[row][col];
        if(dir==1){
            for(int j=col+1;j<col+L;j++){
                if(j >= N) return false;
                if(map[row][j] != init) return false;
            }
        }else{
            for(int i=row+1;i<row+L;i++){
                if(i>=N) return false;
                if(map[i][col] != init) return false;
            }
        }
        return true;
    }

    static boolean LReverseIsPossible(int row, int col, int dir){
        int init = map[row][col];
        // 이 부분 추가 안해줘서 헤맸다.
        if(visited[row][col]) return false;
        if(dir==1){
            for(int j=col-1;j>col-L;j--){
                if(j < 0) return false;
                if(map[row][j] != init || visited[row][j]) return false;
            }
        }else{
            for(int i=row-1;i>row-L;i--){
                if(i < 0) return false;
                if(map[i][col] != init || visited[i][col]) return false;
            }
        }
        return true;
    }
}
