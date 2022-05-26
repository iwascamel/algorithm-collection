package 문제집.backjoon.탑;

import java.io.*;

// 2495번 탑
public class Top_2495_V2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/backjoon/탑/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int NUMS = Integer.parseInt(br.readLine());

        int[] arr = new int[NUMS];

        String[] inputArray = br.readLine().split(" ");

        for(int i=0;i<NUMS;i++){
            arr[i]= Integer.parseInt(inputArray[i]);
        }

        int[] result = new int[NUMS];

        for(int i=NUMS-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                if(arr[i] <= arr[j]){
                    result[i] = j+1;
                    break;
                }
                // 만약 마지막까지 갔는데도 크다면
                if(j==0){
                    if(arr[i] > arr[j]){
                        result[i] =0;
                    }
                }
            }
        }
        for(int i : result){
            System.out.print(i + " ");
        }
    }
}
