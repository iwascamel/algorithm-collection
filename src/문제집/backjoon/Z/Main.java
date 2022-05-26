package 문제집.backjoon.Z;

import java.util.Scanner;

public class Main {

    static int N, X, Y, cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        X = sc.nextInt();
        Y = sc.nextInt();
        cnt = 0;

        z(0,0,1<<N); // 1<<N = 2의 N승
    }

    /*
    z(0,0,4) -> z(0,0,2) z(0,2,2) z(2,0,2) z(2,2,2)
    3,1 이 input 이라고 해보자
     r>=2 && r<4 && c>=0 && c<2 z(2,0,2)만 in
     z(0,0,2) z(0,2,2) 4 + 4
     z(2,0,2) -> z(2,0,1) 1 z(2,1,1) 1 z(3,0,1) 1 => z(3,1,1)
     */

    private static void z(int c, int r, int width) {
        if( c == X && r == Y){
            System.out.println(cnt);
            return ;
        }

        // c <= X < c+width
        // 범위가 안에 있을 때, 지금 시간 12시 -> 1 3 5 7로 나누기
        if( X >= c && X < c+width  && Y >= r && Y < r + width ){
            z(c,r,width/2);
            z(c,r+width/2,width/2);
            z(c+width/2,r,width/2);
            z(c+width/2,r+width/2,width/2);
        }else{ // 범위 밖에 있으면 해당 범위의 값을 그냥 세고 넘어감
            cnt += width * width;
        }
    }
}
