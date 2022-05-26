package 문제집.프로그래머스.해시.전화번호목록;

/**
 * date : 21.10.12
 */

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        solution.solution(new String[]{"119", "97674223", "1195524421"});

    }

    static class Solution {
        public boolean solution(String[] phone_book) {

            int N = phone_book.length;

            for(int i=0;i<N;i++){

                String cur = phone_book[i];

                for(int j=0;j<N;j++){
                    if(i==j) continue;

                    String target= phone_book[j];

                    if(cur.length() <= target.length() && cur.equals(target.substring(0, cur.length()))){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
