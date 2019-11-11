package LeetCode;

public class LC27RemoveElement {
    public static void main(String[] args) {
        int[] a = new int[]{3 ,2,2, 3};
        int result = removeElement(a, 3);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.print(a[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        for (; i <= j; ) {
            if (nums[i] != val) {
                i++;
                continue;
            }
            if (nums[j] == val) {
                j--;
                continue;
            }
            if (nums[i] == val && nums[j] != val) {
                nums[i] = nums[j];
                nums[j] = val;
                i++;
                j--;
                continue;
            }
            if (i == j) {
                return nums[i] == val ? i - 1 : i;
            }
        }
        return i;
    }

}
