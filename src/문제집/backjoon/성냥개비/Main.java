package 문제집.backjoon.성냥개비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 22.06.30
 */

 import java.util.*;

public class Main {
    static int N,T;
    static Map<Integer,Integer> map;
    static int[] dp;
    static long maxNum;
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/성냥개비/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new HashMap<>();

        // 성냥개비수 - value
        map.put(2,1);
        map.put(3,7);
        map.put(4,4);
        map.put(5,5);
        map.put(6,9);
        map.put(7,8);
        dp = new int[101];

        T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());

            getMax(N,new StringBuilder());
            System.out.println(maxNum);
            
        }
    }
    private static void getMax(int n, StringBuilder sb) {
        if(n<=1){
            maxNum = Math.max(maxNum,Integer.parseInt(sb.toString()));
            return ;
        }
        
        Set<Integer> keys = map.keySet();
        for(int m : keys){
            if(n-m>=0){
                getMax(n-m, sb.append(map.get(m)));
                sb.setLength(sb.length()-1);
            }
        }
    }
}
