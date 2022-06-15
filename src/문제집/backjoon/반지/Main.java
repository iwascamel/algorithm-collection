package 문제집.backjoon.반지;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 22.06.15
 */

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/반지/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int cnt=0;
        for(int i=0;i<N;i++){
            String s = br.readLine();
            s += s;
            if(s.contains(target)){
                cnt+=1;
            }
        }
        System.out.println(cnt);
    }
}
