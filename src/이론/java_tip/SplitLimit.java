package 이론.java_tip;

import java.util.Arrays;

/*
 * date: 22.07.07
 * limit -> n개의 배열만 생성되게 자름
 */

public class SplitLimit {
    public static void main(String[] args) {
        String s = "a b c d e";
        // 2개의 배열만 생성
        System.out.println(Arrays.toString(s.split(" ",2)));
    }
}
