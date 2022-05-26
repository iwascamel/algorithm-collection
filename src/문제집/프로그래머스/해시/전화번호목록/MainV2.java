package 문제집.프로그래머스.해시.전화번호목록;

import java.util.*;

public class MainV2 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        boolean solution1 = solution.solution(new String[]{"119", "97674223", "1195524421"});
        boolean solution2 = solution.solution(new String[]{"123", "456", "789"});

        System.out.println(solution2);

    }

    static class Solution {
        public boolean solution(String[] phone_book) {

            int N = phone_book.length;

            Map<Integer, List<String>> map = new HashMap<>();

            for(String s : phone_book){
                if (!map.containsKey(s.length())) {
                    map.put(s.length(), new ArrayList<>());
                }
                map.get(s.length()).add(s);
            }

            for(int i=0;i<N;i++){
                String cur = phone_book[i];

                Set<Integer> integers = map.keySet();

                for(int key : integers){
                    if(key >= cur.length()){
                        List<String> list = map.get(key);

                        for(String s : list){
                            if(s.length() == cur.length() && s.equals(cur)) continue;
                            if(cur.equals(s.substring(0,cur.length()))) return false;
                        }
                    }
                }
            }
            return true;
        }
    }
}
