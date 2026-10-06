import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        
        visited = new boolean[numbers.length()];
        dfs("", numbers);
        
        for(int n : set){
            if(isPrime(n)) answer++;
        }
        
        return answer;
    }
    
    void dfs(String cur, String numbers){
        if(!cur.isEmpty()){
            set.add(Integer.parseInt(cur));
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(cur + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }
    
    
    
    boolean isPrime(int n){
        if(n < 2) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        
        for(int i = 3; i * i <= n; i += 2){
            if(n % i == 0) return false;
        }
            
        return true;
    }
}