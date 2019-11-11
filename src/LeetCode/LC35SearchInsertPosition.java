package LeetCode;

public class LC35SearchInsertPosition {
    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 3, 4, 5, 8};
        System.out.println(searchInsert(array, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        return nums.length > 0 ? searchHalf(nums, 0, nums.length - 1, target) : 0;
    }

    public static int searchHalf(int[] nums, int left, int right, int target) {
        if (left == right) {
            if (nums[left] == target) {
                return left;
            } else if (nums[left] > target) {
                return left;
            } else {
                return left + 1;
            }
        }
        int index = (left + right) / 2;
        if (target < nums[index]) {
            return searchHalf(nums, left, index, target);
        } else if (target > nums[index]) {
            return searchHalf(nums, index + 1, right, target);
        } else {
            return index;
        }

    }
}
