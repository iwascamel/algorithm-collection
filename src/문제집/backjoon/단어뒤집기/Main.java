package 문제집.backjoon.단어뒤집기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * date: 21.11.03
 * memo : stack, StringBuilder.reverse() 이용할 수 있는데 나는 sb를 이용해서 풀었다.
 * stack 을 이용한 풀이 link : https://1-7171771.tistory.com/22
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/단어뒤집기/input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<T;i++){
            List<String> list = new ArrayList<>();
            List<String> resList = new ArrayList<>();

            list.add(sc.nextLine());

            for(String s : list){
                String[] split = s.split(" ");

                for(int k=0;k<split.length;k++){
                    StringBuilder sb = new StringBuilder(split[k]);
                    split[k] = sb.reverse().toString();
                }

                resList.addAll(Arrays.asList(split));
            }
            for(String m : resList){
                System.out.print(m + " ");
            }
            System.out.println();
        }
    }
}

