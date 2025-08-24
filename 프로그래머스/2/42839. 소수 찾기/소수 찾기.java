import java.util.*;

class Solution {
    Set<Integer> resultSet = new HashSet<>();

    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        dfs(numbers, "", visited);
        int count = 0;
        for (int num : resultSet) {
            if (isPrime(num)) count++;
        }
        return count;
    }

    void dfs(String numbers, String current, boolean[] visited) {
        if (!current.isEmpty()) {
            resultSet.add(Integer.parseInt(current));
        }
     
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, current + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }

    boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}