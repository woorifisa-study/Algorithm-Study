import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        
        boolean[] visited = new boolean[numbers.length()];
        
        for(int i = 1; i <= numbers.length(); i++){
            permutation("", numbers, visited, i);
        }
        
        int answer = 0;
        
        for(int num : set){
            if(isPrime(num)){
                answer++;
            }
        }
        
        return answer;
    }
    
    void permutation(String current, String numbers, boolean[] visited, int length){
        
        if(current.length() == length){
            set.add(Integer.parseInt(current));
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                permutation(current + numbers.charAt(i), numbers, visited, length);
                visited[i] = false;
            }
        }
        
    }
    
    
    boolean isPrime(int num){
        if(num < 2) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        
        for(int i = 3; i * i <= num; i += 2){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}