package 문제집.프로그래머스.카카오기출.카카오2021.숫자_문자열과_영단어;

public class AnOtherSol {

    public static void main(String[] args) {
        Main.Solution sol = new Main.Solution();
        int solution = sol.solution("2three45sixseven");
        System.out.println(solution);
    }

    static class Solution {
        public int solution(String s) {
            String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
            for(int i = 0; i < strArr.length; i++) {
                s = s.replaceAll(strArr[i], Integer.toString(i));
            }
            return Integer.parseInt(s);
        }
    }

}
