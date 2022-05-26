package 문제집.backjoon.크로스워드만들기;

import java.util.*;

// 2804번. IM 시리즈 ( swexpert 13기 공지 ) 크로스워드 만들기
public class CrossWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();

        Set<Character> setA = new HashSet<>();
        Set<Character> setB = new HashSet<>();

        List<Character> list = new ArrayList<>();

        for(int i=0;i<A.length();i++){
            setA.add(A.charAt(i));
        }
        for(int i=0;i<B.length();i++){
            setB.add(B.charAt(i));
        }

        Iterator<Character> iter = setA.iterator();

        while(iter.hasNext()){
            Character next = iter.next();
            if(setB.contains(next)){
                list.add(next);
            }
        }

        int indexA = 0;
        int indexB = 0;

        for(int i=0;i<A.length();i++){
            if(list.contains(A.charAt(i))){
                indexA = i;
                break;
            }
        }
        for(int i=0;i<B.length();i++){
            if(list.contains(B.charAt(i))){
                indexB = i;
                break;
            }
        }
        char[][] result = new char[B.length()][A.length()];

        int charIndexA = 0;
        int charIndexB = 0;

        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                if(i==indexB){
                    result[i][j] = A.charAt(j) ;
                } else if(j==indexA){
                    result[i][j] = B.charAt(i) ;
                }else{
                    result[i][j] = '.';
                }
            }
        }
        print(result);

    }

    static void print(char[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + "");
            }
            if(i!=arr.length-1){
                System.out.println();
            }
        }
    }
}
