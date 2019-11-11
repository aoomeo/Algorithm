package LeetCode;

import java.util.HashMap;
import java.util.Stack;

public class LC32LongestValidParentheses {

    public static void main(String[] args) {
        System.out.print(longestValidParentheses("()"));
    }

    public static class CharInt {
        public CharInt(char aChar, int index) {
            this.aChar = aChar;
            this.index = index;
        }

        public char aChar;
        public int index;

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof CharInt) {
                return aChar == ((CharInt) obj).aChar;
            } else if (obj instanceof Character) {
                return aChar == (Character) obj;
            }
            return super.equals(obj);
        }
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        Stack<CharInt> stringStack = new Stack<>();
        HashMap<Integer, Integer> parenthesesCounts = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char index = s.charAt(i);
            if (index == '(') {
                stringStack.push(new CharInt('(', i));
                parenthesesCounts.put(i, count);
                continue;
            }
            if (index == ')') {
                if (!stringStack.isEmpty()) {
                    CharInt c = stringStack.peek();
                    if (c.equals('(')) {
                        count += 2;
                        stringStack.pop();
                        continue;
                    }
                }
                stringStack.push(new CharInt(')', i));
                parenthesesCounts.put(i, count);
            }
        }
        int max = Integer.MIN_VALUE;
        int j = Integer.MAX_VALUE;
        if (stringStack.isEmpty()) return count;
        while (!stringStack.isEmpty()) {
            int i = stringStack.pop().index;
            max = j == Integer.MAX_VALUE ? Math.max(count - parenthesesCounts.get(i), max) : Math.max(parenthesesCounts.get(j) - parenthesesCounts.get(i), max);
            j = i;
        }
        max = Math.max(max, parenthesesCounts.get(j));
        return max;
    }

}
