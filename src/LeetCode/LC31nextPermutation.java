package LeetCode;

public class LC31nextPermutation {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2};
        nextPermutation(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ;");
        }
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        boolean flag = false;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                int j = i;
                for (; j < nums.length; j++) {
                    if (nums[j] <= nums[i - 1]) {
                        break;
                    }
                }
                int index = nums[i - 1];
                nums[i - 1] = nums[j - 1];
                nums[j - 1] = index;
                qsort(nums, i, nums.length - 1);
                flag = true;
                break;
            }
        }
        if (!flag) {
            qsort(nums, 0, nums.length - 1);
        }
    }

    public static int[] qsort(int arr[], int start, int end) {
        if (start >= arr.length) {
            return arr;
        }
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while ((i < j) && (arr[j] > pivot)) {
                j--;
            }
            while ((i < j) && (arr[i] < pivot)) {
                i++;
            }
            if ((arr[i] == arr[j]) && (i < j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start) arr = qsort(arr, start, i - 1);
        if (j + 1 < end) arr = qsort(arr, j + 1, end);
        return (arr);
    }
}
