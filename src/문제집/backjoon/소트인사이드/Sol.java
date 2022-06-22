package 문제집.backjoon.소트인사이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.stream.Stream;

/*
 * 백준 풀이 중
 * link: https://www.acmicpc.net/source/44793655
 */

public class Sol {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sArr = bf.readLine().split("");
        int[] arr = Stream.of(sArr).mapToInt(Integer::parseInt).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        
        StringBuilder sb = new StringBuilder();
        
        for(int n: arr) {
            sb.append(n);
        }
        
        System.out.print(sb);
    }
}
