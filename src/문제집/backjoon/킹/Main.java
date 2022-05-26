package 문제집.backjoon.킹;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * date: 22.03.03
 */

public class Main {
    static int N = 8;
    static char[] chars = "ABCDEFGH".toCharArray();
    static int[][] map;
    // R L B T RT LT RB LB
    static int[] dx = {0,0,1,-1,-1,-1,1,1};
    static int[] dy = {1,-1,0,0,1,-1,1,-1};
    static Map<String,Integer> moveMap;
    static List<String> moveList;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/킹/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        map = new int[N+1][N+1];
        String kingStartString = st.nextToken();
        String rockStartString = st.nextToken();
        int moveCount = Integer.parseInt(st.nextToken());
        moveList = new ArrayList<>();

        for(int i=0;i<moveCount;i++){
            moveList.add(br.readLine());
        }

        Map<Character,Integer> locMap = new HashMap<>();
        Map<Integer,Character> locMap2 = new HashMap<>();
        moveMap = new HashMap<>();

        for(int i=0;i<N;i++){
            locMap.put(chars[i],i+1);
        }
        for(int i=0;i<N;i++){
            locMap2.put(i+1,chars[i]);
        }
        setMoveMap();
        int kingCurX = 9 - Integer.parseInt(String.valueOf(kingStartString.charAt(1)));
        int kingCurY = locMap.get(kingStartString.charAt(0));

        int rockCurX = 9 - Integer.parseInt(String.valueOf(rockStartString.charAt(1)));
        int rockCurY = locMap.get(rockStartString.charAt(0));

        for(String move : moveList){
            int nx = dx[moveMap.get(move)];
            int ny = dy[moveMap.get(move)];

            int kx = kingCurX + nx;
            int ky = kingCurY + ny;

            if(isOut(kx,ky)) continue;

            int rx = rockCurX + nx;
            int ry = rockCurY + ny;

            if(kx == rockCurX && ky == rockCurY && isOut(rx,ry)) continue;

            kingCurX = kx;
            kingCurY = ky;

            if(kx == rockCurX && ky == rockCurY){
                rockCurX = rx;
                rockCurY = ry;
            }
        }

        kingCurX = 9 - kingCurX;
        rockCurX = 9 - rockCurX;

        char kingY = locMap2.get(kingCurY);
        char rockY = locMap2.get(rockCurY);

        StringBuilder sb = new StringBuilder();
        sb.append(kingY).append(kingCurX);
        System.out.println(sb);
        sb = new StringBuilder();
        sb.append(rockY).append(rockCurX);
        System.out.println(sb);
    }

    static boolean isOut(int nx,int ny){
        return nx<1 || ny<1 || nx>N || ny>N;
    }

    private static void setMoveMap() {
        moveMap.put("R",0);
        moveMap.put("L",1);
        moveMap.put("B",2);
        moveMap.put("T",3);
        moveMap.put("RT",4);
        moveMap.put("LT",5);
        moveMap.put("RB",6);
        moveMap.put("LB",7);
    }
}
