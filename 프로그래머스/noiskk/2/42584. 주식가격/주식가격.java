import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>(); // index 저장
        
        int size = prices.length;
        int[] result = new int[size];
        
        stack.push(0);
        
        for(int i = 1; i < size; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int idx = stack.pop();
            result[idx] = size - idx - 1;
        }
        
        return result;
    }
}