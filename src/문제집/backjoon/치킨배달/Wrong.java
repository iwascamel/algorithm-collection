package 문제집.backjoon.치킨배달;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
1. 1, 2의 위치를 저장
2. 2의 위치 중 M개를 뽑고, 해당 M개의 위치와 집 자리를 뺌
3. 그 중 최소값 출력
 */
public class Wrong {

    static int[][] map;
    static int M;
    static int N;

    static List<int[]> chickenList;
    static List<int[]> houseList;

    static int chickens;

    static int[][] temp;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/치킨배달/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N+1][N+1];
        chickenList = new ArrayList<>();
        houseList = new ArrayList<>();

        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                map[i][j] = sc.nextInt();
                if(map[i][j]==2){
                    chickenList.add(new int[]{i,j});
                }
                if(map[i][j]==1){
                    houseList.add(new int[]{i,j});
                }
            }
        }
        chickens = chickenList.size();

        temp = new int[M][2];

        getResult(0,0);

        System.out.println(result);

    }
    static void getResult(int start,int cnt){
        if(cnt==M){
            int sum=0;
            for(int[] arr : temp){
                sum += getDiffer(arr);
            }
            System.out.println(sum);
            result = Math.min(sum,result);
            return ;
        }
        for(int i = start; i< chickens; i++){
            temp[cnt] = chickenList.get(i);
            getResult(i+1,cnt+1);

        }
    }
    static int getDiffer(int[] arr){
        int sum = 0;

        for(int[] a : houseList){
            sum += Math.abs(a[0] - arr[0]) + Math.abs(a[1] - arr[1]);
        }
        return sum;
    }
}
