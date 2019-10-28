package LeetCode;

public class LC14LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"c", "c", "c"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder result = new StringBuilder();

        for (int i = 0; ; ) {
            if (i < strs[0].length()) {
                char index = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length() || index != strs[j].charAt(i)) {
                        return result.toString();
                    }
                }
                result.append(index);
                i++;
            } else {
                break;
            }
        }
        return result.toString();
    }

}
