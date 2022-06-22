package Skils.Stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        String[] sArr = new String[]{"a","B","C"};
        int[] arr = Stream.of(sArr).mapToInt(Integer::parseInt).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        
    }
}
