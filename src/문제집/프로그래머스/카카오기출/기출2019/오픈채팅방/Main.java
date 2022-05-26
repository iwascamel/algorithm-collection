package 문제집.프로그래머스.카카오기출.기출2019.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * date : 22.02.24
 * link : https://programmers.co.kr/learn/courses/30/lessons/42888
 */

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
    }
    static class Solution {
        public String[] solution(String[] record) {
            int N = record.length;
            List<String> list = new ArrayList<>();
            Map<String,String> map = new HashMap<>();

            for (String s : record) {
                String[] split = s.split(" ");

                if (split[0].equals("Enter")) {
                    list.add("님이 들어왔습니다.");
                    map.put(split[1], split[2]);
                } else if (split[0].equals("Leave")) {
                    list.add("님이 나갔습니다.");
                }else{
                    map.put(split[1], split[2]);
                }
            }

            int pointer = 0;
            for(String s : record){
                String[] split = s.split(" ");
                if (split[0].equals("Enter")) {
                    list.set(pointer,map.get(split[1]) + list.get(pointer));
                    pointer++;
                } else if (split[0].equals("Leave")) {
                    list.set(pointer,map.get(split[1]) + list.get(pointer));
                    pointer++;
                }
            }
            System.out.println(list);
            String[] res = new String[list.size()];

            for(int i=0;i<list.size();i++){
                res[i] = list.get(i);
            }
            return res;
        }
    }
}
