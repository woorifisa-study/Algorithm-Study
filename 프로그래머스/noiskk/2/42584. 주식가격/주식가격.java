import java.util.*;

class Solution {
    
    class Stock{
        int price;
        int time;
        
        public Stock(int price, int time){
            this.price = price;
            this.time = time;
        }
    }
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Deque<Stock> stack = new ArrayDeque<>();
        
        for(int time = 0; time < prices.length; time++){
            
            if(stack.isEmpty()){
                stack.push(new Stock(prices[time], time));
                continue;
            }
            
            while(!stack.isEmpty() && prices[time] < stack.peek().price){
                Stock s = stack.poll();
                answer[s.time] = time - s.time;
            }
            
            stack.push(new Stock(prices[time], time));
        }
        
        while(!stack.isEmpty()){
            Stock s = stack.poll();
            answer[s.time] = prices.length - s.time - 1;
        }
        
        return answer;
    }
}