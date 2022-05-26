package 문제집.backjoon.소수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static boolean[] v;
    static List<Integer> list;
    static List<Integer> result;

    public static void main(String[] args) {
        N=1000;
        v= new boolean[1001];
        list = new ArrayList<>();
        result = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();

        Arrays.fill(v,true);
        v[0]=false;
        v[1]=false;

        for(int i=2;i<N+1;i++){
            if(v[i]){
                list.add(i);
                for(int j=i;j<N+1;j=j+i){
                    v[j] = false;
                }
            }
        }

        for(int i=0;i<list.size();i++){
            if(list.get(i) >= start && list.get(i) <= end) result.add(list.get(i));
        }
        int sum=0;

        for(int n : result){
            sum +=n;
        }

        if(result.isEmpty()){
            System.out.println(-1);
        }else{
            System.out.println(sum);
            System.out.print(result.get(0));
        }
    }
}
