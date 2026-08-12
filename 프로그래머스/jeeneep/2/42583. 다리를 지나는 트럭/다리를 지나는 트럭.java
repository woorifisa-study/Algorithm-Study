import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
       
        Queue<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        int time = 0;
        int bridgeWeight = 0;
        int truckIndex = 0;
        while (truckIndex < truck_weights.length) {
            
            bridgeWeight -= bridge.poll(); 
                        
            int truck = truck_weights[truckIndex];
            
            if (weight >= bridgeWeight + truck) { // 트럭 추가 가능
                bridge.offer(truck);
                truckIndex++;
                bridgeWeight += truck;
            }
            
            else bridge.offer(0);
            
            time++;
        }
        
        time += bridge_length; // 마지막 트럭이 다리를 빠져나오는 시간 처리
                
        return time;
    }
}