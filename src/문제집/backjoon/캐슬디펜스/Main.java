package 문제집.backjoon.캐슬디펜스;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
M을 3개 뽑기
해당 배열 arr[][]
궁수위치 3개 뽑힘

map에 해당 하는 boolean 배열 만들기

archer = [ {N,0} ,,, … {N,M-1} }
count=0
while count++ <M:
for int[] a : arr :
 * a= 0 1 2    archer[0,1,2]
  boolean 배열에 따라 map 만들기
a[i] 와 map[i]에 대해서 최소 값 구한다
왼쪽부터 쏘므로,
다시 순회하면서 map[i][j] == min 이면 해당 boolean[] 은 false로 변경

boolean 배열 전진
boolean 마지막(N)에 남아있는 true 수 만큼 +
 */

public class Main {

    static int[][] map;
    static int[][] mapTemp;
    static int N, M;
    static int D;
    static int[] archerTemp;
    static List<int[]> archerLocationList;
    static boolean[][] enemies;
    static int wholeCount;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/캐슬디펜스/input.txt"));

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();

        archerLocationList = new ArrayList<>();

        map = new int[N][M];
        mapTemp = new int[N][M];
        enemies = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 어차피 N은 고정
        archerTemp = new int[3];

        setArcherLocation(0, 0);

        int count;
        int result=0;
        for (int[] archer : archerLocationList) {
//            System.out.println("===================================================================");
//            System.out.println("archer = " + Arrays.toString(archer));
            count=0;
            wholeCount =0;
            setEnemies(map);
            while (count++ < M) {
                setMap();
                shotEnemies(archer);
//                System.out.println("wholecount = " + wholeCount);
                moveEnemies();
            }
            result = Math.max(result,wholeCount);
//            System.out.println("result = " + result);
        }
        System.out.println(result);
    }

    private static void shotEnemies(int[] archer) {
        // archer = [0,1,2]

        for (int a : archer) {
            // a = 0, 1, 2
            int findMin = Integer.MAX_VALUE;
            int leftIndex = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (mapTemp[i][j] == 1) {
                        int minus = Math.abs(N - i) + Math.abs(j - a);
                        if(minus <= D){
                            findMin = Math.min(findMin, minus);
                            leftIndex = Math.min(leftIndex,j);
                        }
                    }
                }
            }
            // 가장 왼쪽에 있는 적 공격 <--- 여기서 문제
            // [1,2,4] 일 때를 예로 들었을 때, 예시의 첫번째 값이 사라져야 하는데
            // 다른 값들이 사라짐
            loop: for (int j = 0; j<M; j++) {
                for (int i = N-1; i >= 0; i--) {
                    if (mapTemp[i][j] == 1) {
                        int minus = Math.abs(N - i) + Math.abs(j - a);
                        if(minus == findMin && j == leftIndex){
                            if(enemies[i][j]){
                                wholeCount++;
                            }
                            enemies[i][j] = false;
                            break loop;
                    }
                }
            }
        }
    }
}

    private static void printMapTemp() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(mapTemp[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printEnemies() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(enemies[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (enemies[i][j]) {
                    mapTemp[i][j] = 1;
                } else {
                    mapTemp[i][j] = 0;
                }
            }
        }
    }


    // 덮어씌여짐. 반대로 생각하면서 옮겨야 한다. 마지막 to 처음
    // System.arraycopy(enemies[i], 0, enemies[i + 1], 0, M); <-- 전달형태
    // 헷갈리면 for loop 사용하자.
    static void moveEnemies() {
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < M; j++) {
                enemies[i][j] = enemies[i - 1][j];
            }
        }
        for (int j = 0; j < M; j++) {
            enemies[0][j] = false;
        }
    }

    private static void setEnemies(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    enemies[i][j] = true;
                }else{
                    enemies[i][j] = false;
                }
            }
        }
    }

    private static void setArcherLocation(int start, int count) {
        if (count == 3) {
            archerLocationList.add(archerTemp.clone());
            return;
        }

        for (int i = start; i < M; i++) {
            archerTemp[count] = i;
            setArcherLocation(i + 1, count + 1);
        }
    }
}
