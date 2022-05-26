package 문제집.프로그래머스.해시.완주하지못한선수;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String solution = sol.solution(new String[]{"leo", "kiki", "eden", "leo"}, new String[]{"leo", "kiki", "eden"});
        System.out.println(solution);
    }
    static class Solution{
        public String solution(String[] participant, String[] completion){
            Map<String,Integer> map1 = new HashMap<>();
            Map<String,Integer> map2 = new HashMap<>();

            for(String s : participant){
                map1.put(s, map1.getOrDefault(s,0)+1);
            }
            for(String s : completion){
                map2.put(s, map2.getOrDefault(s,0)+1);
            }

            Set<String> strings = map1.keySet();
            String result = "";
            for(String s : strings){
                if(map2.get(s) == null || !map2.get(s).equals(map1.get(s))){
                    result = s;
                }
            }
            return result;
        }
    }
}
