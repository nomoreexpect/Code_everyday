/**
 * @Author:PanYa
 * @Date 2024/5/10-上午11:15
 * @Description:
 */

import java.util.Arrays;

public class Merge_Array {
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = 0; i != n; ++i) {
                nums1[m + i] = nums2[i];
            }
            Arrays.sort(nums1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;

        System.out.println("Original nums1: " + Arrays.toString(nums1));
        solution.merge(nums1, m, nums2, n);
        System.out.println("Merged nums1: " + Arrays.toString(nums1));
    }
}
