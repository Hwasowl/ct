import java.util.*;

class Solution {
    public int solution(String s) {
        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < cs.length; i++) {
            if (!stack.isEmpty() && stack.peek() == cs[i]) {
                stack.pop();
            } else {
                stack.push(cs[i]);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}