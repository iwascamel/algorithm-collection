package 문제집.프로그래머스.해시.위장;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * date : 21.10.15
 */

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int solution1 = solution.solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}});
        System.out.println(solution1);
    }

    static class Solution {
        public int solution(String[][] clothes) {
            Map<String,Integer> map = new HashMap<>();

            for(String[] s : clothes){
                map.put(s[1],map.getOrDefault(s[1],0)+1);
            }

            Set<String> strings = map.keySet();

            int cnt = 1;

            for(String s : strings){
                cnt *= map.get(s)+1;
            }
            return cnt-1;
        }
    }
}
