package 문제집.backjoon.백설공주와일곱난쟁이;

import java.util.Scanner;

// 8월 12일 숙제 - 조합
public class Main {

    static int[] input;
    static int[] temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        input = new int[9];
        temp = new int[7];

        for(int i=0;i<9;i++){
            input[i] = sc.nextInt();
        }
        combination(0,0);
    }

    static void combination(int start,int count){
        if(count==7){
            int sum = getSum();
            if(sum==100){
                for(int i : temp){
                    System.out.println(i);
                }
            }
            return ;
        }
        for(int i=start;i<9;i++){
            temp[count] = input[i];
            combination(i+1,count+1);
        }
    }
    static int getSum(){
        int sum=0;
        for(int i=0;i< temp.length;i++){
            sum += temp[i];
        }
        return sum;
    }
}
