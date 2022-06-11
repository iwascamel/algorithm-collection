package 문제집.backjoon.신나는함수실행;

/*
 * date: 22.06.11
 * 아래 풀이는 링크 참조 ( if 조건절에서 >= 20 으로 조건절을 넣어줬는데, >20 을 넣어줬어야 했다. )
 * mainV2가 내 풀이
 * link : https://st-lab.tistory.com/190
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/신나는함수실행/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new int[51][51][51];
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1) break;
            int res = w(a, b, c);
            sb.append("w(").
                    append(a).
                    append(", ").
                    append(b).
                    append(", ").
                    append(c)
                    .append(") = ")
                    .append(res)
                    .append("\n");
        }
        System.out.println(sb);
    }

    private static int w(int a, int b, int c) {
        if(inRange(a,b,c) && dp[a][b][c]!=0){
            return dp[a][b][c];
        }

        if(a<=0 || b<=0 || c<=0) return 1;
        else if( a>20 || b>20 || c>20 ) return dp[20][20][20] = w(20,20,20);
        else if(a<b && b<c){
            return dp[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
        }else{
            return dp[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
        }
    }
    static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}
