package 문제집.backjoon.괄호추가하기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> list;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("./src/backjoon/괄호추가하기/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        list = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String input = st.nextToken();

        dfs(N,input);

        System.out.println(list);

    }

    private static void dfs(int len,String input) {
        if(len >=5){
            char[] inputs = input.toCharArray();

            int straightResult = getStraightResult(inputs);
            int parenthesisResult = getParenthesisResult(inputs);

            StringBuilder sbStraight = new StringBuilder();
            StringBuilder sbParenthesis = new StringBuilder();

            sbStraight.append(straightResult);
            sbParenthesis.append(parenthesisResult);

            int pointer = 5;

            while(pointer < len){
                sbStraight.append(inputs[pointer]);
                sbParenthesis.append(inputs[pointer]);
                pointer++;
            }

            dfs(sbStraight.length(),sbStraight.toString());
            dfs(sbParenthesis.length(),sbParenthesis.toString());

        }else if(len == 3){
            char[] inputs = input.toCharArray();

            int n1 = Integer.parseInt(String.valueOf(inputs[0]));
            char op1 = inputs[1];
            int n2 = Integer.parseInt(String.valueOf(inputs[2]));

            int cal = cal(n1, n2, op1);

            dfs(1, String.valueOf(cal));
        }else {
            list.add(Integer.parseInt(input));
        }
    }

    private static int getParenthesisResult(char[] inputs) {
        int num1 = Integer.parseInt(String.valueOf(inputs[0]));
        char op1 = inputs[1];
        int num2 = Integer.parseInt(String.valueOf(inputs[2]));
        char op2 = inputs[3];
        int num3 = Integer.parseInt(String.valueOf(inputs[4]));

        int res1 = cal(num2,num3,op2);
        return cal(num1,res1,op1);
    }

    private static int getStraightResult(char[] inputs) {
        int num1 = Integer.parseInt(String.valueOf(inputs[0]));
        char op1 = inputs[1];
        int num2 = Integer.parseInt(String.valueOf(inputs[2]));
        char op2 = inputs[3];
        int num3 = Integer.parseInt(String.valueOf(inputs[4]));

        int res1 = cal(num1, num2, op1);

        return cal(res1,num3,op2);
    }

    private static int cal(int a, int b, char op){
        if(op == '+'){
            return a+b;
        }else if(op =='-'){
            return a-b;
        }else{
            return a*b;
        }
    }
}
