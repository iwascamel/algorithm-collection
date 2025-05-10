package 문제집.backjoon.체스판다시칠하기;

import java.io.*;
public class Sol {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/체스판다시칠하기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int m = Integer.parseInt(in[0]), n = Integer.parseInt(in[1]);
        char[][] arr = new char[m][n];
        for(int i=0;i<m;i++){
            String line = br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j] = line.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<=m-8;i++){
            for(int j=0;j<=n-8;j++){
                // 시작 색 두 가지 모두 검사
                for(char start : new char[]{'W','B'}){
                    int cnt = 0;
                    for(int a=i;a<i+8;a++){
                        for(int b=j;b<j+8;b++){
                            // (a+b) 짝수면 start, 홀수면 반대
                            char expect = ((a+b)%2==0 ? start : (start=='W' ? 'B' : 'W'));
                            if(arr[a][b] != expect) cnt++;
                        }
                    }
                    min = Math.min(min, cnt);
                }
            }
        }
        System.out.println(min);
    }
}