package 문제집.backjoon.골드바흐의추측;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int T;

    static List<Integer> list;
    static boolean[] v;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/골드바흐의추측/input.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int i=0;i<T;i++){
            int N = sc.nextInt();
            v = new boolean[N+1];
            list = new ArrayList<>();
            int[] result = new int[2];

            setPrimeNumbers(N);

            int half = N/2;
            if(list.contains(half)){
                System.out.println(half + " " + half);
            }else{
                int min=Integer.MAX_VALUE;

                int size = list.size();
                for(int j=size-1;j>0;j--){
                    int num = N - list.get(j);
                    if(list.contains(num)){
                        if(min > Math.abs(list.get(j) - num)){
                            result[0] =num;
                            result[1] = list.get(j);
                            min = Math.abs(list.get(j)-num);
                        }
                    }
                }
                Arrays.sort(result);
                System.out.println(result[0] + " " + result[1]);
            }
        }
    }

    private static void setPrimeNumbers(int N) {

        for(int i=2;i<N+1;i++){
            if(!v[i]){
                list.add(i);

                for(int j=i;j<N+1;j=j+i){
                    v[j] = true;
                }
            }
        }
    }
}
