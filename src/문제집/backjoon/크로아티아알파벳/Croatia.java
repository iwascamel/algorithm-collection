package 문제집.backjoon.크로아티아알파벳;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Croatia {

    static String[] arr = {"c=","c-","dz=","d-","lj","nj","s=","z="};

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        String s= sc.next();
        String sPlusTrash = s+"**";

        int count=0;

        a:for(int i=0;i<sPlusTrash.length()-2;i++){
            String s1 = sPlusTrash.substring(i, i + 2);
            String s2 = sPlusTrash.substring(i, i+3);

            for(String v : arr){
                if(s1.equals(v)){
                    count+=1;
                    i=i+1;
                    continue a;
                }else if(s2.equals(v)){
                    count+=1;
                    i=i+2;
                    continue a;
                }
            }
            count+=1;
        }
        System.out.println(count);
    }
}
