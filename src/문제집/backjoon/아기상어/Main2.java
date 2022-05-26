package 문제집.backjoon.아기상어;

public class Main2 {

    static class Shark{
        int x;
        int y;
        int size;
        int qunt;
        int time;

        public Shark(int x, int y, int size, int qunt, int time) {
            this.x = x;
            this.y = y;
            this.size = size;
            if(size==qunt){
                this.size++;
                this.qunt=0;
            }else{
                this.qunt= qunt;
            }
            this.time = time;
        }
        public Shark(){

        }
        @Override
        public String toString() {
            return "Shark{" +
                    "x=" + x +
                    ", y=" + y +
                    ", size=" + size +
                    ", qunt=" + qunt +
                    ", time=" + time +
                    '}';
        }
    }

    static class Fish implements Comparable<Fish>{
        int x;
        int y;
        int size;
        int d; // 상어로부터의 거리

        public Fish(int x, int y, int size, int d) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.d = d;
        }

        @Override
        public int compareTo(Fish o) {
            return 0;
        }
    }

    public static void main(String[] args) {

    }
}
