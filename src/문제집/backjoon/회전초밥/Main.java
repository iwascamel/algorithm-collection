package 문제집.backjoon.회전초밥;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    static int N, d, k, c;
    static int[] arr,visit;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/회전초밥/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        d = sc.nextInt();
        k = sc.nextInt(); // 연속해서 먹는 접시 수
        c = sc.nextInt(); // 쿠폰 번호

        visit = new int[d+1];
        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(slide());
    }

    private static int slide() {
        int total = 0, max = 0;

        // 초기값
        for(int i=0; i<k; i++){
            if(visit[arr[i]] == 0) total++;
            visit[arr[i]]++;
        }

        max = total;

        for(int i=1;i<N;i++){
            if(max <= total){
                if(visit[c]==0) max = total +1;
                else max = total;
            }
            visit[arr[i-1]]--;
            if(visit[arr[i-1]]==0) total--;

            if(visit[arr[(i+k-1)%N]]==0) total++;
            visit[arr[(i+k-1)%N]]++;
        }

        return max;
    }
}
