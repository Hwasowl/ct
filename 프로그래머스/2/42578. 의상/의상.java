import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> mp = new HashMap<>();
        int answer = 1; // 항등원
        
        for(String[] cloth : clothes) {
            // 옷 종류에 해당하면 +1씩 더함. 입지 않은 경우를 고려해 1로 시작.
            mp.put(cloth[1], mp.getOrDefault(cloth[1], 1) + 1);    
        }
        for(int i : mp.values()) answer *= i; // 경우의 수 계산
        
        return answer - 1;
    }
}