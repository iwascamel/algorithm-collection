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
 * 참조할 만한 풀이 link: https://loosie.tistory.com/344
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
        preOrder(startPoint);
        System.out.println();
        inOrder(startPoint);
        System.out.println();
        postOrder(startPoint);
    }

    private static void postOrder(Node node) {
        if(node == null){
            return ;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val);
    }

    private static void inOrder(Node node) {
        if(node == null){
            return ;
        }
        inOrder(node.left);
        System.out.print(node.val);
        inOrder(node.right);
    }

    private static void preOrder(Node node) {
        if(node == null){
            return ;
        }
        System.out.print(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
}
