package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC17LetterCombinations {
    public static void main(String[] args) {
        letterCombinations("234");
        System.out.println(result.size());
    }

    public static String[] maps = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> result;

    public static List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        findString(0, digits, "");
        return result;
    }

    public static void findString(int index, String digits, String str) {
        if (index == digits.length()) {
            result.add(str);
            return;
        }
        int num = Integer.parseInt(String.valueOf(digits.charAt(index)));
        String values = maps[num];
        for (int i = 0; i < values.length(); i++) {
            findString(index + 1, digits, str + values.charAt(i));
        }
    }

}
