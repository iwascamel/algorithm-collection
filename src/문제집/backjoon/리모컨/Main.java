package 문제집.backjoon.리모컨;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * date: 22.03.03
 * memo: fail
 */

public class Main {
    static int N,M;
    static String init;
    static List<Integer> notExceptNumbers;
    static List<String> before;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/리모컨/input.txt"));

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        notExceptNumbers = new ArrayList<>();
        before = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<=9;i++){
            set.add(i);
        }

        for(int i=0;i<M;i++){
            int n = sc.nextInt();
            set.remove(n);
        }

        notExceptNumbers.addAll(set);
        init = String.valueOf(N);
        before.add("");

        for(int i=0;i<init.length();i++){
            System.out.println(before);
            int n = init.charAt(i) - '0';

            int min = Integer.MAX_VALUE;
            for(int exist : notExceptNumbers){
                min = Math.min(min,Math.abs(n-exist));
            }

            List<String> temp = new ArrayList<>();
            for(String s : before){
                List<Integer> addList = new ArrayList<>();
                for(int exist : notExceptNumbers){
                    if(Math.abs(n-exist) == min){
                        addList.add(exist);
                    }
                }
                for(int a : addList){
                    StringBuilder sb = new StringBuilder(s);
                    temp.add(sb.append(a).toString());
                }
            }
            if(temp.isEmpty()){
                System.out.println(Math.abs(N-100));
                return ;
            }
            before = temp;
        }

        System.out.println(before);

        int min = Integer.MAX_VALUE;
        for(String s : before){
            int n = Integer.parseInt(s);
            min = Math.min(min,Math.abs(N-n));
        }
        min = min + init.length();
        if(min > Math.abs(N-100)){
            min = Math.abs(N-100);
        }
        System.out.println(min);
    }
}
