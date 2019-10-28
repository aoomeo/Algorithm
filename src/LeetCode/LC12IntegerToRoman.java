package LeetCode;

public class LC12IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    //贪心解法
    public static String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        while (num >= 0 && i < nums.length) {
            if (num >= nums[i]) {
                stringBuilder.append(strs[i]);
                num -= nums[i];
            } else {
                i++;
            }
        }
        return stringBuilder.toString();
    }
}
