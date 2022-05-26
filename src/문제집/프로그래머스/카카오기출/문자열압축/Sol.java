package 문제집.프로그래머스.카카오기출.문자열압축;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
내가 이전에 풀었던 풀이
 */

public class Sol {
    public static void main(String[] args) {

    }

    static class Solution {
        static List<Integer> list;

        public int solution(String s) {

            list = new ArrayList<>();

            if(s.length()==1) return 1;
            if(s.length()==2) return 2;

            int N = s.length();

            for(int i=1;i<N/2+1;i++){
                int j = i;
                StringBuilder sb = new StringBuilder();
                String before = s.substring(0,i);
                int cnt =1;
                while ( j < N){
                    String parsing;
                    if(j+i > N){
                        parsing = s.substring(j,N);
                    }else{
                        parsing = s.substring(j,j+i);
                    }
                    if(before.equals(parsing)){
                        cnt++;
                    }else{
                        if(cnt == 1){
                            sb.append(before);
                        }else{
                            sb.append(cnt);
                            sb.append(before);
                            cnt=1;
                        }
                        before = parsing;
                    }
                    j += i;
                }
                j -= i;
                if ( cnt == 1){
                    sb.append(s, j, N);
                }else{
                    sb.append(cnt);
                    sb.append(before);
                }
                list.add(sb.length());
            }

            Collections.sort(list);

            return list.get(0);
        }
    }

}
