package 문제집.backjoon.배열돌리기4;

import java.util.Scanner;

public class Teacher {
    static int N,M, K;
    static int[][] A;
    static int[][] Copy;
    static int[][] KA; //회전관련 배열
    static int direction;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};

    static int KK;//겹
    static int count;

    //순열
    static int [] num;
    static boolean [] v;
    //순열안에서 최소 비교
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        K=sc.nextInt();
        A=new int[N][M];
        Copy =new int[N][M];
        KA=new int[K][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j]=sc.nextInt();
            }
        }
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 3; j++) {
                KA[i][j]=sc.nextInt();
            }
        }
        //로직
        count=0;
        min=Integer.MAX_VALUE;
        num=new int[K];
        v=new boolean[K];
        nPr(0);
        System.out.println(min);
    }
    public static void nPr(int cnt) {
        if(K==cnt){
            //로직 넣으세요
            return ;
        }
        for (int i = 0; i < K; i++) {
            if(v[i])continue;
            v[i]=true;
            num[cnt]=i;
            nPr(cnt+1);
            v[i]=false;
        }
    }
}







