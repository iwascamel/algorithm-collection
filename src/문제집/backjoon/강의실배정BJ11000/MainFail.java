package 문제집.backjoon.강의실배정BJ11000;

/**
 * date: 22.06.26
 */

 import java.util.*;
 import java.io.*;

public class MainFail {
    static int N;
    static int[] arr;

    static class Time implements Comparable<Time>{
        int start;
        int end;
        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Time o) {
            if(this.start==o.start){
                return Integer.compare(this.end, o.end);
            }else{
                return Integer.compare(this.start, o.start);
            }
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/강의실배정BJ11000/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        PriorityQueue<Time> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.offer(new Time(start,end));
        }
        
        int end = 0;
        int res = 0;
        while(!pq.isEmpty()){
            Time t = pq.poll();
            if(t.start >= end){
                res++;
                end = t.end;
            }
        }
        System.out.println(res);
    }
}
