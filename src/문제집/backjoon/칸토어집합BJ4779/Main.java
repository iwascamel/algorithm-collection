package 문제집.backjoon.칸토어집합BJ4779;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 22.07.19
 */

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/칸토어집합BJ4779/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        while((str = br.readLine()) != null){
            int n = Integer.parseInt(str);

            int pow = (int)Math.pow(3, n);
            System.out.println(recurse(pow));
        }
    }

    static String recurse(int n){
        if (n == 1){
            return "-";
        }

        StringBuilder res = new StringBuilder();
        String mid = " ".repeat(Math.max(0, n/3));

        String lr = recurse(n/3);
        res.append(lr);
        res.append(mid);
        res.append(lr);
        return res.toString();
    }
}
