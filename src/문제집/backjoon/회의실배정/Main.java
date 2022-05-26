package 문제집.backjoon.회의실배정;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    static int N;
    static Room[] arr;

    static class Room{
        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Room{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/회의실배정/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new Room[N];

        for(int i=0;i<N;i++){
            arr[i] = new Room(sc.nextInt(),sc.nextInt());
        }

        for(int i=0;i<N;i++){
            System.out.println(arr[i]);
        }

        Comparator<Room> comp = new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                int v = o1.end - o2.end;
                if(v!=0) return v;
                return o1.start - o2.start;
            }
        };

        Arrays.sort(arr,comp);

        List<Room> list = new ArrayList<>();

        list.add(arr[0]);

        for(int i=1;i<N;i++){
            if(list.get(list.size()-1).end <= arr[i].start){
                list.add(arr[i]);
            }
        }

        System.out.println("====");

        for(Room r : list){
            System.out.println(r);
        }

        System.out.println(list.size());
    }
}
