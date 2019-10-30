package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18FourSum {
    public static void main(String[] args) {
        List<List<Integer>> result = fourSum(new int[]{-1, 0, -5, -2, -2, -4, 0, 1, -2}, -9);
        System.out.println(result.size());
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); //快排 O(log(n))
        if (nums.length < 4) {
            return result;
        }
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int m = nums.length - 1;
                int fixedSum = nums[i] + nums[j];
                while (k < m) {
                    if (k != j + 1 && nums[k] == nums[k - 1] && m != nums.length - 1 && nums[m] == nums[m + 1]) {
                        k++;
                        m--;
                        continue;
                    }
                    if (fixedSum + nums[k] > target && nums[k] >= 0) { //三数相加大于 即直接break while循环
                        break;
                    }
                    if (fixedSum + nums[k] + nums[m] == target) {
                        List<Integer> index = new ArrayList<>();
                        index.add(nums[i]);
                        index.add(nums[j]);
                        index.add(nums[k]);
                        index.add(nums[m]);
                        result.add(index);
                        k++;
                        m--;
                    } else if (fixedSum + nums[k] + nums[m] > target) {
                        m--;
                    } else if (fixedSum + nums[k] + nums[m] < target) {
                        k++;
                    }
                }
            }
        }
        return result;
    }
}
