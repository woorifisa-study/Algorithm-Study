import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int length = prices.length;
        
        int[] answer = new int[length];
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        stack.push(0);
        for (int i = 1; i < length; i++) {            
            while (!stack.isEmpty() && (prices[stack.peek()] > prices[i])) {       
                int index = stack.pop();
                answer[index] = i - index;                
            }   
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = length - index - 1;
        }
        
        return answer;
    }
}