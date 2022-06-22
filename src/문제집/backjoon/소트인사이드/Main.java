package 문제집.backjoon.소트인사이드;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * date: 22.06.21
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        char[] ch = sc.next().toCharArray();
        int N = ch.length;

        Character[] chs = new Character[N];

        for(int i=0;i<N;i++){
            chs[i] = ch[i];
        }

        Arrays.sort(chs,Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(char c : chs){
            sb.append(c);
        }
        System.out.println(sb);
    }
}
