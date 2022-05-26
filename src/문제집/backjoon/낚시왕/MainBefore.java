package 문제집.backjoon.낚시왕;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * date : 21.10.01
 * memo : 내꺼는 터짐-> 교수님에 비해 2가지 구현 방식이 문제
 *
 * 1. 나는 shark 의 위치를 int 로 두었는데, 그냥 shark 형으로 표시하면 된다. 그러고 sharkList.size() == 0 이면 break
 * 2. 방향전환 -> 나는 복잡하게 했는데, 더 쉽게 할 수 있다.
 *
 */

public class MainBefore {

    static int R,C,M;
    static int personLoc;
    static int cnt;

    // 0 위 1 아래 2 오른쪽 3 왼쪽
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};

    static class Shark implements Comparable<Shark>{
        int x;
        int y;
        int speed;
        int direction;
        int size;

        public Shark(int x, int y, int speed, int direction, int size) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }

        @Override
        public int compareTo(Shark o) {
            return Integer.compare(o.size,this.size);
        }
    }

    static List<Shark> list;
    static int[][] map;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/낚시왕/input.txt"));
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        M = sc.nextInt();
        list = new ArrayList<>();
        map = new int[R][C];

        for(int i=0;i<M;i++){
            int x = sc.nextInt();
            int y= sc.nextInt();
            int speed = sc.nextInt();
            int direction = sc.nextInt();
            int size = sc.nextInt();

            map[x-1][y-1] = 1;

            list.add(new Shark(x-1,y-1,speed,direction-1,size));
        }

        personLoc = 0;
        cnt = 0;
        while(personLoc < C){
            eatShark(personLoc);
            clearMap();
            moveShark();
            killDuplicateSharkAndRelocate();
            personLoc++;
        }
        System.out.println(cnt);
    }

    static void printMap(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void killDuplicateSharkAndRelocate() {
        List<Shark> temp = new ArrayList<>();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j] > 1){
                    for (Shark shark : list) {
                        if (shark.x == i && shark.y == j) {
                            temp.add(shark);
                        }
                    }
                    for(Shark shark : temp){
                        list.remove(shark);
                    }
                    Collections.sort(temp);
                    for(int n=1;n<temp.size();n++){
                        temp.get(0).size += temp.get(n).size;
                    }
                    list.add(temp.get(0));
                    map[temp.get(0).x][temp.get(0).y] = 1;
                }
            }
        }
    }

    private static void clearMap() {
        map = new int[R][C];
    }

    private static void moveShark() {
        for(Shark shark : list){
            int moveCnt = shark.speed;
            if(shark.direction == 0 || shark.direction == 1){
                while(moveCnt>0){
                    shark.x += dx[shark.direction];
                    if(shark.x >= R){
                        shark.x = R-2;
                        if(shark.direction == 0) shark.direction=1;
                        else shark.direction=0;
                    }else if(shark.x < 0){
                        shark.x = 1;
                        if(shark.direction == 0) shark.direction=1;
                        else shark.direction=0;
                    }
                    moveCnt--;
                }
            }else if(shark.direction == 2 || shark.direction==3){
                while(moveCnt>0){
                    shark.y += dy[shark.direction];
                    if(shark.y >= C){
                        shark.y = C-2;
                        if(shark.direction == 2) shark.direction=3;
                        else shark.direction=2;
                    }else if(shark.y < 0){
                        shark.y = 1;
                        if(shark.direction == 2) shark.direction=3;
                        else shark.direction=2;
                    }
                    moveCnt--;
                }
            }

            map[shark.x][shark.y] +=1;
        }
    }
    private static void eatShark(int loc) {
        a: for(int i=0;i<R;i++){
            if(map[i][loc] == 1){
                for (Shark next : list) {
                    if (i == next.x && loc == next.y) {
                        cnt += next.size;
                        list.remove(next);
                        break a;
                    }
                }
            }
        }
    }
}
