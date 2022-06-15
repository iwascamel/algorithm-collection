package 문제집.backjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 22.06.15
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=b.length()-a.length();i++){
            String temp = b.substring(i, i+a.length());
            int cnt = 0;
            for(int j=0;j<a.length();j++){
                if(temp.charAt(j) != a.charAt(j)){
                    cnt++;
                }
            }
            min = Math.min(min,cnt);
        }
        System.out.println(min);
    }
}
