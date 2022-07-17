package 문제집.backjoon.카드BJ11652;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 22.07.17
 */

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        Map<Long,Integer> hashMap = new HashMap<>();

        for(int i=0;i<N;i++){
            long iv = sc.nextLong();
            hashMap.put(iv, hashMap.getOrDefault(iv,0)+1);
        }
        long mv = 0;
        long res = 0;

        for(Long h : hashMap.keySet()){
            if(mv < hashMap.get(h)){
                mv = hashMap.get(h);
                res = h;
            }else if(mv == hashMap.get(h) && res > h){
                res = h;
            }
        }
        System.out.println(res);
    }
}
