import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {   
        Arrays.sort(tangerine);
        Set<Integer> set = new LinkedHashSet<>();
        for(int t : tangerine) set.add(t);
        List<Integer> li = new ArrayList<>(set);
        int prevIdx = 0;
        
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < li.size(); i++) {
            int cnt = 0;
            int result = li.get(i);
            for(int j = prevIdx; j < tangerine.length; j++) {
                if (result == tangerine[j]) cnt++;
                else {
                    prevIdx = j;
                    break;
                };
            }
            counts.add(cnt);
       }
        
        Collections.sort(counts, Collections.reverseOrder());

        int sum = 0;
        int answer = 0;
        for(Integer c : counts) {
            answer++;
            sum+=c;
            if(sum >= k) break;
        }

        return answer;
    }
}