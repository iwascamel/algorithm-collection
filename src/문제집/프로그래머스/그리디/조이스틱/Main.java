package 문제집.프로그래머스.그리디.조이스틱;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int jeroen = solution.solution("JEROEN");
        System.out.println(jeroen);
    }

    static class Solution {

        int N;
        public int solution(String name) {
            char[] cList = name.toCharArray();
            int[] toIntList = new int[name.length()];
            N = name.length();

            for(int i=0;i<name.length();i++){
                toIntList[i] = cList[i] - 'A';
            }

            System.out.println(Arrays.toString(toIntList));

            for(int i=0;i<name.length();i++){
                toIntList[i] = Math.min(toIntList[i],26-toIntList[i]);
            }

            int index=0;
            int cnt=0;

            while(!everyCountIsZero(toIntList)){
                cnt += toIntList[index];
                toIntList[index]=0;

                if(everyCountIsZero(toIntList)) break;

                int temp = index;
                index = moveToNearNumber(index,toIntList);
                cnt += Math.abs(index-temp);
            }

            System.out.println(cnt);
            return 1;
        }

        private int moveToNearNumber(int index,int[] arr) {

            int cnt1= 0 ;

            int p1 = index+1;
            if(p1>=N) p1 =0;
            while(arr[p1] == 0){
                p1 ++;
                if(p1>=N) p1 =0;
                cnt1++;
            }

            int cnt2 =0;

            int p2 = index-1;
            if(p2<0) p2 =N-1;
            while(arr[p2] == 0){
                p2 --;
                if(p2<=0) p2 =N-1;
                cnt2++;
            }

            if(cnt1>=cnt2){
                return p1;
            }else{
                return p2;
            }
        }

        private boolean everyCountIsZero(int[] toIntList) {
            for(int i=0;i<N;i++){
                if(toIntList[i] != 0) return false;
            }
            return true;
        }

    }
}
