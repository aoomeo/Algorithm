package LeetCode;

public class LC04 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 5};
        int[] nums2 = new int[]{2, 4, 6};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2] + nums2[n / 2 - 1]) / 2.0;
            }
            return nums2[n / 2] * 1.0;
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2] + nums1[m / 2 - 1]) / 2.0;
            }
            return nums1[m / 2] * 1.0;
        }
        int total = n + m;
        if (total % 2 != 0) {
            return findMedian(nums1, 0, nums2, 0, total / 2 + 1);
        }
        return (findMedian(nums1, 0, nums2, 0, total / 2) + findMedian(nums1, 0, nums2, 0, total / 2 + 1)) / 2.0;
    }

    public static double findMedian(int[] nums1, int a_begin, int[] nums2, int b_begin, int k) {
        if (a_begin >= nums1.length) {
            return nums2[b_begin + k - 1];
        }
        if (b_begin >= nums2.length) {
            return nums1[a_begin + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[a_begin], nums2[b_begin]);
        }
        int mid_a = Integer.MAX_VALUE;
        int mid_b = Integer.MAX_VALUE;

        if (a_begin + k / 2 - 1 < nums1.length) {
            mid_a = nums1[a_begin + k / 2 - 1];
        }

        if (b_begin + k / 2 - 1 < nums2.length)
            mid_b = nums2[b_begin + k / 2 - 1];
        if (mid_a < mid_b) {
            // nums1的后半段 和 nums2的前半段
            return findMedian(nums1, a_begin + k / 2, nums2, b_begin, k - k / 2);
        }
        return findMedian(nums1, a_begin, nums2, b_begin + k / 2, k - k / 2);
    }


}
