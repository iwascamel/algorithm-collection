package 문제집.backjoon.도로와신호등;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * date : 22.03.01
 */

public class Main {
    static class Light{
        int location;
        int red;
        int green;

        public Light(int location, int red, int green) {
            this.location = location;
            this.red = red;
            this.green = green;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/도로와신호등/input.txt"));

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();

        int cnt = 0;
        int userLocation = 0;
        Light[] lights = new Light[N];

        for(int i=0;i<N;i++){
            int loc = sc.nextInt();
            int red = sc.nextInt();
            int green = sc.nextInt();

            lights[i] = new Light(loc,red,green);
        }
        int pointer = 0 ;
        while(userLocation<L){
            if(pointer < N && userLocation == lights[pointer].location){
                int cur = userLocation % (lights[pointer].red + lights[pointer].green);
                while(cur < lights[pointer].red){
                    cur++;
                    cnt++;
                }
                pointer++;
            }
            userLocation++;
            cnt++;
        }
        System.out.println(cnt-1);
    }
}
