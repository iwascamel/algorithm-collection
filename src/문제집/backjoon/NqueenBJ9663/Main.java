package 문제집.backjoon.NqueenBJ9663;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * date: 22.06.30
 */

public class Main {
    static int N;
    static int[] cv; // 해당 row 일 때의 column 값
    static int cnt;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/NqueenBJ9663/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        cv = new int[N];

        setQueen(0);
        System.out.println(cnt);
    }
    private static void setQueen(int rowNumber) {
        if(rowNumber>=N){
            cnt++;
            return ;
        }

        for(int i=0;i<N;i++){
            cv[rowNumber] = i;
            if(isAvailable(rowNumber)){
                setQueen(rowNumber+1);
            }
        }
    }

    static boolean isAvailable(int rowNum){
        for(int i=0;i<rowNum;i++){
            if(cv[rowNum] == cv[i] || rowNum - i == Math.abs(cv[rowNum] - cv[i])){
                return false;
            }
        }
        return true;
    }
    
}
