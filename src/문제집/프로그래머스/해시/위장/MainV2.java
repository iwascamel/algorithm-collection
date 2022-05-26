package 문제집.프로그래머스.해시.위장;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * date: 22.03.02
 */

public class MainV2 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int solution(String[][] clothes) {
            Map<String, Integer> map = new HashMap<>();
            for(String [] c : clothes){
                map.put(c[1],map.getOrDefault(c[1],0)+1);
            }
            int cnt = 1;
            Set<String> keys = map.keySet();
            for(String s : keys){
                cnt *= map.get(s)+1;
            }
            return cnt-1;
        }
    }
}
