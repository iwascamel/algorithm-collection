package 문제집.backjoon.치킨배달;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
각 집에서 치킨집까지의 거리를 계산
치킨집 0 1 2
집 1 [1, 2, 6]
  2 [2, 3, 3]
  3 [2, 1, 5]
  4 [2, 1, 3]

치킨집을 고르는 경우 조합으로 계산

선택된 치킨 집 중, 최소값을 추출
ex)  추출 -> 0 1 ( 이 길이는 M 이어야 함 )
집 1은 0번 치킨집 고름 : 1
집 2는 0번 : 2
집 3은 1번 : 1
집 4는 1번 : 1
총 5

해당 최소값들의 합 더하기

문제 제대로 읽기 - 예시로 검증하기 ( 제대로 읽었는 지 확인 + 예상 결과값 도출 + 패턴 도출 )
 */

public class Main {

    static int[][] map;
    static int M;
    static int N;

    static List<int[]> chickenList;
    static List<int[]> houseList;

    static int chickens;
    static int houses;

    static int[][] distance;
    static int[] sumDistance;

    static int[] temp;
    static int result =Integer.MAX_VALUE;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/치킨배달/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        temp = new int[M];
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
        houses = houseList.size();

        distance = new int[houses][chickens];

        for(int i=0;i<houses;i++){
            for(int j=0;j<chickens;j++){
                distance[i][j] = Math.abs(houseList.get(i)[0]-chickenList.get(j)[0]) + Math.abs(houseList.get(i)[1]-chickenList.get(j)[1]);
            }
        }

        sumDistance = new int[chickens];

        getResult(0,0);
        System.out.println(result);
    }
    static void getResult(int start,int cnt){
        if(cnt==M){
            int sum=0;
                for(int i=0;i<houses;i++){
                    int min=Integer.MAX_VALUE;
                    for(int j=0;j<chickens;j++){
                        for(int a : temp){
                            if(a==j){
                                min = Math.min(min,distance[i][j]);
                            }
                        }
                    }
                    sum+=min;
                }
            result = Math.min(result,sum);
            return ;
        }
        for(int i = start; i< chickens; i++){
            temp[cnt] = i;
            getResult(i+1,cnt+1);

        }
    }
}
