package 문제집.backjoon.숫자카드2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * date : 22.01.07
 * memo : 답은 맞게 나오나 시간초과
 */

public class Main {

    static int N,M;
    static int[] arr;
    static int[] verify;
    static List<Integer> list;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/숫자카드2/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        list = new ArrayList<>();
        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        M = sc.nextInt();
        verify = new int[M];

        for(int i=0;i<M;i++){
            verify[i] = sc.nextInt();
        }

        setNumbers();
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i) + " ");
        }
    }

    private static void setNumbers() {
        for(int i=0;i<M;i++){
            int key = verify[i];

            int start = 0;
            int end = N-1;

            boolean flag = false;

            while(start<=end){
                int middle = (start+end)/2;

                if(arr[middle] == key){
                    int cnt=1;
                    int left = middle-1;
                    int right = middle+1;

                    while(left >=0 && arr[middle] == arr[left]){
                        cnt++;
                        left--;
                    }
                    while(right < N && arr[middle] == arr[right]){
                        cnt++;
                        right++;
                    }
                    flag = true;
                    list.add(cnt);
                    break;

                }else if(arr[middle] > key){
                    end = middle-1;
                }else{
                    start = middle+1;
                }
            }
            if(!flag){
                list.add(0);
            }
        }
    }
}
