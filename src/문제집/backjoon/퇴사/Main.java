package 문제집.backjoon.퇴사;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * date: 22.03.17
 * memo: dfs 로 풀라고 했는데, fail
 */

public class Main {
    static int N;
    static boolean[] isAble;
    static int result;
    static List<Integer> list;
    static class Info{
        int index;
        int cost;

        public Info(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "{" +
                    "index=" + index +
                    ", cost=" + cost +
                    '}';
        }
    }
    static Info[] infos;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/퇴사/input.txt"));

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        infos = new Info[N];
        list = new ArrayList<>();

        for(int i=0;i<N;i++){
            int index = sc.nextInt();
            int cost = sc.nextInt();
            infos[i] = new Info(index,cost);
        }
        isAble = new boolean[N];

        for(int i=0;i<N;i++){
            Info info = infos[i];
            if(info.index + i < N) isAble[i] = true;
        }

        for(int i=0;i<N;i++){
            dfs(i,0);
        }
        System.out.println(result);
    }

    private static void dfs(int p, int cnt) {
        if(p >= N){
            result = Math.max(result,cnt);
            System.out.println(list);
            System.out.println("cnt = " + cnt);
            list.clear();
            return;
        }

        if(p+infos[p].index < N && isAble[p]){
            dfs(p+infos[p].index ,cnt+infos[p].cost);
            list.add(p);
        }else{
            dfs(p+1,cnt);
        }
    }
}
