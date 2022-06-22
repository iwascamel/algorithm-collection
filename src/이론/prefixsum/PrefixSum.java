package 이론.prefixsum;

import java.util.Arrays;

/**
 * date: 22.06.22
 */

public class PrefixSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        
        int N = arr.length;
        int[] prefixSum = new int[N+1];

        for(int i=1;i<N+1;i++){
            prefixSum[i] = prefixSum[i-1] + arr[i-1];
        }
        
        // [0, 1, 3, 6, 10, 15]
        System.out.println(Arrays.toString(prefixSum));

        // index 1~3 구간합 구하기
        System.out.println(prefixSum[4]-prefixSum[1]);
    }
}
