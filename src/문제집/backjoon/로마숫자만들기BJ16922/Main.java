package 문제집.backjoon.로마숫자만들기BJ16922;

/*
 * date: 22.06.26
 */

 import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static class Point{
        int num;
        int n;
        public Point(int num, int n) {
            this.num = num;
            this.n = n;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + n;
            result = prime * result + num;
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Point other = (Point) obj;
            if (n != other.n)
                return false;
            if (num != other.num)
                return false;
            return true;
        }
    }

    static int N;
    static Set<Integer> set;
    static Set<Point> cache;
    static int[] arr = new int[]{1,5,10,50};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        set = new HashSet<>();
        cache = new HashSet<>();

        dfs(N,0);
        System.out.println(set.size());
    }
    private static void dfs(int n, int sum) {
        if(cache.contains(new Point(sum,n))){
            return;
        }
        if(n==0){
            set.add(sum);
            return;
        }
        for(int num : arr){
            int newSum = sum + num;
            dfs(n-1,newSum);
            cache.add(new Point(newSum, n-1));
        }
    }
}
