import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> trucks = new LinkedList<>();
        for(int tw : truck_weights) trucks.add(tw);
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++) {
            bridge.add(0); // 다리 만큼 큐를 만들어 길이 재현
        }
        int time = 0;
        int sum = 0;
        while(!trucks.isEmpty() || sum > 0) {
            time++;
            int exitTruck = bridge.poll();
            sum -= exitTruck;
            if (!trucks.isEmpty() && sum + trucks.peek() <= weight) {
                int newTruck = trucks.poll();
                bridge.add(newTruck);
                sum += newTruck; 
            } else {
                bridge.add(0);
            }
        }
        return time;
    }
}