import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] days = new int[progresses.length];

        // 각 작업의 완료 일수 계산
        for (int i = 0; i < progresses.length; i++) {
            days[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        // 배포 그룹핑
        int maxDay = days[0];
        int count = 1;

        for (int i = 1; i < days.length; i++) {
            if (days[i] <= maxDay) {
                count++;
            } else {
                answer.add(count);
                maxDay = days[i];
                count = 1;
            }
        }
        answer.add(count);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}