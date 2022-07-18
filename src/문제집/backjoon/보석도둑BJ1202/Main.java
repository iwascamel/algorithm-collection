package 문제집.backjoon.보석도둑BJ1202;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * date: 22.07.18
 */

public class Main {
    static int N,K;
    static int[] bagArr;
    static Gem[] gemArr;

    static class Gem implements Comparable<Gem>{
        int weight;
        int price;

        public Gem(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Gem o) {
            return Integer.compare(this.weight,o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/보석도둑BJ1202/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bagArr = new int[K];
        gemArr = new Gem[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            gemArr[i] = new Gem(weight,price);
        }
        for(int i=0;i<K;i++){
            int bagWeight = Integer.parseInt(br.readLine());
            bagArr[i] = bagWeight;
        }

        Arrays.sort(bagArr);
        Arrays.sort(gemArr);

        int idx = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o2,o1));
        long resultPrice = 0;

        for(int i=0;i<K;i++){
            while(idx < N && gemArr[idx].weight <= bagArr[i]){
                pq.offer(gemArr[idx].price);
                idx++;
            }

            if(!pq.isEmpty()){
                resultPrice += pq.poll();
            }
        }
        System.out.println(resultPrice);
    }
}
