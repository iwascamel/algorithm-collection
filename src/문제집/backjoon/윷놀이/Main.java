package 문제집.backjoon.윷놀이;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/윷놀이/input.txt"));

        Scanner sc = new Scanner(System.in);

        for(int i=0;i<3;i++){
            int zeroCnt = 0;
            int oneCnt = 0;

            for(int j=0;j<4;j++){
                int input = sc.nextInt();
                if(input==0){
                    zeroCnt++;
                }else{
                    oneCnt++;
                }
            }

            if(oneCnt==4) System.out.println("E");
            if(oneCnt==3) System.out.println("A");
            if(oneCnt==2) System.out.println("B");
            if(oneCnt==1) System.out.println("C");
            if(oneCnt==0) System.out.println("D");
        }
    }
}
