package LeetCode;

public class LC09IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1002001));
    }

//    public static boolean isPalindrome(int x) {
//        if (x < 0) { //增加负数为否的判定
//            return false;
//        }
//        int m = 0, n = 0;
//        String a = String.valueOf(x);
//        int size = a.length();
//        if (size >= 4) {
//            m = size / 2 - 1;
//            n = size % 2 == 1 ? size / 2 + 1 : size / 2;
//        }
//        if (m != 0 && n != 0) {
//            for (int i = 0, j = size - 1; i <= m && j >= n; i++, j--, m--, n++) {
//                if (a.charAt(i) != a.charAt(j) || a.charAt(m) != a.charAt(n)) {
//                    return false;
//                }
//            }
//        } else {
//            for (int i = 0, j = size - 1; i <= j; i++, j--) {
//                if (a.charAt(i) != a.charAt(j)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    public static boolean isPalindrome(int x) {
        //边界判断
        if (x < 0) return false;
        int div = 1;
        //
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

}
