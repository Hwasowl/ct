import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0; int right = people.length-1;
        
        while(left <= right) {
            if (people[left] + people[right] <= limit) left++;
            right--;
            answer++;
        }
        
        // 50 50 70 80
        // 50 80 X 보트+1 right-- (0, 2)
        // 50 70 X 보트+1 right-- (0, 1)
        // 50 50 O 보트+1 left-- right-- (1, 0)
        
        // 리밋240
        // 80 90 120 120 120
        // 80 120 O 보트+1 left++ right-- (1, 3)
        // 90 120 O 보트+1 left++ righ-- (2, 2)
        // 120 보트+1 right-- (2, 1)
        
        return answer;
    }
}