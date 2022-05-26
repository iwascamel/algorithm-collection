package 문제집.backjoon.모노미노도미노2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 22.04.25
 * 반례 링크 : https://www.acmicpc.net/board/view/67568
 */

public class Main {
    static int K,N;
    static int[][] map;
    static int lineCnt;
    static class Block {
        int type;
        int x;
        int y;

        public Block(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }
    static Block[] blocks;

    // 우 하
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/모노미노도미노2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        N = 10;
        lineCnt = 0;
        StringTokenizer st;
        blocks = new Block[K];
        for(int i=0;i<K;i++){
            st= new StringTokenizer(br.readLine(), " ");
            int type = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            blocks[i] = new Block(type,x,y);
        }

        map = new int[N][N];
        // type == 2 : y+1
        // type == 3 : x+1
        for(Block block : blocks){
            dfsRight(block);
            dfsDown(block);
        }
        int blockCnt = 0;
        for(int i=6;i<=9;i++){
            for(int j=0;j<4;j++){
                if(map[i][j] == 1) blockCnt++;
            }
        }
        for(int j=6;j<=9;j++){
            for(int i=0;i<4;i++){
                if(map[i][j] == 1) blockCnt++;
            }
        }
        System.out.println(lineCnt);
        System.out.println(blockCnt);
    }

    private static void dfsRight(Block block) {
        int t = block.type;

        int sy = block.y;

        while(!isOut(block) && !isCrash(block)){
            block.y++;
        }
        block.y--;

        int x = block.x;
        int y = block.y;

        block.y = sy;

        if(t==1){
            map[x][y] = 1;
        }else if(t==2){
            map[x][y] = 1;
            map[x][y+1] = 1;
        }else{
            map[x][y] = 1;
            map[x+1][y] = 1;
        }

        for(int j=6;j<=9;j++){
            boolean flag = true;
            for(int i=0;i<4;i++){
                if(map[i][j] != 1){
                    flag = false;
                    break;
                }
            }

            if(flag){
                for(int i=0;i<4;i++){
                    map[i][j] = 0;
                }
                lineCnt ++;
            }
        }

        while (!checkColumn()){
            for(int j=9;j>=5;j--){
                for(int i=0;i<4;i++){
                    map[i][j] = map[i][j-1];
                }
            }
        }
    }

    private static boolean checkColumn() {
        for(int i=0;i<4;i++){
            if(map[i][4]==1 || map[i][5] == 1) {
                return false;
            }
        }
        return true;
    }
    private static boolean checkRow() {
        for(int j=0;j<4;j++){
            if(map[4][j]==1 || map[5][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void dfsDown(Block block) {
        int t = block.type;
        while(!isOut(block) && !isCrash(block)){
            block.x++;
        }
        block.x--;

        int x = block.x;
        int y = block.y;

        if(t==1){
            map[x][y] = 1;
        }else if(t==2){
            map[x][y] = 1;
            map[x][y+1] = 1;
        }else{
            map[x][y] = 1;
            map[x+1][y] = 1;
        }

        for(int i=6;i<=9;i++){
            boolean flag = true;
            for(int j=0;j<4;j++){
                if(map[i][j] != 1){
                    flag = false;
                    break;
                }
            }

            if(flag){
                for(int j=0;j<4;j++){
                    map[i][j] = 0;
                }
                lineCnt ++;
            }
        }

        while (!checkRow()){
            for(int i=9;i>=5;i--){
                for(int j=0;j<4;j++){
                    map[i][j] = map[i-1][j];
                }
            }
        }
    }

    static boolean isOut(Block b){
        int t = b.type;
        int x = b.x;
        int y = b.y;

        if(t==1){
            return x>= N || y>=N;
        }else if(t==2){
            return x >= N || y>=N || y+1>=N;
        }else{
            return x>=N || x+1>=N || y>=N;
        }
    }
    static boolean isCrash(Block b){
        int t = b.type;
        int x = b.x;
        int y = b.y;

        if(t==1){
            return map[x][y] == 1;
        }else if(t==2){
            return map[x][y] == 1 || map[x][y+1] == 1;
        }else{
            return map[x][y] == 1 || map[x+1][y] == 1;
        }
    }
}
