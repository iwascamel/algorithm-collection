package 문제집.backjoon.신입사원;

import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int N;
    static boolean[] v;
    static class Person{
        int idx;
        int s1;
        int s2;

        public Person(int s1,int s2){
            this.s1 = s1;
            this.s2 = s2;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/신입사원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t=0;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            Person[] persons = new Person[N];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s1 = Integer.parseInt(st.nextToken());
                int s2 = Integer.parseInt(st.nextToken());
                persons[i] = new Person(s1, s2);
            }

            v = new boolean[N];
            

        }
    }
}
