package 문제집.backjoon.회전초밥;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * date : 21.10.05
 * memo : 시간초과
 */

public class MainFail {

    static int N,maxNum, dishNum,coupon;
    static Queue<Integer> queue;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/회전초밥/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        maxNum = sc.nextInt();
        dishNum = sc.nextInt(); // 연속해서 먹는 접시 수
        coupon = sc.nextInt(); // 쿠폰 번호

        queue = new LinkedList<>();

        int num = N;
        while(num-->0){
            queue.offer(sc.nextInt());
        }

        num = N;
        int cnt = 0;
        Set<Integer> set = null;

        int max=0;

        while(num - cnt >0){
            int plus=0;
            set = new HashSet<>();
            Queue<Integer> copyQueue = copyQueue();

            int t = cnt;
            // 순서
            while(t -- > 0){
                Integer poll = copyQueue.poll();
                copyQueue.offer(poll);
            }

            // 접시 숫자만큼 꺼냄
            int temp = dishNum;
            while(temp -- >0){
                set.add(copyQueue.poll());
            }
            if(!set.contains(coupon)){
                plus ++;
            }
            cnt++;
            max = Math.max(set.size()+plus,max);
        }

        System.out.println(max);


    }

    private static Queue<Integer> copyQueue() {
        Queue<Integer> result = new LinkedList<>();

        int num = N;
        while(num-->0 && !queue.isEmpty()){
            int poll = queue.poll();

            result.offer(poll);
            queue.offer(poll);
        }
        return result;
    }
}
