package 문제집.backjoon.괄호추가하기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainV2 {

    static List<Integer> list;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("./src/backjoon/괄호추가하기/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        list = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String input = st.nextToken();

        char[] chars = input.toCharArray();
        String[] sArr = new String[N];

        for(int i=0;i<N;i++){
            sArr[i] = String.valueOf(chars[i]);
        }

        dfs(N,sArr);

        System.out.println(list);

    }

    private static void dfs(int len,String[] input) {
        if(len >=5){
            int straightResult = getStraightResult(input);
            int parenthesisResult = getParenthesisResult(input);

            String[] stArr = new String[len-4];
            String[] paArr = new String[len-4];

            stArr[0] = String.valueOf(straightResult);
            paArr[0] = String.valueOf(parenthesisResult);

            for(int i=1;i<len-4;i++){
                stArr[i] = input[i+4];
                paArr[i] = input[i+4];
            }

            dfs(stArr.length, stArr);
            dfs(paArr.length, paArr);

        }else if(len == 3){
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[2]);
            String op1 = input[1];

            int cal = cal(n1, n2, op1);
            dfs(1,new String[]{String.valueOf(cal)});
        }else{
            list.add(Integer.parseInt(input[0]));
        }
    }

    private static int getParenthesisResult(String[] input) {
        int n1 = Integer.parseInt(input[0]);
        int n2 = Integer.parseInt(input[2]);
        int n3 = Integer.parseInt(input[4]);

        String op1 = input[1];
        String op2 = input[3];

        return cal(cal(n2,n3,op2),n1,op1);
    }

    private static int getStraightResult(String[] input) {
        int n1 = Integer.parseInt(input[0]);
        int n2 = Integer.parseInt(input[2]);
        int n3 = Integer.parseInt(input[4]);

        String op1 = input[1];
        String op2 = input[3];

        return cal(cal(n1,n2,op1),n3,op2);
    }

    private static int cal(int a, int b, String op){
        if(op.equals("+")){
            return a+b;
        }else if(op.equals("-")){
            return a-b;
        }else{
            return a*b;
        }
    }
}
