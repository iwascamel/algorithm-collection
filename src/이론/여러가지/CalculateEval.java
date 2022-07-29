import java.util.LinkedList;
import java.util.Stack;

/*
 * date: 22.07.30
 */

public class CalculateEval {
    public static void main(String[] args) {
        String s = "123-4-567";

        LinkedList<Character> op = new LinkedList<>();
        LinkedList<Integer> num = new LinkedList<>();

        s = s.replace(" ","");
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '+' || c == '-' ){
                op.add(c);
            }else{
                int p = i;
                while(p < s.length() && s.charAt(p) != '+' && s.charAt(p) != '-'){
                    p++;
                }
                String iv = s.substring(i,p);
                i = p-1;
                num.add(Integer.valueOf(iv));
            }
        }

        int res = 0;
        while(!num.isEmpty()){
            System.out.println("num = " + num);
            System.out.println("op = " + op);
            int p1 = num.poll();
            if(num.isEmpty()){
                res = p1;
                break;
            }
            int p2 = num.poll();
            char opPop = op.poll();
            int temp;
            if(opPop == '+'){
                temp = p1 + p2;
            }else{
                temp = p1 - p2;
            }
            num.offerFirst(temp);
        }
        System.out.println("res = " + res);
    }
}