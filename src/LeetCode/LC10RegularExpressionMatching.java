package LeetCode;

import java.text.ParseException;

public class LC10RegularExpressionMatching {
    public static boolean result = false;

    public static void main(String[] args) throws ParseException {
        System.out.println((isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*a*a*b")));
    }

    public static boolean isMatch(String s, String p) {
        result = false;
        solution(s, p, s.length() - 1, p.length() - 1);
        return result;
    }

    public static void solution(String s, String p, int i, int j) {
        if (i == -1) {
            if (j == -1) {
                result = true;
                return;
            } else {
                if (p.charAt(j) == '*') {
                    solution(s, p, i, j - 2);
                }
                return;
            }
        }

        if (j == -1) {
            return;
        }

        if (p.charAt(j) == '*') {
            if (p.charAt(j - 1) == '.') {
                if (!result) solution(s, p, i, j - 2);
                if (!result) solution(s, p, i - 1, j);
                if (!result) solution(s, p, i - 1, j - 2);

            } else {
                if (s.charAt(i) == p.charAt(j - 1)) {
                    if (!result)
                        solution(s, p, i - 1, j - 2);
                    if (!result)
                        solution(s, p, i - 1, j);
                    if (!result)
                        solution(s, p, i, j - 2);
                } else {
                    solution(s, p, i, j - 2);
                }
            }
        } else if (p.charAt(j) == '.') {
            solution(s, p, i - 1, j - 1);
        } else {
            if (p.charAt(j) == s.charAt(i)) {
                solution(s, p, i - 1, j - 1);
            }
        }
    }

}
