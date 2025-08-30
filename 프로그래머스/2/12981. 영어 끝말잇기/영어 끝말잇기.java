import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> st = new HashSet<>(); st.add(words[0]);
        int idx = -1;
        for(int i = 1; i < words.length; i++) {
            int lss = st.size(); st.add(words[i]);
            if (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) 
                || lss == st.size()) {
                idx = i; break;
            }
        }
        if (idx == -1) return new int[]{0, 0};
        return new int[]{(idx%n)+1, (idx/n)+1};
    }
}