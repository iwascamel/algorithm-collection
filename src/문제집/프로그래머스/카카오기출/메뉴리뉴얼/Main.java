package 문제집.프로그래머스.카카오기출.메뉴리뉴얼;

import java.util.*;

/**
 * date : 22.02.24
 */

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] solution1 = solution.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5});
        System.out.println(Arrays.toString(solution1));
    }

    static class Solution {
        static int N;
        static List<int[]> combList;
        public String[] solution(String[] orders, int[] course) {
            Map<String,Integer> map = new HashMap<>();
            Arrays.sort(course);

            // 각 order 까지의 문자열의 조합을 map 에 저장
            // ex) ABCDE -> [AB,AC....] , [ABC,ADE...]
            for(String order : orders){
                char[] chars = order.toCharArray();
                N = chars.length;
                for(int i=2;i<=N;i++){
                    combList = new ArrayList<>();
                    setComb(0,0,new int[i],i);

                    for(int[] arr : combList){
                        List<Character> characterList = new ArrayList<>();
                        for(int a : arr){
                            characterList.add(chars[a]);
                        }
                        Collections.sort(characterList);
                        StringBuilder sb = new StringBuilder();
                        for(char c : characterList) sb.append(c);
                        map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
                    }
                }
            }

            Set<String> keys = map.keySet();
            List<String> result = new ArrayList<>();

            // 개수세기
            for(int c : course){
                int max = 0;
                for(String word : keys){
                    if(word.length() == c){
                        max = Math.max(max,map.get(word));
                    }
                }
                for(String word : keys){
                    if(word.length() == c && map.get(word) == max && map.get(word)>=2) result.add(word);
                }
            }
            Collections.sort(result);

            String[] res = new String[result.size()];
            for(int i=0;i<result.size();i++){
                res[i] = result.get(i);
            }
            return res;

        }

        static void setComb(int cnt, int start, int[] temp,int pick){
            if(cnt == pick){
                combList.add(temp.clone());
                return ;
            }
            for(int i=start;i<N;i++){
                temp[cnt] = i;
                setComb(cnt+1,i+1,temp,pick);
            }
        }
    }


}
