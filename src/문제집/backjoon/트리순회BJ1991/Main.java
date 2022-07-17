package 문제집.backjoon.트리순회BJ1991;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * date: 22.07.18
 */


public class Main {
    static int N;
    static Map<Character,Node> map;
    static class Node{
        char val;
        Node left;
        Node right;

        public Node(char val) {
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/트리순회BJ1991/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        for(int i=0;i<N;i++){
            char c = (char) ('A'+i);
            map.put(c,new Node(c));
        }

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            Node point = map.get(st.nextToken().charAt(0));
            char lc = st.nextToken().charAt(0);
            char rc = st.nextToken().charAt(0);

            if(lc != '.'){
                point.left = map.get(lc);
            }
            if(rc != '.'){
                point.right = map.get(rc);
            }
        }

        Node startPoint = map.get('A');
        printPre(startPoint);
        System.out.println();
        printMiddle(startPoint);
        System.out.println();
        printLast(startPoint);
    }

    private static void printLast(Node node) {
        if(node == null){
            return ;
        }
        printLast(node.left);
        printLast(node.right);
        System.out.print(node.val);
    }

    private static void printMiddle(Node node) {
        if(node == null){
            return ;
        }
        printMiddle(node.left);
        System.out.print(node.val);
        printMiddle(node.right);
    }

    private static void printPre(Node node) {
        if(node == null){
            return ;
        }
        System.out.print(node.val);
        printPre(node.left);
        printPre(node.right);
    }
}
