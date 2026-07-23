import java.util.*;

class Solution {
    public int solution(int n) {
        
        int answer = n + 1;
        
        int target = getCount(n);
        
        while(target != getCount(answer)) answer++;
        
        return answer;
    }
    
    // 자연수 -> 이진수 변환 함수 (1 개수 출력)
    private int getCount(int n){
        
        int count = 0;
        
        while(n > 0){
            if(n % 2 == 1){
                count++;
            } 
            n /= 2;
        }
    
        return count;
    }
    
}