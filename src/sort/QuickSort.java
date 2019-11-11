package sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] result = quickSort(array, 0, array.length - 1);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static int[] quickSort(int[] nums, int start, int end) {
        System.out.println("quickSort -> " + start + " " + end);

        for (int i = 0; i < 11; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println(" ");
        System.out.println(" ");

        int base = nums[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && nums[j] > base) {
                j--;
            }
            while (i < j && nums[i] < base) {
                i++;
            }
            if (nums[i] == nums[j] && i < j) {
                i++;
            } else {
                int index = nums[i];
                nums[i] = nums[j];
                nums[j] = index;
            }
        }
        if (i - 1 > start) nums = quickSort(nums, start, i - 1);
        if (j + 1 < end) nums = quickSort(nums, j + 1, end);
        return nums;
    }
}
