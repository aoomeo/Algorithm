package LeetCode;

public class LC28ImplementStrStr {
    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
    }

//    public static int strStr(String haystack, String needle) {
//        if (needle == null || needle.equals("")) {
//            return 0;
//        }
//        return haystack.indexOf(needle);
//    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        int result = -1;
        int i = 0;
        int j = 0;
        char[] hays = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        for (; i < hays.length && j < needles.length; ) {
            if (hays[i] == needles[j]) {
                if (j == 0) result = i;
                i++;
                j++;
            } else {
                j = 0;
                if (result != -1) {
                    i = result + 1;
                    result = -1;
                } else {
                    i++;
                }
            }
        }
        return j == needle.length() ? result : -1;
    }
}
