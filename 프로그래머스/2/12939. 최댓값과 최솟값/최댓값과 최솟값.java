import java.util.*;

class Solution {
    public String solution(String s) {
        char[] c = s.toCharArray();
        List<Integer> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            if (c[i] !=  ' ') {
                sb.append(c[i]);
                if (i+1 == c.length) arr.add(Integer.parseInt(sb.toString()));
            } 
            else {
                arr.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
        }       
        Collections.sort(arr);
        return arr.get(0) + " " + arr.get(arr.size()-1);
    }
}