package 문제집.backjoon.컨베이어벨트위의로봇;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * link : https://haerang94.tistory.com/384
 */

public class SolV2 {

    static int n,k;
    static int[] belt;
    static ArrayList<Integer> list=new ArrayList<>();
    static boolean[] pos;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/컨베이어벨트위의로봇/input.txt"));
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();// 길이 컨베이어 길이는 2n
        k=sc.nextInt();
        belt=new int[2*n];
        pos=new boolean[2*n];
        for (int i = 0; i < 2*n; i++) {
            belt[i]=sc.nextInt();
        }

        for (int i = 0; i < 2*n; i++) {
            list.add(i);
        }
        int time=1;
        int cnt=0;

        while(true) {
//			1번 한 칸 회전
            System.out.println("=============");
            for(int i=0;i<n;i++){
                System.out.print(belt[i] + " ");
            }
            System.out.println();
            for(int i=n;i<2*n;i++){
                System.out.print(belt[i] + " ");
            }
            System.out.println("=============");
            int cur=list.get(list.size()-1);
            list.remove(list.size()-1);
            list.add(0, cur);
            int up=list.get(0); //타는 곳
            int down=list.get(n-1); //내리는 곳

            //내릴 로봇은 내리기
            if(pos[down]) {//회전 시켰을 때 내릴 위치에 온 로봇 내림
                pos[down]=false;
            }
            //로봇 스스로 이동
            for (int i = n-1; i >=0; i--) {
                int idx=list.get(i);
                int next=list.get(i+1);
                if(pos[idx]==true && belt[next]>=1 && pos[next]==false) {
                    belt[next]-=1;
                    pos[next]=true;
                    pos[idx]=false;
                    if(belt[next]==0)cnt++;
                }
            }
            //내릴 로봇은 내리기
            if(pos[down]) {
                pos[down]=false;
            }

            //로봇 올리기
            if(belt[up]>=1 && pos[up]==false) {
                pos[up]=true;
                belt[up]-=1;
                if(belt[up]==0)cnt++;
            }

            if(cnt>=k)break;
            time++;

        }

        System.out.println(time);
    }
}
