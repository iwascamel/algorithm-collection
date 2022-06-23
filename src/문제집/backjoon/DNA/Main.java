package 문제집.backjoon.DNA;

/*
 * date: 22.06.23
 */

 import java.util.*;
 import java.io.*;

public class Main {
    static int N,M;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/DNA/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N];

        for(int i=0;i<N;i++){
            arr[i] = br.readLine();
        }

        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            int[] chs = new int[26];
            for(String s : arr){
                chs[s.charAt(i)-'A']++;
            }
            System.out.println(Arrays.toString(chs));
            int max = Integer.MIN_VALUE;
            char maxChar = '-';
            for(int j=25;j>=0;j--){
                if(max<=chs[j]){
                    max = chs[j];
                    maxChar = (char)('A'+j);
                }
            }
            sb.append(maxChar);
            sum += N-max;
        }
        System.out.println(sb);
        System.out.println(sum);
    }
}
