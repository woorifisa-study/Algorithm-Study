import java.util.*;

class Solution {
    
    class Truck{
        int weight;
        int move;
        
        public Truck(int weight){
            this.weight = weight;
            this.move = 1;
        }
        
        public void moving(){
            move++;
        }
    }
    
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Deque<Truck> waitQ = new ArrayDeque<>();
        Deque<Truck> moveQ = new ArrayDeque<>();
        
        for(int t : truck_weights){
            waitQ.offer(new Truck(t));
        }
        
        int time = 0;
        int curWeight = 0;
        
        while(!waitQ.isEmpty() || !moveQ.isEmpty()){
            
            time++;
            
            if(moveQ.isEmpty()){
                Truck t = waitQ.poll();
                moveQ.offer(t);
                curWeight += t.weight;
                continue;
            }
            
            for(Truck t : moveQ){
                t.moving();
            }
            
            if(moveQ.peek().move > bridge_length){
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }
            
            if(!waitQ.isEmpty() && waitQ.peek().weight + curWeight <= weight){
                Truck t = waitQ.poll();
                moveQ.offer(t);
                curWeight += t.weight;
            }
        }
        
        return time;
    }
}