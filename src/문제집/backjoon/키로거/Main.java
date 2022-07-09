package 문제집.backjoon.키로거;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * date: 22.07.09
 */

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/키로거/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        Stack<Character> ls,rs;
        for(int t = 0; t< T; t++){
            String s = br.readLine();
            int N = s.length();
            ls = new Stack<>();
            rs = new Stack<>();

            for(int i=0;i<N;i++){
                char c = s.charAt(i);

                if(c == '>'){
                    if(!rs.isEmpty()){
                        ls.push(rs.pop());
                    }
                }else if(c == '<'){
                    if(!ls.isEmpty()){
                        rs.push(ls.pop());
                    }
                }else if( c == '-'){
                    if(!ls.isEmpty()){
                        ls.pop();
                    }
                }else{
                    ls.push(c);
                }
            }

            StringBuilder sb1= new StringBuilder();
            StringBuilder sb2= new StringBuilder();
            StringBuilder res= new StringBuilder();

            while(!ls.isEmpty()){
                sb1.append(ls.pop());
            }
            while(!rs.isEmpty()){
                sb2.append(rs.pop());
            }
            res.append(sb1.reverse()).append(sb2);
            System.out.println(res);
        }
    }
}
