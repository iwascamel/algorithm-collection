package 문제집.backjoon.거짓말;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * date: 22.02.19
 * memo : 1%에서 오류났던 이유:
 * union 을 할 때,if 조건을 걸지 않으면 아래와 같은 경우에서 오답이 난다.
 * 3
 * 3 8
 * 8로 union 이 되면, 8 8 이 돼서 3에 걸리지 않음.
 */

public class Main {
    static int N,M,C;
    static int[] parents;
    static List<Integer> checkList;

    static void set(){
        parents = new int[N+1];

        for(int i=1;i<N+1;i++){
            parents[i] = i;
        }
    }
    static int find(int a){
        if(parents[a] == a) return a;
        else return parents[a]= find(parents[a]);
    }
    static void union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(checkList.contains(aRoot)){
            int tmp = aRoot;
            aRoot = bRoot;
            bRoot = tmp;
        }

        parents[bRoot] = aRoot;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/거짓말/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        C = sc.nextInt();
        checkList = new ArrayList<>();

        set();

        for(int i=0;i<C;i++){
            checkList.add(sc.nextInt());
        }
        for(int i=0;i<C-1;i++){
            union(checkList.get(i),checkList.get(i+1));
        }

        List<int[]> peoplesList = new ArrayList<>();
        int cnt = 0;

        for(int i=0;i<M;i++){
            int n = sc.nextInt();
            int[] peoples = new int[n];

            for(int j=0;j<n;j++){
                peoples[j] = sc.nextInt();
            }
            peoplesList.add(peoples);

            unionArrays(peoples);
        }

        a: for(int[] tmp : peoplesList){
            for (int k : tmp) {
                for (int c : checkList) {
                    if (find(c) == find(k)) {
                        continue a;
                    }
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }

    private static void unionArrays(int[] peoples) {
        for(int i=0;i< peoples.length-1;i++){
            union(peoples[i],peoples[i+1]);
        }
    }
}
