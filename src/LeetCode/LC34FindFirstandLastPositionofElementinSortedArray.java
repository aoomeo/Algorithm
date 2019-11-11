package LeetCode;

/**
 * @author qianjun
 */
public class LC34FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {
        int[] array = new int[]{7};
        int[] result = searchRange(array, 7);
        System.out.print(result[0] + " 至 " + result[1]);
    }

    /**
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length > 0) {
            searchHalf(nums, 0, nums.length - 1, target, result);
        }
        return result;
    }

    private static void searchHalf(int[] nums, int left, int right, int target, int[] result) {
        if (left == right) {
            if (nums[left] == target) {
                if (result[0] == -1 || (result[0] > 0 && left < result[0])) {
                    result[0] = left;
                }
                if (right > result[1]) {
                    result[1] = right;
                }
            }
            return;
        }
        int index = (left + right) / 2;
        if (nums[index] == target) {
            if (result[0] == -1 || (result[0] > 0 && index < result[0])) {
                result[0] = index;
            }
            if (index > result[1]) {
                result[1] = index;
            }
            searchHalf(nums, left, index, target, result);
            searchHalf(nums, index + 1, right, target, result);
        } else if (nums[index] > target) {
            searchHalf(nums, left, index, target, result);
        } else if (nums[index] < target) {
            searchHalf(nums, index + 1, right, target, result);
        }
    }
}
