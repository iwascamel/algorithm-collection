package 이론.이분탐색;

public class BinaryUpperLowerBound {
    static int N;
    static int[] arr;
    public static void main(String[] args) {
        arr = new int[]{2,3,3,3,3,4,5};
        N = arr.length;
        int target = 3;
        System.out.println(upperBound(target));
        System.out.println(lowerBound(target));
        // System.out.println(lowerBound(target));
    }

    public static int upperBound(int target){
        int start = 0;
        int end = N-1;
        while(start < end){
            int mid = (start+end)/2;
            if(arr[mid] > target){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return end;
    }
    public static int lowerBound(int target){
        int start = 0;
        int end = N-1;
        while(start < end){
            int mid = (start+end)/2;

            if(arr[mid] >= target){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return end;
    }
}
