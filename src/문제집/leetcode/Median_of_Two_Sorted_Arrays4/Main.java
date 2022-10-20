package 문제집.leetcode.Median_of_Two_Sorted_Arrays4;

/*
link: https://leetcode.com/problems/median-of-two-sorted-arrays/
date: 22.10.20
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        double medianSortedArrays = solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(medianSortedArrays);
    }
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;

            int len3 = len1+len2;

            int[] nums3 = new int[len3];

            int p1=0,p2=0,p3 = 0;

            while(p3<len3){
                if(p1 == len1){
                    nums3[p3++] = nums2[p2++];
                    continue;
                }
                if(p2 == len2){
                    nums3[p3++] = nums1[p1++];
                    continue;
                }

                if(nums1[p1] <= nums2[p2]){
                    nums3[p3++] = nums1[p1++];
                }else{
                    nums3[p3++] = nums2[p2++];
                }
            }
            System.out.println(Arrays.toString(nums3));
            if(len3 % 2 == 0){
                return (double) (nums3[len3/2] + nums3[len3/2-1])/2;
            }else{
                return nums3[p3/2];
            }
        }
    }
}
