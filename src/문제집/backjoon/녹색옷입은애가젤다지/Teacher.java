package 문제집.backjoon.녹색옷입은애가젤다지;

import java.util.Arrays;
import java.util.Scanner;

public class Teacher {

	static int N;
	static int [][] map;
	static int [][] cost;
	static int [] dr={-1,0,1,0};
	static int [] dc={0,1,0,-1};
	
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		int cnt=1;
		while(true){
			N=scann.nextInt();
			if(N==0){ break; }
			map=new int[N][N];
			cost=new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(cost[i], Integer.MAX_VALUE/1000);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=scann.nextInt();
				}
			}
			int result=bfs();
			System.out.println("Problem "+(cnt++)+": "+result);
		}

	}

	private static int bfs() {
		
		return 0;
	}

}
