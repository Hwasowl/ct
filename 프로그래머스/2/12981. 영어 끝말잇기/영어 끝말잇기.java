import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> li = new ArrayList<>();
        li.add(words[0]);
        int idx = -1;
        for(int i = 1; i < words.length; i++) {
            String prev = words[i-1].substring(words[i-1].length()-1);
            String curr = words[i].substring(0, 1);
            if (!curr.equals(prev) || li.contains(words[i])) {
                idx = i;
                break;
            }
            li.add(words[i]);
        }
        if (idx == -1) return new int[]{0, 0};
        return new int[]{(idx%n)+1, (idx/n)+1};
    }
}