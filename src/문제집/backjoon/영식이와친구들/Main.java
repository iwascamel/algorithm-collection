package 문제집.backjoon.영식이와친구들;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
21.08.21
 */
public class Main {

    static int N,M,L;

    static int[] arr;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/영식이와친구들/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        L = sc.nextInt();

        arr = new int[N];
        int index = 0;

        while(true) {
            arr[index]++;
            if(arr[index] == M) break ;
            if(arr[index]%2 == 0){
                index += L;
                if(index >= N) index %= N;
            }else if(arr[index]%2 ==1){
                if(index-L<0) {
                    index = N-L+index;
                }else
                    index-=L;
            }
            System.out.println(Arrays.toString(arr));
            System.out.println("index = " + index);
        }
        int count =0;
        for(int i : arr){
            count += i;
        }
        System.out.println(Arrays.toString(arr));
        // 마지막 값은 count 에서 제외
        System.out.println(count-1);
    }
}
