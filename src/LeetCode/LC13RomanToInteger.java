package LeetCode;

public class LC13RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int result = 0;
        while (s.length() > 0) {
            int count = 0;
            switch (s.charAt(0)) {
                case 'M':
                    result += 1000;
                    count = 1;
                    break;
                case 'D':
                    result += 500;
                    count = 1;
                    break;
                case 'L':
                    result += 50;
                    count = 1;
                    break;
                case 'V':
                    result += 5;
                    count = 1;
                    break;
                case 'C':
                    if (s.length() > 1 && s.charAt(1) == 'M') {
                        result += 900;
                        count = 2;
                        break;
                    } else if (s.length() > 1 && s.charAt(1) == 'D') {
                        result += 400;
                        count = 2;
                    } else {
                        result += 100;
                        count = 1;
                    }
                    break;
                case 'X':
                    if (s.length() > 1 && s.charAt(1) == 'C') {
                        result += 90;
                        count = 2;
                    } else if (s.length() > 1 && s.charAt(1) == 'L') {
                        result += 40;
                        count = 2;
                    } else {
                        result += 10;
                        count = 1;
                    }
                    break;
                case 'I':
                    if (s.length() > 1 && s.charAt(1) == 'X') {
                        result += 9;
                        count = 2;
                    } else if (s.length() > 1 && s.charAt(1) == 'V') {
                        result += 4;
                        count = 2;
                    } else {
                        result += 1;
                        count = 1;
                    }
                    break;
            }
            s = s.substring(count);
        }

        return result;
    }
}
