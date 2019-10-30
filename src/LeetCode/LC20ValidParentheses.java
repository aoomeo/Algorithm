package LeetCode;

import java.util.Stack;

public class LC20ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stacks = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char index = s.charAt(i);
            if (index == '(' || index == '{' || index == '[') {
                stacks.push(index);
            } else {
                if (stacks.isEmpty()) {
                    return false;
                }
                char popChar = stacks.pop();
                if (index == ')' && popChar == '(') {
                    continue;
                } else if (index == '}' && popChar == '{') {
                    continue;
                } else if (index == ']' && popChar == '[') {
                    continue;
                }
                return false;
            }
        }
        return stacks.isEmpty();
    }
}
