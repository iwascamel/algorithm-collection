package 문제집.backjoon.크로아티아알파벳;

import java.util.Scanner;

public class CroatiaV2 {
    static String[] arr = {"c=","c-","dz=","d-","lj","nj","s=","z="};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = "ljes=njak";

        for(String value : arr){
            System.out.println(value);
            if(s.contains(value)){
                s = s.replace(value, " ");
            }
        }
        System.out.println(s.length());
    }
}
