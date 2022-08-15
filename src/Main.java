
import java.util.*;
import java.util.regex.Pattern;

public class Main{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(1);
        pq.offer(2);
        pq.offer(3);

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        pq.forEach(pq2::offer);
        System.out.println(pq2);
    }
}
