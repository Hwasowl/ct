import java.util.*;

class Solution {
    
    public int countZero(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (String.valueOf(c).equals("0")) count++;
        }
        return count;
    }
    
    public int[] solution(String s) {
        int loop = 0;
        int removed = 0;
        while(!s.equals("1")) {
            int zeros = countZero(s);
            loop ++;
            removed += zeros;
            
            int ones = s.length() - zeros;
            s = Integer.toString(ones, 2);
        }
            
        return new int[]{loop, removed};
    }
}