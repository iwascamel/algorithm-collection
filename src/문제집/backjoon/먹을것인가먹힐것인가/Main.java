package 문제집.backjoon.먹을것인가먹힐것인가;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * date: 22.06.22
 */

public class Main {
    static int T;
    static int N,M;
    static int[] a;
    static int[] b;
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/먹을것인가먹힐것인가/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T  = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
    
            a = new int[N];
            b = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                b[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            Arrays.sort(b);
            
            int cnt = 0;
            for(int i=0;i<N;i++){
                int resIndex = binary(a[i]);
                if(a[i] > b[resIndex]){
                    cnt +=1;
                }
                cnt += resIndex;
            }
            System.out.println(cnt);
        }
    }
    static int binary(int target){
        int start = 0;
        int end = M-1;

        while(start<end){
            int mid = (start+end)/2;

            if(b[mid] >= target){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return end;
    }
}
