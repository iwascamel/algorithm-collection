package 문제집.프로그래머스.카카오기출.기출2019.후보키;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * date: 22.02.25
 */

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int solution1 = solution.solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}});
//        int solution1 = solution.solution(new String[][]{{"a","1","aaa","c","ng"},{"b","1","bbb","c","g"},{"c","1","aaa","d","ng"},{"d","2","bbb","d","ng"}});
        int solution1 = solution.solution(new String[][]{{"a","1","aaa","c","ng"},{"a","1","bbb","e","g"},{"c","1","aaa","d","ng"},{"d","2","bbb","d","ng"}});

        System.out.println(solution1);
    }
    static class Solution {
        static int N,M;
        static int[] temp;
        static List<int[]> combList;
        public int solution(String[][] relation) {
            N = relation.length;
            M = relation[0].length;
            List<int[]> resultList = new ArrayList<>();

            for(int j=1;j<=M;j++){
                combList = new ArrayList<>();
                temp = new int[j];
                setComb(0,0,j);

                loop: for(int[] a : combList){
                    for(int[] already : resultList){
                        if(isContain(already,a)) continue loop;
                    }

                    Set<String> set = new HashSet<>();
                    for(int i=0;i<N;i++){
                        StringBuilder sb = new StringBuilder();
                        for(int num : a){
                            sb.append(relation[i][num]);
                        }
                        if(set.contains(sb.toString())){
                            continue loop;
                        }
                        else set.add(sb.toString());
                    }
                    resultList.add(a);
                }
            }
            return resultList.size();
        }

        private boolean isContain(int[] already, int[] a) {
            int p1 = 0;
            int p2 = 0;

            if(already.length > a.length) return false;

            while(p2 < a.length && p1 < already.length){
                if(already[p1] == a[p2]){
                    p1++;
                }
                p2++;
            }
            return p1 == already.length;
        }

        static void setComb(int cnt,int start, int aim){
            if(cnt == aim){
                combList.add(temp.clone());
                return ;
            }

            for(int i=start;i<M;i++){
                temp[cnt] = i;
                setComb(cnt+1,i+1,aim);
            }
        }
    }
}
