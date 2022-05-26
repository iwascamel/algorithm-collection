package 문제집.backjoon.압축;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * date : 21.10.22
 * memo : 메모리 초과
 * solution :
 * 1. 가장 안쪽 괄호를 찾는다. 2. 그러기 위해서 ( 를 만나면 새로 시작한다.
 * 3. 가장 안쪽에 있는 ( ) 안에 있는 것을 담고, ( ) 앞에 있는 index 의 값을 곱해준다.
 * 4. 괄호 앞의 값이 0일 때, 1일때, index 가 0일 때 등을 나눠줘야 해서 if 가 많이 생겼고, 풀이가 복잡해졌다.
 */

public class MainFail {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/압축/input.txt"));

        Scanner sc= new Scanner(System.in);

        String input = sc.next();

        StringBuilder sb = new StringBuilder(input);

        while(!check(sb)){
            System.out.println(sb);
            int N = sb.length();

            StringBuilder temp = new StringBuilder();
            int startIndex = 0;
            int endIndex = 0;

            a: for(int i=0;i<N;i++){
                if(sb.charAt(i) == '('){
                    startIndex = i;
                    temp.setLength(0);
                    for(int j=i+1;j<N;j++){
                        if(sb.charAt(j) == '(') continue a;
                        if(sb.charAt(j) == ')') {
                            endIndex = j;
                            break;
                        }
                        temp.append(sb.charAt(j));
                    }
                }
            }
            System.out.println("temp = " + temp);

            if(endIndex-startIndex==1){
                sb.replace(startIndex,endIndex+1,"");
            }else{
                if(startIndex-1 > 0){
                    int multi = Integer.parseInt(String.valueOf(sb.charAt(startIndex-1)));

                    if(multi == 0){
                        sb.replace(startIndex-1,endIndex+1,"0");
                    }else{
                        String app = temp.toString();
                        while(multi -- > 1){
                            temp.append(app);
                        }
                        sb.replace(startIndex-1,endIndex+1,temp.toString());
                    }
                }else{
                    sb.replace(0,endIndex+1,temp.toString());
                }
            }
        }
        if(sb.toString().equals("0")) System.out.println(0);
        else System.out.println(sb.length());
    }

    private static boolean check(StringBuilder sb) {
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i) == '(' || sb.charAt(i) == ')'){
                return false;
            }
        }
        return true;
    }
}
