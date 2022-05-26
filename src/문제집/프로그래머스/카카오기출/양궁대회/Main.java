package 문제집.프로그래머스.카카오기출.양궁대회;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(10, new int[]{0,0,0,0,0,0,0,0,3,4,3});
        System.out.println(Arrays.toString(solution1));
    }

    static class Solution {
        static int[] user;
        static int[] infos;
        static int N;
        static List<int[]> list;
        static int maxScore;
        public int[] solution(int n, int[] info) {
            N = n;
            user = new int[11];
            infos = info.clone();
            maxScore = 0;
            list = new ArrayList<>();
            dfs(0);
            Comparator<int[]> comp = new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    for(int i=10;i>=0;i--){
                        if(o1[i]!=o2[i]){
                            return Integer.compare(o2[i],o1[i]);
                        }
                    }
                    return 0;
                }
            };

            list.sort(comp);
            if(list.isEmpty()){
                return new int[]{-1};
            }else{
                return list.get(0);
            }
        }

        private void dfs(int cnt) {
            if(cnt == N){
                int userScore =0 ;
                int infoScore =0;

                for(int i=0;i<=10;i++){
                    if( user[i] ==0 && infos[i] ==0 ) continue;
                    if(user[i] > infos[i]) userScore += 10-i;
                    else infoScore += 10-i;
                }
                if(userScore > infoScore && maxScore <= userScore - infoScore){
                    maxScore = userScore - infoScore;
                    list.add(user.clone());
                }
                return ;
            }

            for(int i=0;i<=10;i++){
                if(user[i] <= infos[i]){
                    user[i]++;
                    dfs(cnt+1);
                    user[i]--;
                }
            }
        }
    }
}
