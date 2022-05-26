package 문제집.backjoon.숫자카드2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * date : 22.01.07
 * memo : 답은 맞게 나오나 시간초과
 * 도움 링크 : https://st-lab.tistory.com/267
 */

public class MainV2 {

    static int N,M;
    static int[] arr;
    static int[] verify;
    static List<Integer> list;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/숫자카드2/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        list = new ArrayList<>();
        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        M = sc.nextInt();
        verify = new int[M];
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<M;i++){
            int key = sc.nextInt();

            sb.append(getUpper(key) - getLower(key)).append(' ');
        }
        System.out.println(sb);

    }

    static int getLower(int key){
        int start=0;
        int end = arr.length;

        while(start<end){
            int mid = (start+end)/2;

            if(arr[mid] >= key){
                end = mid;
            }else if(arr[mid] < key){
                start = mid+1;
            }
        }
        return start;
    }
    static int getUpper(int key){
        int start=0;
        int end = arr.length;

        while(start<end){
            int mid = (start+end)/2;

            if(arr[mid] > key){
                end = mid;
            }else if(arr[mid] <= key){
                start = mid+1;
            }
        }
        return start;
    }
}
