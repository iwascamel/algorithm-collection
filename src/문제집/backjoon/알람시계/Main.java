package 문제집.backjoon.알람시계;

import java.util.Scanner;

/**
 * date : 22.03.01
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int min = sc.nextInt();

        if(min >= 45){
            int newMin = min - 45;
            System.out.println(hour + " " + newMin);
        }else{
            if(hour >= 1){
                int newHour = hour -1;
                int newMin = min - 45 + 60;
                System.out.println(newHour + " " + newMin);
            }else{
                int newHour = 23;
                int newMin = min - 45 + 60;
                System.out.println(newHour + " " + newMin);
            }
        }
    }
}
