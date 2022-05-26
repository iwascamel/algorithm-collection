package 문제집.backjoon.괄호추가하기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 22.04.28
 */

public class MainV3 {
    static int N;
    static int[] num;
    static char[] op;
    static int answer;
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/backjoon/괄호추가하기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        num = new int[N/2+1];
        op = new char[N/2];
        answer = Integer.MIN_VALUE;

        int numCnt = 0;
        int opCnt = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c >= '0' && c<='9') {
                num[numCnt++] = c -'0';
            }else {
                op[opCnt++] = c;
            }
        }

        dfs(0,num[0]);
        System.out.println(answer);
    }

    private static void dfs(int cnt, int sum) {
        if(cnt == op.length){
            answer = Math.max(answer,sum);
            return ;
        }

        dfs(cnt+1,cal(sum,num[cnt+1],op[cnt]));

        if(cnt + 2 <= op.length){
            dfs(cnt+2,cal(sum,cal(num[cnt+1],num[cnt+2],op[cnt+1]),op[cnt]));
        }
    }

    static int cal(int n1,int n2, char op){
        if(op == '+'){
            return n1+n2;
        }else if(op == '-'){
            return n1-n2;
        }else if(op == '*'){
            return n1*n2;
        }else{
            return n1/n2;
        }
    }
}