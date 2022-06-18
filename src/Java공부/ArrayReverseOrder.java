package Java공부;

import java.util.Arrays;
import java.util.Collections;

/*
 * date: 22.06.19
 * 참조링크 : https://crazykim2.tistory.com/462
 */

public class ArrayReverseOrder {
    public static void main(String[] args) {
        Integer[] arr = new Integer[5];
        for(int i=0;i<5;i++){
            arr[i] = i;
        }

        Arrays.sort(arr,Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }
}
