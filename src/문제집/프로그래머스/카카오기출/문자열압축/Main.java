package 문제집.프로그래머스.카카오기출.문자열압축;

/**
 * date : 22.01.28
 */

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int aaaaaaaaaaaabcd = solution.solution("abababab");
        System.out.println(aaaaaaaaaaaabcd);
    }
    static class Solution {
        public int solution(String s) {
            if(s.length()<=1) return 1;
            int min = Integer.MAX_VALUE;
            int N = s.length();
            for(int w=1;w<=N/2;w++){
                int p = 0;
                StringBuilder sb = new StringBuilder();
                int cnt=1;
                // <= <-- = 없었다. 아래 cnt+1을 안해줘도 되는 이유
                while(p+w+w<=N){
                    String s1 = s.substring(p,p+w);
                    String s2 = s.substring(p+w,p+w+w);
                    if(s1.equals(s2)){
                        cnt+=1;
                    }else{
                        if(cnt==1){
                            sb.append(s1);
                        }else{
                            sb.append(cnt).append(s1);
                            cnt=1;
                        }
                    }
                    p = p+w;
                }
                // 같은데 나오는 경우
                // 달라서 나오는 경우
                if(cnt>1){
                    // cnt + 1 이라고 한 것 때문에 틀렸었다.
                    sb.append(cnt).append(s,p,p+w);
                    p += w;
                }
                while(p<N) sb.append(s.charAt(p++));
                System.out.println(sb);
                min = Math.min(min,sb.length());
            }
            return min;
        }
    }
}
