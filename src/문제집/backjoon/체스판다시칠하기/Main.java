package 문제집.backjoon.체스판다시칠하기;

import java.io.*;

/**
 * 25.05.10
 * 나는 array를 복사해서 하는 경우를 생각했는데, 복사하지 않고 그냥 계산식으로만 풀 수 있음 (Sol 참고)
 * 단, 아래 solution은 틀렸는데 W로 시작하는 경우와 B로 시작하는 경우 모두를 구해야 함
 * 실버4치고는 좀 어려운듯...
 */

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/체스판다시칠하기/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String[] input = s.split(" ");

        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        char[][] arr = new char[m][n];

        for(int i=0; i<m;i++){
            String in = br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j] = in.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i=0;i<m-7;i++){
            for(int j=0;j<n-7;j++){
                char[][] copy = new char[m][n];

                for(int l=0; l<m;l++){
                    System.arraycopy(arr[l], 0, copy[l], 0, n);
                }

                char previous = copy[i][j];
                int cnt = 0;
                char change;
                for(int a =i; a<i+8; a++){
                    if(a != 0){
                        previous = copy[a-1][j];
                    }
                    for(int b=j; b<j+8; b++){
                        if(a == i && b == j) continue;
                        print(copy);
                        System.out.println("a, b = " + a + "-" + b + " // i, j = " + i + "-" + j);
                        System.out.println("previous = " + previous);
                        System.out.println("arr[a][b] = " + arr[a][b]);
                        System.out.println("cnt = " + cnt);
                        System.out.println("-----------");
                        if(copy[a][b] == previous) {
                            cnt ++;
                            if(previous == 'B'){
                                change = 'W';
                            }else{
                                change = 'B';
                            }
                            previous = change;
                            copy[a][b] = change;
                        }else{
                            previous = copy[a][b];
                        }
                    }
                }
                print(copy);
                min = Integer.min(cnt, min);
            }
        }

        System.out.println(min);
    }

    static void print(char[][] arr){
        for (char[] chars : arr) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
