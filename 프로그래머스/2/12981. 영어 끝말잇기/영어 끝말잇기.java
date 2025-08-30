import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> st = new HashSet<>(); st.add(words[0]);
        int idx = -1;
        for(int i = 1; i < words.length; i++) {
            String prev = words[i-1].substring(words[i-1].length()-1);
            String curr = words[i].substring(0, 1);
            int lss = st.size();
            st.add(words[i]);
            if (!curr.equals(prev) || lss == st.size()) {
                idx = i; break;
            }
        }
        if (idx == -1) return new int[]{0, 0};
        return new int[]{(idx%n)+1, (idx/n)+1};
    }
}