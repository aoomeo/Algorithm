package LeetCode;

import java.util.HashSet;

public class LC03 {

    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("abcsssa");
        System.out.println(result);

    }

    public static int lengthOfLongestSubstring(String s) {
        int count = 0;
        HashSet<Character> hashSet = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()) {
            if (!hashSet.contains(s.charAt(i))) {
                hashSet.add(s.charAt(i++));
                count = Math.max(count, i - j);
            } else {
                hashSet.remove(s.charAt(j++));
            }
        }
        return count;
    }
}
