package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC22GenerateParentheses {


    public static void main(String[] args) {
        List<String> a = generateParenthesis(0);
        System.out.println(a.size());
    }


    private static List<String> result = new LinkedList<>();

    public static List<String> generateParenthesis(int n) {
        result.clear();
        Stack<Character> chars = new Stack<>();
        doJob("", chars, n);
        return result;
    }

    public static void doJob(String data, Stack<Character> chars, int n) {
        Stack<Character> index = chars;
        if (n == 0) {
            if (!index.isEmpty()) {
                String indexData = data;
                while (!index.isEmpty()) {
                    index.pop();
                    indexData = indexData + ")";
                }
                result.add(indexData);
            }
        } else {
            if (!index.isEmpty()) {
                Stack<Character> indexStack = (Stack<Character>) chars.clone();
                indexStack.pop();
                doJob(data + ")", indexStack, n); // 情况1
            }
            index.push('(');
            doJob(data + "(", index, n - 1); // 情况2
        }
    }
}
