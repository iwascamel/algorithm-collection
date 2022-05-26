package 문제집.backjoon.색종이붙이기;

import java.util.Scanner;

/**
 * link : https://daily-life-of-bsh.tistory.com/141
 */

public class Sol {
    static int[][] map = new int[10][10];
    static int[] paper = {0,5,5,5,5,5};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        DFS(0, 0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void DFS(int r, int c, int cnt) {
        if(r >= 9 && c > 9) {
            answer = Math.min(answer, cnt);
            return;
        }

        if(answer <= cnt) return;

        if(c > 9) {
            DFS(r+1, 0, cnt);
            return;
        }

        if(map[r][c] == 1) {
            for(int i=5; i>=1; i--) {
                if(paper[i] > 0 && check(r, c, i)) {
                    papering(r, c, i, 0);
                    paper[i]--;
                    DFS(r, c+1, cnt+1);
                    papering(r, c, i, 1);
                    paper[i]++;
                }
            }
        } else DFS(r, c+1, cnt);
    }

    public static void papering(int x, int y, int size, int state) {
        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                map[i][j] = state;
            }
        }
    }

    public static boolean check(int x, int y, int size) {
        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(!isInside(i, j) || map[i][j] != 1) return false;
            }
        }
        return true;
    }

    public static boolean isInside(int x, int y) {
        return x>=0 && x<10 && y>=0 && y<10;
    }

}