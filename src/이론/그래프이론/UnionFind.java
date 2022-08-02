package 이론.그래프이론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * date: 22.08.02
 * https://www.acmicpc.net/problem/13023
 * 위와 같이 입력값이 주어졌을 때
 * (해당 문제는 union-find 문제는 아니다. depth가 4이상인 값을 찾는 문제였는데, 연결된 관계가 5이상이니까 union-find로 풀리지 않을까 해서 풀어봤다.)
 * (다만, union-find시 유의점이 있어서 기록)
 * (나는 부모의 개수가 5인 이상인 애가 있다면 true를 return하려고 했다.)
 * union-find를 걸어주어도 [0,1,2,3,4,4] 와 같이 모두 연결돼 있어도 공통의 부모를 갖고 있지 않다.
 * for i <- 0 to N:
 *  find(i) 
 * 로 순회를 해주면서 부모일치를 시켜주어야 한다. 그러면 결과 [4,4,4,4,4,4]
 */

public class UnionFind {
    static int N,M;
    static int[] parents;
    public static void main(String[] args) throws IOException {
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
        // 이 부분이 중요
        // 연결돼있는 값을 하나로 
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