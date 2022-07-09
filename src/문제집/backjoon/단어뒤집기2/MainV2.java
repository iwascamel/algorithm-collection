package 문제집.backjoon.단어뒤집기2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * date: 22.07.09
 */

public class MainV2 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/단어뒤집기2/input.txt"));
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringBuilder res = new StringBuilder();

        // word temp
        StringBuilder wt = new StringBuilder();
        // brace temp
        StringBuilder bt = new StringBuilder();

        int N = input.length();
        int p =0;

        while(p<N){
            char c = input.charAt(p);

            if(c == '<'){
                bt.append(c);
                while(c != '>'){
                    p++;
                    c = input.charAt(p);
                    bt.append(c);
                }
                p++;
                res.append(bt);
                bt.setLength(0);
            }else if(c == ' '){
                res.append(c);
                p++;
            }else{
                while(p < N && Pattern.matches("[a-zA-Z0-9]",String.valueOf(c))){
                    c = input.charAt(p);
                    wt.append(c);
                    p++;
                }
                if(p!=N) {
                    p--;
                    wt.setLength(wt.length()-1);
                }
                res.append(wt.reverse());
                wt.setLength(0);
            }
        }
        System.out.println(res);
    }
}
