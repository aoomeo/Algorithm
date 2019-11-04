package LeetCode;

import java.util.Arrays;

public class LC26RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(removeDuplicates(a));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = nums[0];
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (index != nums[i]) {
                index = nums[i];
                nums[j++] = index;
            }
        }
        nums = Arrays.copyOf(nums, j);
        return j;
    }
}
