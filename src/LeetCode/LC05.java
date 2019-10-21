package LeetCode;

public class LC05 {
    public static void main(String[] args) {

        System.out.println(longestPalindrome("123aba322"));
    }

    //动态规划
    //a[i][j] = a[i+1][j-1] && s[i] == s[j] （注 数组越界的问题）
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] a = new boolean[n][n];
        String res = "";

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j <= n - 1; j++) {
                a[i][j] = s.charAt(i) == s.charAt(j) && (j == i || a[i + 1][j - 1]);
                if (a[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        return res;
    }

    //    public static String longestPalindrome(String s) {
//        int n = s.length();
//        String res = "";
//        boolean[][] dp = new boolean[n][n];
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = i; j < n; j++) {
//                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]); //j - i 代表长度减去 1
//                if (dp[i][j] && j - i + 1 > res.length()) {
//                    res = s.substring(i, j + 1);
//                }
//            }
//        }
//        return res;
//    }

}
