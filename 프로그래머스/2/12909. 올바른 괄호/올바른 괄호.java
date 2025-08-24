import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String value = s.substring(i, i+1);
            if (value.equals("(")) {
                stack.push(value);
            } else {
                if (stack.empty()) stack.push(value);
                if (stack.peek().equals("(")) stack.pop();
            }
        }
        return stack.empty();
    }
}