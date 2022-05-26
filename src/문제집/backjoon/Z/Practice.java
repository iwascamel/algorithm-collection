package 문제집.backjoon.Z;

import java.util.Scanner;

public class Practice {
    static int N,X,Y;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        count =0 ;
        N = sc.nextInt();
        X = sc.nextInt();
        Y = sc.nextInt();

        z(0,0,1<<N);
    }

    private static void z(int r, int c, int width) {
        if(r == X && c == Y){
            System.out.println(count);
            return ;
        }

        if(X >= r && X < r+ width && Y >= c && Y < c+width){
            z(r,c,width/2);
            z(r,c+width/2,width/2);
            z(r+width/2,c,width/2);
            z(r+width/2,c+width/2,width/2);
        }else{
            count += width * width;
        }
    }
}
