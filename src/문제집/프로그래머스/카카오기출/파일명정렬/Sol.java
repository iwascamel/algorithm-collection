package 문제집.프로그래머스.카카오기출.파일명정렬;

import java.util.Arrays;
import java.util.Comparator;

/*
깔끔한 풀이
 */

class Sol {
    public String[] solution(String[] files) {
        Arrays.sort(files, new StrCmp());
        return files;
    }
    private class StrCmp implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            s1 = s1.toLowerCase();
            s2 = s2.toLowerCase();
            int i = 0;
            int j = 0;
            while (i < s1.length() && !Character.isDigit(s1.charAt(i))) ++i;
            while (j < s2.length() && !Character.isDigit(s2.charAt(j))) ++j;
            int cmp1 = s1.substring(0, i).compareTo(s2.substring(0, j));
            if (cmp1 != 0) return cmp1;
            int startI = i;
            int startJ = j;
            while (i < s1.length() && Character.isDigit(s1.charAt(i))) ++i;
            while (j < s2.length() && Character.isDigit(s2.charAt(j))) ++j;
            int num1 = Integer.parseInt(s1.substring(startI, i));
            int num2 = Integer.parseInt(s2.substring(startJ, j));
            return num1 - num2;
        }
    }
}