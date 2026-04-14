import java.util.*;

class Truck{
    int weight; // 트럭 무게
    int time; // 다리 통과하는 시점
    
    public Truck(int weight, int time){
        this.weight = weight;
        this.time = time;
    }
    
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Deque<Truck> queue = new ArrayDeque<>(); // 다리 건너고 있는 트럭
        
        int next_truck = 0;  // 대기 트럭 배열에서 사용할 인덱스
        int weights_sum = 0; // 다리를 건너는 트럭 무게의 합
        int total_time = 0; // 경과 시간
        
        int bridge_count = 0; // 다리를 건너는 트럭 수 
        
        while(next_truck < truck_weights.length || !queue.isEmpty()){
            
            // 시간 경과
            total_time++;
            
            // 다리 지나는 트럭 queue 에서 빼기 
            if(!queue.isEmpty() && queue.peek().time == total_time){
                Truck finishedTruck = queue.pollFirst();    
                weights_sum -= finishedTruck.weight;
            }
        
            // 다리를 지날 수 있는 경우    
            if(next_truck < truck_weights.length 
               && weights_sum + truck_weights[next_truck] <= weight
               && queue.size() < bridge_length){
            
                // 다리(큐)에 트럭 올리기
                queue.offerLast(new Truck(truck_weights[next_truck], total_time + bridge_length));
                weights_sum += truck_weights[next_truck];
                
                next_truck++;
            }
            
        }
        
        return total_time;
    }
}