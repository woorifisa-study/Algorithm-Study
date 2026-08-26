import java.util.*;

class Solution {
    
    Set<Integer> numberSet;
    
    public int solution(String numbers) {
        
        int n = numbers.length();
               
        numberSet = new HashSet<>();
        boolean[] visited = new boolean[n];
        
        dfs("", numbers, visited);
        
        int answer = 0;
        for (int num : numberSet) {
            if (isPrime(num)) answer++;
        }
        
        return answer;        
    }
    
    public void dfs (String cur, String numbers, boolean[] visited) {
        
        if (!cur.isEmpty()) numberSet.add(Integer.parseInt(cur));
        
        for (int i = 0; i < numbers.length(); i++) {
            
            if (!visited[i]) {
                visited[i] = true;
                dfs(cur + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int num) {
        
        if (num < 2) return false;
        
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}