package 문제집.backjoon.쿼드트리;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


/*

21.08.18
divide and conquer

안되면 ( -> 4방면 안으로 들어감
끝나고 나면 ) 붙여줌

 */
public class Main {

    static int N;
    static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/쿼드트리/input.txt"));

        Scanner sc = new Scanner(System.in);

        sb = new StringBuilder();
        N = sc.nextInt();
        map = new int[N][N];

        for(int i=0;i<N;i++){
            String s = sc.next();
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        quad(0,0,N);

        System.out.println(sb);
        System.out.println("((110(0101))(0010)1(0001))");
    }

    static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void quad(int r, int c, int width) {
        // r ,c 부터 width 까지의 값이 일치하는가?
        // width == 2 면 그냥 붙여서 반환
        if(width==2 && !check(r,c,width)){
            sb.append("(");
            for(int i=r;i<r+width;i++){
                for(int j=c;j<c+width;j++){
                    sb.append(map[i][j]);
                }
            }
            sb.append(")");

            // return 잊지말기
            return ;
        }

        if(!check(r,c,width)){
            sb.append("(");
            quad(r,c,width/2);
            quad(r,c+width/2,width/2);
            quad(r+width/2,c,width/2);
            quad(r+width/2,c+width/2,width/2);
            sb.append(")");
        }else{
            if(map[r][c] == 1){
                sb.append(1);
            }else {
                sb.append(0);
            }
        }
    }

    static boolean check(int r,int c,int width){
        int firstValue = map[r][c];

        for(int i=r;i<r+width;i++){
            for(int j=c;j<c+width;j++){
                if (map[i][j] != firstValue) return false;
            }
        }
        return true;
    }
}
