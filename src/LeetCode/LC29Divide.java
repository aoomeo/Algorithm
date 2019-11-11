package LeetCode;

public class LC29Divide {

    public static void main(String[] args) {
        System.out.println(divide(Integer.MIN_VALUE, -1));
    }

    public static int divide(int dividend, int divisor) {
        boolean flag = ((dividend < 0) && (divisor > 0)) || ((dividend > 0) && (divisor < 0));
        if (dividend > 0) {
            dividend = Integer.parseInt("-" + dividend);
        }
        if (divisor > 0) {
            divisor = Integer.parseInt("-" + divisor);
        }
        int nowDivisor = divisor;
        int base = 1;
        int result = 0;
        while (dividend <= divisor) {
            if (dividend <= nowDivisor && (base < (Integer.MAX_VALUE >> 2))) {
                dividend = dividend - nowDivisor;
                result -= base;
                base = base << 1;
                nowDivisor = nowDivisor << 1;
            } else {
                base = base >> 1;
                nowDivisor = nowDivisor >> 1;
            }
        }
        if (!flag && result == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return flag ? result : Math.abs(result);
    }
}
