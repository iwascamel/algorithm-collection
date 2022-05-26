package 문제집.프로그래머스.카카오기출.기출2019.실패율;

import java.util.*;

/**
 * date : 22.02.24
 */

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(4, new int[]{2,1,2,3});
        System.out.println(Arrays.toString(solution1));
    }
    static class Solution {
        public int[] solution(int N, int[] stages) {
            Map<Integer,int[]> map = new HashMap<>();
            for(int num : stages){
                for(int i=1;i<num;i++){
                    int[] arr = map.getOrDefault(i, new int[2]);
                    arr[0] += 1;
                    map.put(i,arr);
                }
                int[] arr2 = map.getOrDefault(num, new int[2]);
                arr2[1] += 1;
                map.put(num,arr2);
            }

            List<double[]> res = new ArrayList<>();


            Set<Integer> integers = map.keySet();
            for(int n : integers){
                int[] arr = map.get(n);
                double a1 = arr[1];
                double a2 = arr[0]+arr[1];

                double ratio;
                if(a2==0){
                    ratio = 0;
                }else{
                    ratio = a1/a2;
                }

                res.add(new double[]{n,ratio});
            }

            // 이 조건을 안 달아서 헤맸다.
            // [ 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다. ]
            for(int i=1;i<=N;i++){
                if(!map.containsKey(i)){
                    res.add(new double[]{i,0});
                }
            }

            Comparator<double[]> comp = new Comparator<double[]>() {
                @Override
                public int compare(double[] o1, double[] o2) {
                    if(o1[1] != o2[1]){
                        return Double.compare(o2[1],o1[1]);
                    }else{
                        return Double.compare(o1[0],o2[0]);
                    }
                }
            };

            res.sort(comp);
            List<Integer> resultList = new ArrayList<>();

            for(double[] a : res){
                int parse = (int) a[0];
                if(parse <= N) resultList.add(parse);
            }
            int[] aar = new int[resultList.size()];
            for(int i=0;i<resultList.size();i++){
                aar[i] = resultList.get(i);
            }
            return aar;
        }
    }
}
