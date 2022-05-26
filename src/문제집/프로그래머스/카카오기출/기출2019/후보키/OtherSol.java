package 문제집.프로그래머스.카카오기출.기출2019.후보키;

import java.util.LinkedList;
import java.util.List;

/**
 * date: 22.02.25
 * link: https://www.youtube.com/watch?v=-QQ18ZA7qrc&list=PL6YHvWRMtz7CyRH31LhCHR0gp_x7eeSK6&index=3
 * memo: 유투브 풀이
 * memo: 하다가 일단은 패스...
 */

public class OtherSol {
    public static void main(String[] args) {

    }

    static class Solution {
        public int solution(String[][] relation) {
            int answer = 0;

            int N = relation.length;
            int M = relation[0].length;
            List<Integer> candidates = new LinkedList<>();

            for(int i=1;i< 1<<M ; i++){
                if(check(relation,N,M,i)){
                    candidates.add(i);
                }
            }

            return 1;
        }

        private boolean check(String[][] relation, int N, int M, int key) {
            for(int a=0;a<N;a++){
                for(int b=a+1;b<M;b++){
                    boolean isSame = true;
                    for(int k=0;k<N;k++){
                        if( (key & 1<<k) == 0) continue;
                        if(!relation[a][k].equals(relation[b][k])){
                            isSame = false;
                            break;
                        }
                    }
                    if(isSame) return false;
                }
            }
            return true;
        }
    }
}
