package LeetCode;

import java.util.Arrays;

public class LC16ThreeSumClosest {
    public static void main(String[] args) {
        int[] a = new int[]{1, 1, -1, -1, 3};
        int target = -1;
        System.out.println(threeSumClosest(a, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int a = i + 1, b = nums.length - 1;
            while (a < b) {
                int sum = nums[i] + nums[a] + nums[b];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum - target > 0) {
                    b--;
                } else if (sum - target < 0) {
                    a++;
                } else { //注意 当和与target相同时，直接返回 sum 即可。
                    return sum;
                }
            }
        }
        return result;
    }


    //
//            for (int j = i + 1, k = nums.length - 1; j < k; ) {
//                int index = nums[i] + nums[j] + nums[k];
//                if (result == Integer.MIN_VALUE) {
//                    result = index;
//                } else if (Math.abs(index - target) < Math.abs(result - target)) {
//                    result = index;
//                }
//                if (index - target > 0) {
//                    k--;
//                } else {
//                    j++;
//                }
//            }

}
