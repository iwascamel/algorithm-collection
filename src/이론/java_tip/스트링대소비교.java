package 이론.java_tip;

import java.util.Arrays;

/*
 * 22.07.07
 */

public class 스트링대소비교 {
    public static void main(String[] args) {
        String a = "asdqwd";
        String b = "zzadwq";

        // a.compareTo(b) 를 통해 비교 가능
        String[] arr = new String[]{a,b};
        
        Arrays.sort(arr);
    }
}
