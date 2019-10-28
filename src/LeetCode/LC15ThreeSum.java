package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15ThreeSum {
    public static void main(String[] args) {
        threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (nums.length >= 3) {
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (j != i + 1 && k != nums.length - 1) {
                        if (nums[j] == nums[j - 1] && nums[k] == nums[k + 1]) {
                            j++;
                            k--;
                            continue;
                        }
                    }
                    int indexResult = nums[i] + nums[j] + nums[k];
                    if (indexResult == 0) {
                        ArrayList<Integer> index = new ArrayList<>(3);
                        index.add(nums[i]);
                        index.add(nums[j]);
                        index.add(-(nums[i] + nums[j]));
                        result.add(index);
                        j++;
                        k--;
                    } else if (indexResult > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }

}
