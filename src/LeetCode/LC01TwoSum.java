package LeetCode;

import java.util.HashMap;

public class LC01TwoSum {

    public static void main(String[] args) {
        int[] testNumbers = new int[100003];
        for (int i = 0; i < 100001; i++) {
            testNumbers[i] = 100000;
        }
        testNumbers[100001] = 2;
        testNumbers[100002] = 4;

        int target = 6;

        // todo test the same number output
        // int[] testNumbers = new int[]{3, 3, 3, 3};

        testTwoSumForce(testNumbers, target);

        testTwoSumTwoHash(testNumbers, target);

        testTwoSumOneHash(testNumbers, target);
    }

    /**
     * Solution One - Force
     * Time complexity : O(n * n)
     **/
    private static int[] twoSumForce(int[] numbers, int target) {
        int i, j;
        for (i = 0; i < numbers.length - 1; i++) {
            for (j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == target - numbers[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no result");
    }

    private static void testTwoSumForce(int[] numbers, int target) {
        long time = System.currentTimeMillis();
        int[] result = twoSumForce(numbers, target);
        System.out.println("Force Hash Time Used: " + (System.currentTimeMillis() - time) + "ms; result :" + result[0] + " " + result[1]);
        System.out.println();
    }

    /**
     * Solution Two - Two Hash
     * Time complexity : O(n + n) --> O(n)
     **/
    private static int[] twoSumTwoHash(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            int number = target - numbers[i];
            if (map.containsKey(number) && map.get(number) != i) {
                return new int[]{i, map.get(target - numbers[i])};
            }
        }
        throw new IllegalArgumentException("no result");
    }

    private static void testTwoSumTwoHash(int[] numbers, int target) {
        long time = System.currentTimeMillis();
        int[] result = twoSumTwoHash(numbers, target);
        System.out.println("Two Hash Time Used: " + (System.currentTimeMillis() - time) + "ms; result :" + result[0] + " " + result[1]);
        System.out.println();
    }

    /**
     * Solution Three - One Hash
     * Time complexity : O(n)
     **/
    private static int[] twoSumOneHash(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int number = target - numbers[i];
            if (map.containsKey(number)) {
                return new int[]{map.get(number), i};
            }
            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException("no result");
    }

    private static void testTwoSumOneHash(int[] numbers, int target) {
        long time = System.currentTimeMillis();
        int[] result = twoSumOneHash(numbers, target);
        System.out.println("One Hash Time Used: " + (System.currentTimeMillis() - time) + "ms; result :" + result[0] + " " + result[1]);
        System.out.println();
    }

}
