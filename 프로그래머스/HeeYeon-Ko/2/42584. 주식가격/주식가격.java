import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < prices.length; i++){
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            
            int index = stack.pop();
            int msec = 0;
            for(int i = index+1; i < prices.length; i++){
                if(prices[index] <= prices[i]){
                    msec++;
                }
                else if(prices[index] > prices[i]){
                    msec++;
                    break;
                }
               
            }
            answer[index] = msec;
        }
        
        return answer;
    }
}