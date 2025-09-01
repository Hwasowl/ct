import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) { // 복습
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 3 2 2 1 순서.
        for(int p : priorities) pq.add(p);
        while(!(pq.size() == 0)) {
            // while안에 for문을 둠으로써 배열 크기를 초과하고, 초기로 돌아오는 로직을 수행.
            // for문 안에는 if i == location으로 비교해 인덱스 문제를 해결한다.
            for(int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) { // 우선순위와 같다면
                    answer++;
                    pq.poll();
                    if (i == location) return answer; // 우선순위가 같으면서 위치가 같다면 반환.
                }
            }
        }
        return answer;
    }
}