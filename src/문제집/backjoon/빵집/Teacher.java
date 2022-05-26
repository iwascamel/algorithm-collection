package 문제집.backjoon.빵집;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Teacher {

    static int R, C;
    static char[][] map;
    static int result;

    static int[] dr={-1,0,1};
    static int[] dc={ 1,1,1};

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/빵집/input.txt"));

        Scanner scann=new Scanner(System.in);
        R=scann.nextInt();
        C=scann.nextInt();
        map=new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] c=scann.next().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j]=c[j];
            }
        }
        result=0;
        //i=0 가스관 col=C-1 빵집
        for (int i = 0; i < R; i++) {
            if(map[i][0]=='.'){    //x
                if(dfs(i,0)) result++; // 도착하면 ++
            }
        }
        print();
        System.out.println(result);
    }
    // 성공한 길을 다시 갈수 없다. 'c'나 'x'로 표시하세요.
    // 이동할 수 있는지 체크, 도착했다(nc==C-1)
    // 이동할 수 있는 길이면 'c'나 'x'로 표시하세요.
    // 그리고 이동(dfs)
    // 실패하면 가는길이 전혀 없는 것이니
    // -> 백트랙킹 (원위치에서 한칸뒤로 이동후 시작)이 없다!!!!!
    // 갈수 있어도 return true, 도착해도 return true
    public static boolean dfs(int r, int c) {
        for (int d = 0; d < 3; d++) {
            int nr=r+dr[d];
            int nc=c+dc[d];//델타
            if(!check(nr,nc))continue;
            //도착
            if(nc==C-1){
                return true; // base condition
            }
            print();
            System.out.println("==============");
            // 실패 했을 경우 되돌아가지 않아도 된다. 어차피 상위 index 에서 못 찾았으면, 다음 것도 없다.
            map[nr][nc]='c'; //'x' 지나간 자리 표시
            if(dfs(nr,nc)) return true; // 계속 가보자
        }
        return false;
    }
    public  static boolean check(int r, int c) {
        return r>=0 && r<R && c>=0 && c<C && map[r][c]=='.';
    }

    static void print(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}





