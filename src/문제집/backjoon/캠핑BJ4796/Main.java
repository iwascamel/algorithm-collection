package 문제집.backjoon.캠핑BJ4796;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 22.06.27
 */

public class Main {
    static int L,P,V;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/캠핑BJ4796/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int p = 1;
        while(true){
            int res = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            if(L == 0 && P == 0 && V == 0) break;

            res += (V/P) * L;
            res += Math.min(V%P,L); 
            System.out.println("Case " + p + ": " + res);
            p++;
        }
    }
}
