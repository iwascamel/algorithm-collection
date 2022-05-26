package 문제집.프로그래머스.위클리챌린지.상호평가;

import java.util.ArrayList;
import java.util.List;

/**
 * date : 21.10.08
 * memo : 문제 잘못 읽음 -> 행 -> 열
 *
 * i,j -> 문제 읽으면서 0,1 등으로 설정해서 자꾸 답이 틀리게 나왔음
 * link : https://programmers.co.kr/learn/courses/30/lessons/83201
 */


class Main {

    static int N;
    static int max;
    static int min;
    static int INF = 1000;
    static List<boolean[]> boolList;
    static List<int[]> maxminList;
    static List<Integer> resultList;

    public static String solution(int[][] scores) {
        N = scores.length;
        maxminList = new ArrayList<>();
        boolList = new ArrayList<>();
        resultList = new ArrayList<>();

        for(int j=0;j<N;j++){
            max = 0;
            min = INF;

            for(int i=0;i<N;i++){
                int cur = scores[i][j];
                if(cur >= max) max = cur;
                if(cur <= min) min = cur;
            }
            maxminList.add(new int[]{max,min});
            boolList.add(new boolean[]{false,false});
        }


        for(int j=0;j<N;j++){
            int aMax = maxminList.get(j)[0];
            int aMin = maxminList.get(j)[1];

            int aCnt = 0;
            int bCnt = 0;
            for(int i=0;i<N;i++){
                if(scores[i][j] == aMax){
                    aCnt +=1;
                }
                if(scores[i][j] == aMin){
                    bCnt +=1;
                }
            }
            if(aCnt>=2) boolList.get(j)[0] = true;
            if(bCnt>=2) boolList.get(j)[1] = true;
        }

        for(int j=0;j<N;j++){
            int res = 0;
            boolean flag = true;

            for(int i=0;i<N;i++){
                if( i==j && maxminList.get(j)[0] == scores[i][j] && !boolList.get(i)[0]) {
                    flag= false;
                    continue;
                }
                if( i==j && maxminList.get(j)[1] == scores[i][j]  && !boolList.get(i)[1]) {
                    flag = false;
                    continue;
                }

                res += scores[i][j];
            }

            if(flag) res = res/N;
            else res = res/(N-1);

            resultList.add(res);
        }
        List<String> stringList = new ArrayList<>();

        for(int n : resultList){
            String s;

            if(n >=90) s= "A";
            else if(n>=80) s="B";
            else if(n>=70) s="C";
            else if(n>=50) s="D";
            else s="F";

            stringList.add(s);
        }
        StringBuilder sb = new StringBuilder();

        for(String s : stringList){
            sb.append(s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        solution(new int[][]{{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}});
//        solution(new int[][]{{50,90},{50,87}});

    }
}
