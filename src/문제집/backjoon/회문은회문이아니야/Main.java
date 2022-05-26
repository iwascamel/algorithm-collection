package 문제집.backjoon.회문은회문이아니야;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int N;
    static String s;
    static boolean[] checked;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/회문은회문이아니야/input.txt"));
        Scanner sc = new Scanner(System.in);

        s = sc.nextLine();

        N = s.length();
        checked = new boolean[N];

        boolean flag = false;
        for(int i=0;i<N/2;i++){
            if(s.charAt(i) != s.charAt(N-1-i)){
                System.out.println(N);
                return ;
            }else if(s.charAt(i) != s.charAt(i+1)){
                flag = true;
            }
        }

        if(flag){
            System.out.println(N-1);
        }else{
            System.out.println(-1);
        }

    }

}
