package 문제집.backjoon.DNA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * date: 22.06.23
 * memo: 문제를 잘 못 읽음...
 * 각 자리마다 가장 적게 차이나는 문자를 취합해서 하나의 문자를 만들고, 그 문자와 각 문자들의 차이를 출력하라는 줄
 */

public class Main_MISS {
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
            int min = Integer.MAX_VALUE;
            char minChar = '-'; 
            for(char ch='Z';ch>='A';ch--){   
                int diff = 0;
                for(String s : arr){
                    diff += Math.abs(s.charAt(i) - ch);
                }
                if(min >= diff){
                    min = diff;
                    minChar = ch;
                }
            }
            System.out.println("min = " + min);
            sum += min;
            sb.append(minChar);
        }
        System.out.println(sum);
        System.out.println(sb);
    }
}
