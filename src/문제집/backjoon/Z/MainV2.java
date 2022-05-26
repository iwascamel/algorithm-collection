package 문제집.backjoon.Z;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * date: 22.03.25
 */

public class MainV2 {
    static int N,R,C;
    static int cnt;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/Z/input.txt"));
        Scanner sc= new Scanner(System.in);

        N = sc.nextInt();
        R = sc.nextInt();
        C = sc.nextInt();

        z(0,0,1<<N);
        System.out.println(cnt);
    }

    private static void z(int r, int c, int width) {
        if(r==R && c==C){
            System.out.println(cnt);
            return ;
        }

        if( R >= r && R < r+width && C >= c && C < c+width){
            z(r,c,width/2);
            z(r,c+width/2,width/2);
            z(r+width/2,c,width/2);
            z(r+width/2,c+width/2,width/2);
        }else{
            cnt += width * width;
        }
    }
}
