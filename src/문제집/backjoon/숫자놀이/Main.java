package 문제집.backjoon.숫자놀이;

import java.util.*;

/**
 * date : 21.09.27
 * type : 구현
 * comment : ssafy 월말평가
 */

public class Main {

    static String[] words;
    static Map<String,Integer> map;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        words = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
        int M = sc.nextInt();
        int N = sc.nextInt();

        List<Integer> numberList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        map = new HashMap<>();

        // 문자 -> 숫자로 바꿔주기 위해 map 선언
        for(int i=0;i<10;i++){
            map.put(words[i],i);
        }

        // 범위값 list 에 담기
        for(int i=M;i<=N;i++){
            numberList.add(i);
        }

        // 숫자 -> 문자로 바꿔주기 ex) 28 -> two eight
        for(int num : numberList){
            StringBuilder sb = new StringBuilder();

            String s = String.valueOf(num);
            for(int i=0;i<s.length();i++){
                sb.append(words[Integer.parseInt(String.valueOf(s.charAt(i)))]);
                sb.append(" ");
            }
            sb.setLength(sb.length()-1);
            stringList.add(sb.toString());
        }

        // 사전식으로 정렬
        Collections.sort(stringList);

        // 문자 -> 숫자로 바꿔주기
        for(String s : stringList){
            String[] split = s.split(" ");

            // 두자리수와, 한자리수 나누어서 따지기
            if(split.length < 2){
                resultList.add(map.get(split[0]));
            }else{
                String sb = String.valueOf(map.get(split[0])) +
                        map.get(split[1]);
                resultList.add(Integer.parseInt(sb));
            }
        }

        int cnt=0;
        // 출력하기 10줄 단위로 출력
        for(int i=0;i<resultList.size();i++){
            if(cnt == 10){
                System.out.println();
                cnt=0;
            }
            System.out.print(resultList.get(i) + " ");
            cnt++;
        }
    }
}
