package LeetCode;

/**
 * @author qianjun
 */

public class LC33SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] array = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(array, 3));
    }

    /**
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 复杂度要求:O(log(n)) 二分
     **/
    private static int search(int[] nums, int target) {
        return nums.length >= 1 ? searchHalf(nums, 0, nums.length - 1, target) : -1;
    }

    private static int searchHalf(int[] nums, int start, int end, int target) {
        if (start == end) {
            return nums[start] == target ? start : -1;
        }
        int index = (start + end) / 2;
        // 顺序，进行查找
        if (nums[start] < nums[end]) {
            if (nums[index] > target) {
                return searchHalf(nums, start, index, target);
            } else if (nums[index] < target) {
                return searchHalf(nums, index + 1, end, target);
            } else {
                return index;
            }
        } else {
            int result1 = searchHalf(nums, start, index, target);
            if (result1 != -1) {
                return result1;
            }
            return searchHalf(nums, index + 1, end, target);
        }
    }

}
