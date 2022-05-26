package 문제집.backjoon.부분합;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N,S;
    static int[] arr;
    static int answer;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/부분합/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left=0,right = 0;
        int sum = 0;
        answer = Integer.MAX_VALUE;
        while(true){
            if(sum>=S){
                answer = Math.min(answer,right-left);
                sum -= arr[left++];
            }else if(right == N){
                break;
            }else{
                sum += arr[right++];
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
