package 문제집.backjoon.게리맨더링;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * date : 21.10.06
 * type : bfs + combination
 */

/**
 * comb -> 0 ~ 2/n 개 선택
 * 선택된 애들이 연결돼있는지 BFS 로 확인 : 하나만 넣어도, 이후 다 연결이 돼있다면 flag 가 모두 true 가 됨
 * 다 연결돼있다면 해당 값들(인구수) 다 더해서 비교
 */

public class Main {

    static int N;
    static int[] arr;
    static int min;
    static List<Integer>[] info;
    static int INF = 1000000;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/게리맨더링/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N+1];
        info = new ArrayList[N+1];
        min = INF;

        for(int i=1;i<N+1;i++){
            arr[i] = sc.nextInt();
        }

        for(int i=1;i<N+1;i++){
            info[i] = new ArrayList<>();
        }

        for(int i=1;i<N+1;i++){
            int n = sc.nextInt();

            for(int j=0;j<n;j++){
                info[i].add(sc.nextInt());
            }
        }

        for(int i=1;i<=N/2;i++){
            comb(0,1,new boolean[N+1],i);
        }
        if(min == INF){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }
    }

    static boolean bfs(List<Integer> list){
        if(!list.isEmpty()){
            boolean[] flag = new boolean[list.size()];
            int a = list.get(0);

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(a);
            flag[0] = true;

            while(!queue.isEmpty()){
                int poll = queue.poll();

                for(int b : info[poll]){
                    int index = findIndexFromList(b,list);
                    if(list.contains(b) && !flag[index]){
                        flag[index]=true;
                        queue.offer(b);
                    }
                }
            }
            for(boolean f : flag){
                if(!f) return false;
            }
            return true;
        }
        return true;
    }

    private static int findIndexFromList(int target,List<Integer> list) {
        for(int i=0;i<list.size();i++){
            if(list.get(i) == target) return i;
        }
        return -1;
    }

    private static void comb(int cnt, int start, boolean[] v,int select) {
        if(cnt==select){
            int res =0;
            List<Integer> checkedList = new ArrayList<>();
            List<Integer> unCheckedList = new ArrayList<>();

            for(int i=1;i<N+1;i++){
                if(v[i]) {
                    checkedList.add(i);
                }else{
                    unCheckedList.add(i);
                }
            }

            if(bfs(checkedList) && bfs(unCheckedList)){
                int a1=0;
                int a2=0;

                for (int a : checkedList) {
                    a1 += arr[a];
                }
                for(int a : unCheckedList){
                    a2 += arr[a];
                }
                res = Math.abs(a1-a2);
                min = Math.min(min,res);
            }
            return ;
        }

        for(int i=start;i<N+1;i++){
            v[i] = true;
            comb(cnt+1,i+1,v,select);
            v[i] = false;
        }
    }
}
