package 문제집.backjoon.문자해독;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * date: 22.04.05
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/문자해독/input.txt"));
        Scanner sc = new Scanner(System.in);
        int N1 = sc.nextInt();
        int N2 = sc.nextInt();

        String s1 = sc.next();
        String s2 = sc.next();

        Map<Character,Integer> map1 = new HashMap<>();

        int answer = 0;

        for(int i=0;i<s1.length();i++){
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
        }
        Map<Character,Integer> map2 = new HashMap<>();
        for(int i=0;i<N1;i++){
            map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0)+1);
        }

        if(check(map1,map2)) answer++;

        for(int i=0;i<N2-N1;i++){
            char before = s2.charAt(i);
            map2.put(before,map2.get(before)-1);
            if(map2.get(before) == 0){
                map2.remove(before);
            }
            char cur = s2.charAt(N1+i);
            map2.put(cur, map2.getOrDefault(cur,0)+1);

            if(check(map1,map2)){
                answer ++;
            }
        }
        System.out.println(answer);
    }

    static boolean check(Map<Character,Integer> map1, Map<Character,Integer> map2 ){
        Set<Character> keys = map1.keySet();
        for(Character key : keys ){
            if(!map1.get(key).equals(map2.get(key))){
                return false;
            }
        }
        return true;
    }
}
