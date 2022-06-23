package 자료구조;

/*
 * date: 22.06.23
 * memo: 정수삼각형 풀다가...
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BinaryTreeOfferPoll {
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
        System.setIn(new FileInputStream("./src/자료구조/BinaryTreeInput.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int initValue = Integer.parseInt(br.readLine());
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(initValue);
        queue.offer(node);
        // 이진트리에 값 넣기
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[i+1];

            for(int j=0;j<temp.length;j++){
                temp[j] = Integer.parseInt(st.nextToken());
            }

            System.out.println(Arrays.toString(temp));

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

        // 이진트리 출력
        Queue<Node> temp = new LinkedList<>();

        temp.offer(node);

        while(!temp.isEmpty()){
            int size = temp.size();
            if(size>0){
                temp.offer(temp.peek().left);
            }
            while(size-->0){
                Node poll = temp.poll();
                System.out.print(poll.value + " ");
                if(poll.left!=null){
                    temp.offer(poll.right);
                }
            }
            System.out.println();
        }
        
        
    }
}