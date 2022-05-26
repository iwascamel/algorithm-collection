package 문제집.backjoon.세로읽기;


import java.io.*;

public class Main {
    static char[][] cArr;
    static String[] sArr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/세로읽기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        sArr = new String[5];

        for(int i=0;i<5;i++){
            sArr[i] = br.readLine();
            max = Math.max(max, sArr[i].length());
        }

        cArr = new char[5][max];

        for(int i=0;i<5;i++){
            int length = sArr[i].length();

            char[] chars = sArr[i].toCharArray();

            for(int j=0;j<length;j++){
                cArr[i][j] = chars[j];
            }

            if(length < max){
                for(int j=length;j<max;j++){
                    cArr[i][j] = '.';
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int j=0;j<max;j++){
            for(int i=0;i<5;i++){
                if(cArr[i][j] == '.') continue;
                sb.append(cArr[i][j]);
            }
        }

        System.out.println(sb);
    }

    private static void print(int max) {
        for(int i=0;i<5;i++){
            for(int j = 0; j< max; j++){
                System.out.print(cArr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
