package 연습.그래프이론;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * date: 22.07.01
 */

public class Kruskal {
    static int V,L;
    static int[] parents;
    static class Edges implements Comparable<Edges>{
        int start;
        int end;
        int weight;
        public Edges(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        
        public int compareTo(Edges e){
            return Integer.compare(this.weight, e.weight);
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/연습/그래프이론/kruskalInput.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
    
        V = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        Edges[] edges = new Edges[L];

        // 간선의 개수만큼 받기
        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Edges eg = new Edges(s, e, w);
            edges[i] = eg;
        }
        Arrays.sort(edges);

        make();

        int cnt = 0;
        int res = 0;
        for(Edges eg : edges){
            if(union(eg.start, eg.end)){
                res += eg.weight;
                if(++cnt == V-1) break;
            }
        }
        System.out.println(res);
    }

    static void make(){
        parents = new int[V];
        for(int i=0;i<V;i++){
            parents[i] = i;
        }
    }

    static int find(int x){
        if(parents[x] == x) return x;
        // 이 부분 실수 parents[x] 넘겨야 함
        else return parents[x] = find(parents[x]);
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        parents[aRoot] = bRoot;
        return true;
    }
}
