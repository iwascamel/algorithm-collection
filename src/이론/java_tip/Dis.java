package 이론.java_tip;

/*
 * date: 22.07.07
 */

public class Dis {
    public static void main(String[] args) {
        // 1. 정규표현식 이용
        String s= "werew212 qaq1 1aAqwz";
        s = s.replaceAll("[^a-zA-Z]","");
        System.out.println(s);

        // 2. Character isDigit, isAlphabetic 이용
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isAlphabetic(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb);

        // 3. for 'a' <= c <= 'z' 이용
        sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb);
    }
}
