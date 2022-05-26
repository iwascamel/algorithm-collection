package 문제집.backjoon.치킨배달;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * date:22.03.08
 */

public class Main0308 {
    static int N,M;
    static int[][] map;
    static List<Point> houseList;
    static List<Point> chickList;
    static int[] temp;
    static int result;

    static class Point{
        int x,y;

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

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/백준51제/구현/치킨배달/input.txt"));

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        temp = new int[M];
        result = Integer.MAX_VALUE;
        map = new int[N][N];

        houseList = new ArrayList<>();
        chickList = new ArrayList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int type = sc.nextInt();
                if(type==1) houseList.add(new Point(i,j));
                else if(type==2) chickList.add(new Point(i,j));
                map[i][j] = type;
            }
        }

        comb(0,0);
        System.out.println(result);
    }

    private static void comb(int cnt, int start) {
        if(cnt==M){
            int sum =0 ;
            for(Point h : houseList){
                int min = Integer.MAX_VALUE;
                for(int j=0;j<M;j++){
                    Point chick = chickList.get(temp[j]);
                    min = Math.min(min, Math.abs(h.x - chick.x) + Math.abs(h.y - chick.y));
                }
                sum += min;
            }
            result = Math.min(result,sum);
            return ;
        }

        for(int i=start;i<chickList.size();i++){
            temp[cnt] = i;
            comb(cnt+1,i+1);
        }
    }
}
