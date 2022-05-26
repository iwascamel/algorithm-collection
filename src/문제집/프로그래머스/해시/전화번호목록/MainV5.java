package 문제집.프로그래머스.해시.전화번호목록;

import java.util.Arrays;
import java.util.Comparator;

/**
 * memo : 런타임에러 ... why? --> 사전순 정렬 : 12342354 < 191
 * 그래사 그냥 정렬하면 에러를 뱉었던 것
 */

public class MainV5 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        boolean solution1 = solution.solution(new String[]{"119", "97674223", "1195524421"});
        System.out.println(solution1);

    }

    static class Solution {
        public boolean solution(String[] phone_book) {

            int N = phone_book.length;

            Comparator<String> comp = new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {

                    int ol1 = o1.length();
                    int ol2 = o2.length();

                    if(ol1 == ol2){
                        return o1.compareTo(o2);
                    }
                    return Integer.compare(ol1,ol2);
                }
            };

            Arrays.sort(phone_book,comp);
            System.out.println(Arrays.toString(phone_book));

            for(int i=0;i<N-1;i++){
                String cur = phone_book[i];

                String target = phone_book[i+1].substring(0,cur.length());

                if(cur.equals(target)) return false;
            }
            return true;
        }
    }
}
