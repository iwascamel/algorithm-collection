package 문제집.backjoon.ABCDE;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * date: 22.08.02
 * memo: 연결돼있는개수가 5이상이면 되는거 아닌가 해서 union-find도 생각해봤는데,
 * 생각해보니
 * 0 1
 * 0 2
 * 0 3
 * 0 4
 * 0 5
 *
 * 관계면 모두 연결돼있으나 깊이가 5는 아니라서 답이 아니다. 즉, union-find로 풀리는 문제는 아니였다.
 */

public class MainUnionFind {
    static int N,M;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/ABCDE/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a,b);
        }
        for(int i=0;i<N;i++){
            find(i);
        }
        System.out.println(Arrays.toString(parents));
        System.out.println(count() ? 1 : 0);
    }

    private static boolean count() {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<N;i++){
            map.put(parents[i], map.getOrDefault(parents[i],0)+1);
        }
        Set<Integer> keys = map.keySet();
        for(int key : keys){
            if(map.get(key) >= 5){
                return true;
            }
        }
        return false;
    }

    public static void set(){
        parents = new int[N];
        for(int i=0;i<N;i++){
            parents[i] = i;
        }
    }
    public static int find(int x){
        if(x == parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }
    public static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        parents[aRoot] = bRoot;
    }
}
