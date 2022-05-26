package 문제집.프로그래머스.카카오기출.카카오2018.압축;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OtherSol {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("TOBEORNOTTOBEORTOBEORNOT");
    }

    static class Solution{
        List<Integer> solution(String msg) {
            List<Integer> answer = new ArrayList<>();
            Map<String, Integer> dictionary = new HashMap<>();

            for (int i = 0; i < 26; i++) {
                dictionary.put("" + (char) ('A' + i), i + 1);
            }

            for (int idx = 0; idx < msg.length(); ) {
                int len = 1;
                int end = idx;
                String existWord = "";

                // 끝 인덱스 늘려가며 새로운 단어 찾기
                while (++end <= msg.length()) {
                    String checkWord = msg.substring(idx, end);
                    if (!dictionary.containsKey(checkWord)) {
                        dictionary.put(checkWord, dictionary.size() + 1);
                        idx = end - 1;
                        break;
                    }

                    existWord = checkWord;

                    // 현재 단어가 끝이면 종료
                    if (end == msg.length()) {
                        idx = end;
                    }
                }

                answer.add(dictionary.get(existWord));
            }
            return answer;
        }
    }
}
