import java.util.*;

class Solution {
    static boolean[] isVisited;
    static int answer=0;
    static Set<Integer> set;
    
    public int solution(String numbers) {
        set = new HashSet<>();
        isVisited = new boolean[numbers.length()];
        
        DFS(numbers, "");
        
        for(int num: set){
            if(isPrime(num)) 
                answer++;
        }
        
        return answer;
    }
    
    public static void DFS(String numbers, String current) {
        if(!current.equals("")){
            set.add(Integer.parseInt(current));
        }
        
        for(int i=0; i<numbers.length(); i++) {
            
            if(!isVisited[i]) {
                isVisited[i] = true;
                DFS(numbers, current + numbers.charAt(i));
                isVisited[i] = false;
            }
        }
    }
    
    public static boolean isPrime(int num) {
        if(num < 2) return false;
        
        for(int i=2; i*i <= num; i++) {
            if(num% i == 0)
                return false;
        }
        return true;
    }
}