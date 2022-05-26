package 문제집.backjoon.숨바꼭질;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * date : 22.02.06
 * 참조링크 : https://chanhuiseok.github.io/posts/baek-14/
 */

public class Main {
    static class Info{
        int current;
        int cnt;

        public Info(int current, int cnt) {
            this.current = current;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/숨바꼭질/input.txt"));

        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        boolean[] visited = new boolean[100001];
        Queue<Info> queue = new LinkedList<>();

        queue.offer(new Info(start,0));
        visited[start] = true;

        int result=0;

        while(!queue.isEmpty()){
            Info poll = queue.poll();
            int cur = poll.current;
            int cnt = poll.cnt;

            if(cur == end) {
                result = cnt;
                break;
            }

            if(cur-1 >= 0 && cur-1 <= 100000 && !visited[cur-1]) {
                queue.offer(new Info(cur-1,cnt+1));
                visited[cur-1]=true;
            }
            if(cur*2 >= 0 && cur*2 <= 100000 && !visited[cur*2]) {
                queue.offer(new Info(cur*2,cnt+1));
                visited[cur*2]=true;
            }
            if(cur+1 >= 0 && cur+1 <= 100000 && !visited[cur+1]) {
                queue.offer(new Info(cur+1,cnt+1));
                visited[cur+1]=true;
            }
        }
        System.out.println(result);
    }

}
