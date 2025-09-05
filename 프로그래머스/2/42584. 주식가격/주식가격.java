import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            int time = 0;
            int price = prices[i];
            // 가격이 1인 경우 떨어지는 일이 없기에 현재 위치 값 바로 반환
            if (price == 1) {
                answer[i] = (prices.length-i)-1;
                continue;
            }
            // 가격이 2 이상인 경우 자신보다 낮은 값을 찾아 반환
            for(int j = i+1; j < prices.length; j++) {
                time++;
                if (price > prices[j]) {
                    answer[i] = time;
                    time = 0;
                    break;
                }
            }
            // 반환하지 못했다면 가격이 떨어지지 않았기에, 현재 위치 값을 반환
            if (time != 0) answer[i] = (prices.length-i)-1;
        }
        return answer;
    }
}