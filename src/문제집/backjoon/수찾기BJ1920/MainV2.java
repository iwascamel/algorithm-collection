package 문제집.backjoon.수찾기BJ1920;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * date: 22.07.01
 * memo: 문제 잘 못 읽음. 나는 존재하는 개수를 찾으라는줄
 */

public class MainV2 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/수찾기BJ1920/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int mm = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<mm;i++){
            int num = Integer.parseInt(st.nextToken());
            
            int res = getBinary(num);
            if(res>=0){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
    private static int getBinary(int num) {
        int start = 0;
        int end = N-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(arr[mid] == num){
                return mid;
            }else if(arr[mid] > num){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return -1;
    }
}
