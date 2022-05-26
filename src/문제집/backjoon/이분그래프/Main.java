package 문제집.backjoon.이분그래프;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * date : 21.09.27
 * note : 터진다 ( 시간초과 )
 * origin : ssafy 월말평가
 */

public class Main {

    static int T;
    static int V,E;

    static class Node{
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
    static Node[] adjList;
    static int[] parents;
    static boolean result;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/이분그래프/input.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int t=1;t<=T;t++){
            V = sc.nextInt();
            E = sc.nextInt();
            adjList = new Node[V+1];

            for(int i=0;i<E;i++){
                int from = sc.nextInt();
                int to =sc.nextInt();

                adjList[from] = new Node(to,adjList[from]);
                adjList[to] = new Node(from,adjList[to]);
            }
            makeSet();

            for(Node n : adjList){
                Node node = n;
                if(n!=null){
                    while(node.next!=null){
                        union(node.val,node.next.val);
                        node=node.next;
                    }
                }
            }
            comb(1,1,new boolean[V+1]);
            if(result) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static void comb(int cnt, int start, boolean[] v){
        if(cnt == V/2+1){
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            for(int i=1;i<V+1;i++){
                if(v[i]) list1.add(i);
                else list2.add(i);
            }
            boolean flag1= true;
            boolean flag2= true;

            // 반으로 나눈 집합이 연결돼있으면 false 대입
            for(int i=0;i<list1.size()-1;i++){
                if(find(list1.get(i)) == find(list1.get(i+1))) flag1=false;
            }
            for(int i=0;i<list2.size()-1;i++){
                if(find(list2.get(i)) == find(list2.get(i+1))) flag2=false;
            }

            result = flag1 && flag2;
            return ;
        }

        for(int i=start;i<V+1;i++){
            v[cnt] = true;
            comb(cnt+1,i+1,v);
            v[cnt] = false;
        }
    }

    static void makeSet(){
        parents = new int[V+1];
        for(int i=1;i<V+1;i++){
            parents[i] = i;
        }
    }
    static int find(int a){
        if( a == parents[a]) return a;
        else return parents[a] = find(parents[a]);
    }
    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;
        parents[aRoot] = bRoot;
        return true;
    }
}
