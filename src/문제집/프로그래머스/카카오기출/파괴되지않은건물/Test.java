package 문제집.프로그래머스.카카오기출.파괴되지않은건물;

public class Test {
    static int[][] arr;
    public static void main(String[] args) {
        arr = new int[4][4];

        arr[0][0] = 3;
        arr[0][3] = -3;
        arr[3][0] = -3;
        arr[3][3] = 3;

        print();

        for(int i=0;i<4;i++){
            for(int j=1;j<4;j++){
                arr[i][j] += arr[i][j-1];
            }
        }

        System.out.println("---------------");
        print();
        System.out.println("---------------");

        for(int j=0;j<4;j++){
            for(int i=1;i<4;i++){
                arr[i][j] += arr[i-1][j];
            }
        }

        print();
    }

    private static void print() {
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
