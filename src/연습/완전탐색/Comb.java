package 연습.완전탐색;

import java.util.Arrays;

/**
 * date: 22.06.30
 */

public class Comb {
    static int[] arr;
    static int[] temp;
    static boolean[] v;
    static int N,R;
    public static void main(String[] args) {
        arr = new int[]{10,20,30,40,50,60};
        N = arr.length;
        R = 3;
        v = new boolean[N];
        temp = new int[R];

        comb(0,0);
    }
    private static void comb(int cnt, int start) {
        if(cnt == R){
            System.out.println(Arrays.toString(temp));
            return ;
        }

        for(int i=start;i<N;i++){
            // if(v[i]) continue;
            // v[i] = true;
            temp[cnt] = arr[i];
            comb(cnt+1,i+1);
            // v[i] = false;
        }
    }
}
