package 이론;

public class BinaryUpperLowerBound {
    static int N;
    static int[] arr;
    public static void main(String[] args) {
        arr = new int[]{2,3,3,3,3,4,5};
        N = arr.length;
        int target = 3;
        System.out.println(upperBinary(target));
        // System.out.println(lowerBinary(target));
    }

    public static int upperBinary(int target){
        int start = 0;
        int end = N-1;
        int ans = 0;
        while(start < end){
            int mid = (start+end)/2;

            if(arr[mid] >= target){
                start = mid+1;
                start = ans;
            }else{
                end = mid;
            }
        }
        return ans;
    }
    public static int lowerBinary(int target){
        int start = 0;
        int end = N-1;
        int ans = 0;
        while(start < end){
            int mid = (start+end)/2;

            if(arr[mid] >= target){
                end = mid;
            }else{
                start = mid+1;
                start = ans;
            }
        }
        return ans;
    }
}
