import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < bridge_length; i++){
            queue.add(0);
        }
        
        int sum_weight = 0; // 다리에 있는 트럭 총 무게
        int truckCount = 0; // 다리에 있는 트럭 개수
        
        for(int w : truck_weights){
            // 바로 못 올라가는 경우
            if(w + sum_weight > weight || truckCount >= bridge_length){
                while(true){
                    if(queue.peek() > 0){
                        truckCount--;
                    }
                    sum_weight -= queue.poll();
                    time++;
                    
                    if(w + sum_weight <= weight && truckCount < bridge_length){
                        break;
                    }
                    
                    queue.add(0);
                }
            }
            // 바로 올라갈 수 있는 경우
            else{
                if(queue.peek() > 0){
                    truckCount--;
                }
                sum_weight -= queue.poll();
                time++;
            }
            
            queue.add(w);
            sum_weight += w;
            truckCount++;
            
        }
          
        return time + bridge_length;
    }
}