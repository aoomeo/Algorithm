package LeetCode;


public class LC08 {
    public static void main(String[] args) {
        System.out.println(myAtoi("9223372036854775808"));
    }

    public static int myAtoi(String str) {
        long result = 0;
        int flag = 1;
        boolean isClear = false;
        for (int j = 0; j < str.length(); j++) {
            char indexChar = str.charAt(j);
            if (indexChar == ' ') {
                if (!isClear) {
                    continue;
                } else {
                    break;
                }
            }
            if (!isClear) {
                if (indexChar == 45) {
                    flag = -1;
                    isClear = true;
                    continue;
                } else if (indexChar == 43) {
                    isClear = true;
                    continue;
                }
            }
            if (indexChar < 48 || indexChar > 57) {
                break;
            } else {
                result = result * 10 + Integer.parseInt(String.valueOf(indexChar));
                if (result > ((long) Integer.MAX_VALUE + 1) || result < Integer.MIN_VALUE) {
                    break;
                }
            }
            isClear = true;
        }
        result = result * flag;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }
}
