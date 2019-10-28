package LeetCode;

public class LC11ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

//    public static int maxArea(int[] height) {
//        int maxValue = Integer.MIN_VALUE;
//        for (int i = 0; i < height.length - 1; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int value = (j - i) * Math.min(height[i], height[j]);
//                if (value > maxValue) {
//                    maxValue = value;
//                }
//            }
//        }
//        return maxValue;
//    }

    public static int maxArea(int[] height) {
        int maxValue = Integer.MIN_VALUE;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int value = (j - i) * Math.min(height[i], height[j]);
            if (value > maxValue) {
                maxValue = value;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxValue;
    }
}
