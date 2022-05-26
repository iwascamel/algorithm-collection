package 문제집.프로그래머스.해시.전화번호목록;

import java.util.HashMap;

/**
 * link : https://coding-grandpa.tistory.com/77
 */

public class MainV4 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        boolean solution1 = solution.solution(new String[]{"119", "97674223", "24421"});
        System.out.println(solution1);
    }

    static class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < phone_book.length; i++) map.put(phone_book[i], i);

            for (int i = 0; i < phone_book.length; i++) {
                for (int j = 1; j <= phone_book[i].length(); j++) {
                    String substring = phone_book[i].substring(0, j);
                    if (map.containsKey(substring) && i != map.get(substring)) {
                        answer = false;
                        return answer;
                    }
                }
            }
            return answer;
        }
    }
}
