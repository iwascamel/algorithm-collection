package 문제집.backjoon.정수삼각형;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * date: 22.06.23
 * data: https://olympiads.win.tue.nl/ioi/ioi94/contest/day1prb1/index.html
 */

 /*
  * 1. left, right 입력값 받기
  * 2. 재귀호출로 left, right 최대값 반환
  */

public class Main {

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node [left=" + left + ", right=" + right + ", value=" + value + "]";
        }
    }

    static int N;
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/정수삼각형/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int initValue = Integer.parseInt(br.readLine());
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(initValue);
        queue.offer(node);
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[i+1];

            for(int j=0;j<temp.length;j++){
                temp[j] = Integer.parseInt(st.nextToken());
            }

            int size = queue.size();
            boolean first = true;
            int p = 0;
            
            while(size-->0){
                Node poll = queue.poll();
                
                poll.left = new Node(temp[p++]);
                poll.right = new Node(temp[p]);

                if(first){
                    queue.offer(poll.left);
                    first = !first;
                }
                queue.offer(poll.right);
            }
        }
        int res = recurse(node);
        System.out.println(res);
    }

    static int recurse(Node node){
        if(node.left==null){
            return node.value;
        }

        int left = recurse(node.left);
        int right = recurse(node.right);
        
        if(left >= right){
            return left+node.value;
        }else{
            return right+node.value;
        }
    }
}
