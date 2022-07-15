package 문제집.backjoon.삼의배수BJ1769;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * date: 22.07.15
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/삼의배수BJ1769/input.txt"));
        Scanner sc= new Scanner(System.in);

        String iv = sc.nextLine();

        if(iv.length() == 1){
            System.out.println(0);
            if(Integer.parseInt(iv) %3 == 0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            return ;
        }

        int cnt = 0;
        int temp;
        boolean flag;

        while(true){
            temp = 0;
            cnt ++;
            for(int i=0;i<iv.length();i++){
                temp += iv.charAt(i) - '0';
            }
            if(temp < 10){
                flag = temp % 3 == 0;
                break;
            }
            iv = String.valueOf(temp);
        }
        System.out.println(cnt);
        System.out.println(flag ? "YES" : "NO");
    }
}
