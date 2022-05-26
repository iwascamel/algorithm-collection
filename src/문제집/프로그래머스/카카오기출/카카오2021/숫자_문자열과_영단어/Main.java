package 문제집.프로그래머스.카카오기출.카카오2021.숫자_문자열과_영단어;

import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {

        Solution sol = new Solution();
        sol.solution("2three45sixseven");
    }

    static class Solution{
        static Map<String,Integer> map;
        static String[] numbers = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        public int solution(String s){
            map = new HashMap<>();

            for(int i=0;i<10;i++){
                map.put(numbers[i],i);
            }

            StringBuilder sb = new StringBuilder();
            StringBuilder temp = new StringBuilder();
            for(int i=0;i<s.length();i++){
                char current = s.charAt(i);

                if(Character.isAlphabetic(current)){
                    temp.append(current);

                    if(map.containsKey(temp.toString())){
                        sb.append(map.get(temp.toString()));
                        temp.setLength(0);
                    }
                }else{
                    sb.append(current);
                }
            }

            return Integer.parseInt(sb.toString());
        }
    }
}
