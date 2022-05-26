package 문제집.backjoon.암호코드;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * date : 22.03.06
 * X
 * 문제를 잘못파악
 */

public class Main {
    static boolean flag;
    static String input;
    static int N;
    static int res;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/암호코드/input.txt"));

        flag= false;
        Scanner sc = new Scanner(System.in);
        input = sc.next();
        N = input.length();

        dfs(0,0);
        if(flag){
            System.out.println(-1);
        }else{
            System.out.println(res);
        }
    }

    static void dfs(int p, int cnt){
        if(flag) return;

        if(p>N-1){
            res = Math.max(res,cnt);
            return ;
        }

        if(p==N-1){
            dfs(p+1,cnt+1);
            return ;
        }

        if(p==N-2){
            int o1 = Integer.parseInt(input.substring(p,p+1));
            int o2 = Integer.parseInt(input.substring(p,p+2));

            if(check(o1)){
                dfs(p+1,cnt+1);
            }else{
                flag = true;
            }
            if(check(o2)){
                dfs(p+2,cnt+1);
            }else{
                flag = true;
            }
            return ;
        }

        int one = Integer.parseInt(input.substring(p,p+1));
        int two = Integer.parseInt(input.substring(p,p+2));

        if(check(one)){
            dfs(p+1,cnt+1);
        }else{
            flag = true;
            return ;
        }

        if(check(two)){
            dfs(p+2,cnt+1);
        }
    }

    private static boolean check(int num) {
        return num >= 0 && num <= 26;
    }
}
